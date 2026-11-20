# BasefyWhappio Android SDK

BasefyWP Mobil API için Kotlin istemci kütüphanesi. WhatsApp sohbet, kişi ve etiket işlemlerini Android uygulamalarından yapmayı sağlar.

Bu kütüphane API'nin OpenAPI şemasından [OpenAPI Generator](https://openapi-generator.tech) (7.24.0) ile otomatik üretilmiştir.

## İçindekiler

- [Kurulum](#kurulum)
- [Hızlı başlangıç](#hızlı-başlangıç)
- [Kimlik doğrulama](#kimlik-doğrulama)
- [Yanıt biçimi ve hata kodları](#yanıt-biçimi-ve-hata-kodları)
- [Veri biçimleri](#veri-biçimleri)
- [Uç noktalar](#uç-noktalar)
- [Modeller](#modeller)

## Kurulum

SDK, [JitPack](https://jitpack.io) üzerinden dağıtılır.

**1.** `settings.gradle` dosyasındaki `repositories` bloğuna JitPack deposunu ekleyin:

```gradle
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

**2.** Modülün `build.gradle` dosyasına bağımlılığı ekleyin:

```gradle
implementation 'com.github.BasefyLab:basefywhappio-sdk-android:1.0.3'
```

**3.** Uygulamanın `AndroidManifest.xml` dosyasında internet izni olduğundan emin olun:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

## Hızlı başlangıç

SDK varsayılan olarak **canlı sunucuya** istek atar. Canlı ortam için adres vermenize gerek yoktur:

```kotlin
import com.basefywhappio.sdk.apis.AuthApi
import com.basefywhappio.sdk.apis.ConversationApi

val authApi = AuthApi()
val conversationApi = ConversationApi()
```

Test sunucusu gibi başka bir ortam kullanmak için adresi API sınıfına parametre olarak verin. Adresin sonuna `/` koymayın:

```kotlin
val authApi = AuthApi("https://<test-api-adresi>")
```

Adresi uygulamada tek bir yerde tutmanız önerilir. Örneğin `BuildConfig` içinde bir alan tanımlayıp debug ve release sürümlerine farklı değer verebilir, tüm API sınıflarına oradan geçebilirsiniz:

```kotlin
val authApi = AuthApi(BuildConfig.API_BASE_URL)
```

SDK metotları **senkron** çalışır, yani yanıt gelene kadar bekler. Android ana thread'de ağ isteğine izin vermediği için çağrıları arka planda yapın:

```kotlin
lifecycleScope.launch {
    val result = withContext(Dispatchers.IO) {
        conversationApi.conversationListGet(/* parametreler */)
    }
    if (result.success == true) {
        // result.data ile devam edin
    } else {
        // result.message kullanıcıya gösterilebilir
    }
}
```

Her metodun parametreleri ve dönüş tipi için [Uç noktalar](#uç-noktalar) tablosundaki bağlantılara bakın.

## Kimlik doğrulama

API, JWT tabanlı Bearer token kullanır. Her kullanıcı kendi Backoffice kullanıcı adı ve parolasıyla giriş yapar. Giriş bilgilerini uygulama koduna yazmayın, kullanıcıdan giriş ekranında alın.

### Giriş

`AuthApi.authLoginPost` ile token alın ve SDK'ya bir kere tanıtın. Sonraki tüm isteklere `Authorization: Bearer {token}` başlığı otomatik eklenir:

```kotlin
import com.basefywhappio.sdk.apis.AuthApi
import com.basefywhappio.sdk.infrastructure.ApiClient
import com.basefywhappio.sdk.models.LoginRequest

val result = withContext(Dispatchers.IO) {
    AuthApi().authLoginPost(LoginRequest(username = kullaniciAdi, password = parola))
}

val token = result.data?.token
if (result.success == true && token != null) {
    ApiClient.apiKey["Authorization"] = token
    ApiClient.apiKeyPrefix["Authorization"] = "Bearer"
    // Token'ı güvenli saklayın, aşağıya bakın.
} else {
    // Hatalı parola, kilitli veya pasif hesap
    hataGoster(result.message)
}
```

Hatalı parola, kilitli hesap, pasif hesap ya da işletmeye bağlı olmayan hesapta istisna fırlatılmaz. Yanıt HTTP 200 ile gelir, `success` alanı `false` olur ve `message` alanı kullanıcıya gösterilebilir. Art arda hatalı denemelerde bekleme süresi uygulanır ve hesap kilitlenebilir.

Giriş yanıtının `data` alanında kullanıcının bilgileri de gelir: `id`, `fullName`, `emailAddress`, `tenantId`, `userType` ve `permissions`. Bu bilgileri veren ayrı bir uç nokta yoktur. İhtiyacınız varsa girişte saklayın. `permissions` yalnızca menü ve buton göstermek içindir. Yetki her istekte sunucuda yeniden kontrol edilir.

### Token'ı saklama

Token uzun ömürlüdür (şu an 200 gün) ve yenileme (refresh) ucu yoktur. `ApiClient.apiKey` kalıcı değildir, uygulama kapanınca silinir. Kullanıcının her açılışta yeniden giriş yapmaması için:

1. Token'ı şifreli saklayın, örneğin Android Keystore ile şifrelenmiş bir depoda.
2. Uygulama açılırken saklanan token'ı yukarıdaki gibi `ApiClient.apiKey` ve `ApiClient.apiKeyPrefix` ile SDK'ya yeniden tanıtın.

Token `ApiClient` üzerinde global tutulur ve tüm API sınıfları aynı token'ı kullanır. Bu yapı, aynı anda tek kullanıcı oturumu olan uygulamalar için uygundur.

> ⚠️ OkHttp loglaması kullanıyorsanız `HttpLoggingInterceptor` seviyesini `HEADERS` veya `BODY` yapmayın. Bu seviyeler token'ı ve parolayı loglara yazar.

### Oturumun sona ermesi (HTTP 401)

Herhangi bir istek **HTTP 401** dönerse token geçersizdir, süresi dolmuştur ya da hesap pasiftir. SDK bu durumda `ClientException` fırlatır. Saklanan token'ı silip kullanıcıyı giriş ekranına yönlendirin:

```kotlin
import com.basefywhappio.sdk.infrastructure.ClientException

try {
    val tags = withContext(Dispatchers.IO) { tagApi.tagListGet() }
    // ...
} catch (e: ClientException) {
    if (e.statusCode == 401) {
        cikisYap()
        girisEkraninaGit()
    }
}
```

### Çıkış

Token'ı SDK'dan ve sakladığınız yerden silin:

```kotlin
ApiClient.apiKey.remove("Authorization")
ApiClient.apiKeyPrefix.remove("Authorization")
```

## Yanıt biçimi ve hata kodları

Tüm uç noktalar aynı zarf yapısını döner:

```json
{ "success": true, "message": "...", "data": { } }
```

| Durum | Anlamı | Ne yapılmalı |
|---|---|---|
| HTTP 200, `success: true` | İşlem başarılı | `data` alanını kullanın |
| HTTP 200, `success: false` | İş kuralı hatası (ör. "Etiket bulunamadı") | `message` doğrudan kullanıcıya gösterilebilir |
| HTTP 401 | Token geçersiz, süresi dolmuş ya da hesap pasif | Yeniden giriş yaptırın |
| HTTP 403 | Yetki yok ya da işletmenin WhatsApp kurulumu tamamlanmamış | Kullanıcıyı bilgilendirin |
| HTTP 500 | Beklenmeyen sunucu hatası | Yanıttaki hata kodunu destek ekibine iletin |

HTTP 4xx ve 5xx yanıtlarında SDK bir istisna (exception) fırlatır. Çağrılarınızı `try/catch` ile sarın.

## Veri biçimleri

- **Tarihler:** Mesaj tarihleri Unix zaman damgasıdır, milisaniye cinsinden.
- **Telefon numaraları:** Ülke kodu dahil, yalnızca rakam. Örnek: `905321112233`
- **Enum alanları:** Sayı olarak gönderilir ve alınır. Her değerin anlamı ilgili modelin dokümanında yazar.
- **Sayfalama:** Sayfalı listelerde `currentPage` 1'den başlar. Mesaj geçmişi ise imleç (cursor) ile sayfalanır.

## Uç noktalar

### Giriş (AuthApi)

| Metot | İstek | Açıklama |
|---|---|---|
| [authLoginPost](docs/AuthApi.md#authloginpost) | `POST /auth/login` | Kullanıcı adı ve parola ile giriş yapar, JWT döner. |

### Kişiler (ContactApi)

| Metot | İstek | Açıklama |
|---|---|---|
| [contactListGet](docs/ContactApi.md#contactlistget) | `GET /contact/list` | İşletmenin kişilerini sayfalı listeler. |
| [contactDetailGet](docs/ContactApi.md#contactdetailget) | `GET /contact/detail` | Kişinin tüm bilgilerini döner (düzenleme formu bu verilerle doldurulur). |
| [contactCreatePost](docs/ContactApi.md#contactcreatepost) | `POST /contact/create` | Yeni kişi ekler. |
| [contactUpdatePost](docs/ContactApi.md#contactupdatepost) | `POST /contact/update` | Kişi bilgilerini günceller. |
| [contactDeletePost](docs/ContactApi.md#contactdeletepost) | `POST /contact/delete` | Kişiyi siler. |
| [contactBlockPost](docs/ContactApi.md#contactblockpost) | `POST /contact/block` | Kişiyi WhatsApp'ta engeller veya engelini kaldırır. |
| [contactCitiesGet](docs/ContactApi.md#contactcitiesget) | `GET /contact/cities` | Kişi formundaki şehir seçimi için şehirleri listeler. |

### Sohbetler (ConversationApi)

> ⚠️ `send`, `sendmedia` ve `sendfeedback` uç noktaları müşteriye **gerçek WhatsApp mesajı** gönderir. Test ederken dikkatli olun.

| Metot | İstek | Açıklama |
|---|---|---|
| [conversationListGet](docs/ConversationApi.md#conversationlistget) | `GET /conversation/list` | Sohbet listesi: her müşteri için son mesaj, okunmadı durumu, kişi ve ticket bilgisi. |
| [conversationMessagesGet](docs/ConversationApi.md#conversationmessagesget) | `GET /conversation/messages` | Bir sohbetin mesaj geçmişi (imleçli sayfalama). |
| [conversationSendPost](docs/ConversationApi.md#conversationsendpost) | `POST /conversation/send` | Müşteriye metin veya konum mesajı gönderir. |
| [conversationSendmediaPost](docs/ConversationApi.md#conversationsendmediapost) | `POST /conversation/sendmedia` | Müşteriye resim, video, ses veya PDF gönderir. |
| [conversationSendfeedbackPost](docs/ConversationApi.md#conversationsendfeedbackpost) | `POST /conversation/sendfeedback` | Müşteriye memnuniyet puanlama mesajı gönderir. |
| [conversationWindowGet](docs/ConversationApi.md#conversationwindowget) | `GET /conversation/window` | WhatsApp 24 saat mesaj penceresinin durumu. |
| [conversationMarkasreadPost](docs/ConversationApi.md#conversationmarkasreadpost) | `POST /conversation/markasread` | Sohbeti okundu olarak işaretler (okunmadı rozeti kalkar). |
| [conversationMarkasunreadPost](docs/ConversationApi.md#conversationmarkasunreadpost) | `POST /conversation/markasunread` | Sohbeti okunmadı olarak işaretler (okunmadı rozeti görünür). |
| [conversationAssignableusersGet](docs/ConversationApi.md#conversationassignableusersget) | `GET /conversation/assignableusers` | Sohbetin atanabileceği temsilcileri listeler. |
| [conversationAssignPost](docs/ConversationApi.md#conversationassignpost) | `POST /conversation/assign` | Sohbeti başka bir temsilciye atar. |
| [conversationAssigntomePost](docs/ConversationApi.md#conversationassigntomepost) | `POST /conversation/assigntome` | Sohbeti giriş yapan temsilcinin üzerine alır. |
| [conversationChatbotGet](docs/ConversationApi.md#conversationchatbotget) | `GET /conversation/chatbot` | Sohbette AI chatbot'un açık olup olmadığını döner. |
| [conversationChatbotPost](docs/ConversationApi.md#conversationchatbotpost) | `POST /conversation/chatbot` | Sohbette AI chatbot'u açar veya kapatır. |
| [conversationTerminatePost](docs/ConversationApi.md#conversationterminatepost) | `POST /conversation/terminate` | Görüşmeyi sonlandırır (ticket'ı kapatır). |

### Etiketler (TagApi)

| Metot | İstek | Açıklama |
|---|---|---|
| [tagListGet](docs/TagApi.md#taglistget) | `GET /tag/list` | İşletmenin etiketlerini sayfalı listeler. |
| [tagCreatePost](docs/TagApi.md#tagcreatepost) | `POST /tag/create` | Yeni etiket ekler. |
| [tagUpdatePost](docs/TagApi.md#tagupdatepost) | `POST /tag/update` | Etiketin adını ve açıklamasını günceller. |
| [tagDeletePost](docs/TagApi.md#tagdeletepost) | `POST /tag/delete` | Etiketi siler. |
| [tagContacttagsGet](docs/TagApi.md#tagcontacttagsget) | `GET /tag/contacttags` | Kişinin etiket ekranı: işletmenin tüm etiketleri, kişiye ekli olanlar işaretli. |
| [tagAddcontacttagPost](docs/TagApi.md#tagaddcontacttagpost) | `POST /tag/addcontacttag` | Kişiye etiket ekler. |
| [tagRemovecontacttagPost](docs/TagApi.md#tagremovecontacttagpost) | `POST /tag/removecontacttag` | Kişiden etiketi kaldırır. |

### Kullanıcı durumu (MeApi)

| Metot | İstek | Açıklama |
|---|---|---|
| [meStatusGet](docs/MeApi.md#mestatusget) | `GET /me/status` | Kullanıcının çevrimiçi olup olmadığını döner. |
| [meStatusPost](docs/MeApi.md#mestatuspost) | `POST /me/status` | Kullanıcıyı çevrimiçi veya çevrimdışı yapar. |

### Canlı bağlantı (RealtimeApi)

| Metot | İstek | Açıklama |
|---|---|---|
| [realtimeTokenGet](docs/RealtimeApi.md#realtimetokenget) | `GET /realtime/token` | Canlı mesaj bağlantısı (SignalR hub) için 24 saat geçerli token üretir. |

## Modeller

Tüm modeller `com.basefywhappio.sdk.models` paketindedir. `...ApiReturn` ile biten tipler, [yanıt zarfının](#yanıt-biçimi-ve-hata-kodları) ilgili veri tipiyle doldurulmuş halidir. `...Paged` ile biten tipler sayfalı liste sonucudur.

**Giriş:** [LoginRequest](docs/LoginRequest.md), [LoginResponse](docs/LoginResponse.md), [LoginResponseApiReturn](docs/LoginResponseApiReturn.md)

**Kişiler:** [ContactListItemDto](docs/ContactListItemDto.md), [ContactListItemDtoPaged](docs/ContactListItemDtoPaged.md), [ContactListItemDtoPagedApiReturn](docs/ContactListItemDtoPagedApiReturn.md), [ContactDetailDto](docs/ContactDetailDto.md), [ContactDetailDtoApiReturn](docs/ContactDetailDtoApiReturn.md), [CreateContactCommand](docs/CreateContactCommand.md), [UpdateContactCommand](docs/UpdateContactCommand.md), [DeleteContactCommand](docs/DeleteContactCommand.md), [SetContactBlockedCommand](docs/SetContactBlockedCommand.md), [CityDto](docs/CityDto.md), [CityDtoListApiReturn](docs/CityDtoListApiReturn.md), [PhoneNumberRequest](docs/PhoneNumberRequest.md)

**Sohbetler:** [ConversationListItemDto](docs/ConversationListItemDto.md), [ConversationListItemDtoPaged](docs/ConversationListItemDtoPaged.md), [ConversationListItemDtoPagedApiReturn](docs/ConversationListItemDtoPagedApiReturn.md), [ConversationContactDto](docs/ConversationContactDto.md), [ConversationLastMessageDto](docs/ConversationLastMessageDto.md), [ConversationTicketDto](docs/ConversationTicketDto.md), [ConversationMessageDto](docs/ConversationMessageDto.md), [ConversationMessagesDto](docs/ConversationMessagesDto.md), [ConversationMessagesDtoApiReturn](docs/ConversationMessagesDtoApiReturn.md), [RepliedMessageDto](docs/RepliedMessageDto.md), [SendConversationMessageCommand](docs/SendConversationMessageCommand.md), [SendFeedbackMessageCommand](docs/SendFeedbackMessageCommand.md), [ChatWindowDto](docs/ChatWindowDto.md), [ChatWindowDtoApiReturn](docs/ChatWindowDtoApiReturn.md), [AssignConversationCommand](docs/AssignConversationCommand.md), [AssignConversationToMeCommand](docs/AssignConversationToMeCommand.md), [AssignableUserDto](docs/AssignableUserDto.md), [AssignableUserDtoListApiReturn](docs/AssignableUserDtoListApiReturn.md), [SetChatBotCommand](docs/SetChatBotCommand.md), [TerminateConversationCommand](docs/TerminateConversationCommand.md)

**Etiketler:** [TagDto](docs/TagDto.md), [TagDtoApiReturn](docs/TagDtoApiReturn.md), [TagDtoPaged](docs/TagDtoPaged.md), [TagDtoPagedApiReturn](docs/TagDtoPagedApiReturn.md), [ContactTagDto](docs/ContactTagDto.md), [ContactTagDtoListApiReturn](docs/ContactTagDtoListApiReturn.md), [CreateTagCommand](docs/CreateTagCommand.md), [UpdateTagCommand](docs/UpdateTagCommand.md), [DeleteTagCommand](docs/DeleteTagCommand.md), [AddContactTagCommand](docs/AddContactTagCommand.md), [RemoveContactTagCommand](docs/RemoveContactTagCommand.md)

**Kullanıcı ve canlı bağlantı:** [SetMyStatusCommand](docs/SetMyStatusCommand.md), [RealtimeTokenDto](docs/RealtimeTokenDto.md), [RealtimeTokenDtoApiReturn](docs/RealtimeTokenDtoApiReturn.md)

**Ortak:** [BooleanApiReturn](docs/BooleanApiReturn.md)

**Enum'lar:** [Gender](docs/Gender.md), [IsAcceptPublications](docs/IsAcceptPublications.md), [LanguageType](docs/LanguageType.md), [MessageSenderType](docs/MessageSenderType.md), [MessageType](docs/MessageType.md), [TicketStatus](docs/TicketStatus.md), [UserType](docs/UserType.md)
