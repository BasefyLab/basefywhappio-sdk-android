# ConversationApi

All URIs are relative to *https://api.whappio.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**conversationAssignPost**](ConversationApi.md#conversationAssignPost) | **POST** /conversation/assign | Sohbeti başka bir temsilciye atar. |
| [**conversationAssignableusersGet**](ConversationApi.md#conversationAssignableusersGet) | **GET** /conversation/assignableusers | Sohbetin atanabileceği temsilciler. |
| [**conversationAssigntomePost**](ConversationApi.md#conversationAssigntomePost) | **POST** /conversation/assigntome | Sohbeti giriş yapan temsilcinin üzerine alır. |
| [**conversationChatbotGet**](ConversationApi.md#conversationChatbotGet) | **GET** /conversation/chatbot | Sohbette AI chatbot&#39;un açık olup olmadığını döner. |
| [**conversationChatbotPost**](ConversationApi.md#conversationChatbotPost) | **POST** /conversation/chatbot | Sohbette AI chatbot&#39;u açar veya kapatır. |
| [**conversationListGet**](ConversationApi.md#conversationListGet) | **GET** /conversation/list | Sohbet listesi: her müşteri için son mesaj, okunmadı durumu, kişi ve ticket bilgisi. |
| [**conversationMarkasreadPost**](ConversationApi.md#conversationMarkasreadPost) | **POST** /conversation/markasread | Sohbeti okundu olarak işaretler (okunmadı rozeti kalkar). |
| [**conversationMarkasunreadPost**](ConversationApi.md#conversationMarkasunreadPost) | **POST** /conversation/markasunread | Sohbeti okunmadı olarak işaretler (okunmadı rozeti görünür). |
| [**conversationMessagesGet**](ConversationApi.md#conversationMessagesGet) | **GET** /conversation/messages | Bir sohbetin mesaj geçmişi (imleçli sayfalama). |
| [**conversationSendPost**](ConversationApi.md#conversationSendPost) | **POST** /conversation/send | Müşteriye metin veya konum mesajı gönderir. GERÇEK WhatsApp mesajı gider. |
| [**conversationSendfeedbackPost**](ConversationApi.md#conversationSendfeedbackPost) | **POST** /conversation/sendfeedback | Müşteriye geri bildirim (memnuniyet puanlama) mesajı gönderir. GERÇEK WhatsApp mesajı gider. |
| [**conversationSendmediaPost**](ConversationApi.md#conversationSendmediaPost) | **POST** /conversation/sendmedia | Müşteriye resim, video, ses veya PDF gönderir. GERÇEK WhatsApp mesajı gider. |
| [**conversationTerminatePost**](ConversationApi.md#conversationTerminatePost) | **POST** /conversation/terminate | Görüşmeyi sonlandırır (ticket&#39;ı kapatır). |
| [**conversationWindowGet**](ConversationApi.md#conversationWindowGet) | **GET** /conversation/window | WhatsApp 24 saat mesaj penceresinin durumu. |


<a id="conversationAssignPost"></a>
# **conversationAssignPost**
> BooleanApiReturn conversationAssignPost(assignConversationCommand)

Sohbeti başka bir temsilciye atar.

Yalnızca size atanmış sohbet başkasına devredilebilir. &#x60;userId&#x60; conversation/assignableusers listesinden  seçilir; açık ekranlar canlı bağlantıda &#x60;assign&#x60; olayıyla güncellenir. Sohbet size atanmamışsa veya temsilci  bulunamazsa &#x60;success:false&#x60;. &#x60;data&#x60; &#x3D; true.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ConversationApi()
val assignConversationCommand : AssignConversationCommand =  // AssignConversationCommand | 
try {
    val result : BooleanApiReturn = apiInstance.conversationAssignPost(assignConversationCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConversationApi#conversationAssignPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConversationApi#conversationAssignPost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **assignConversationCommand** | [**AssignConversationCommand**](AssignConversationCommand.md)|  | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="conversationAssignableusersGet"></a>
# **conversationAssignableusersGet**
> AssignableUserDtoListApiReturn conversationAssignableusersGet()

Sohbetin atanabileceği temsilciler.

Aynı işletmenin şu an çevrimiçi ve aktif temsilcileri; giriş yapan kullanıcı listede yer almaz  (kendine atamak için conversation/assigntome). Parametre almaz.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ConversationApi()
try {
    val result : AssignableUserDtoListApiReturn = apiInstance.conversationAssignableusersGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConversationApi#conversationAssignableusersGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConversationApi#conversationAssignableusersGet")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**AssignableUserDtoListApiReturn**](AssignableUserDtoListApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

<a id="conversationAssigntomePost"></a>
# **conversationAssigntomePost**
> BooleanApiReturn conversationAssigntomePost(assignConversationToMeCommand)

Sohbeti giriş yapan temsilcinin üzerine alır.

Kullanıcı çevrimiçi olmalıdır; çevrimdışıysa &#x60;success:false&#x60; döner. Açık ekranlar &#x60;assign&#x60; olayıyla güncellenir.  &#x60;data&#x60; &#x3D; true.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ConversationApi()
val assignConversationToMeCommand : AssignConversationToMeCommand =  // AssignConversationToMeCommand | 
try {
    val result : BooleanApiReturn = apiInstance.conversationAssigntomePost(assignConversationToMeCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConversationApi#conversationAssigntomePost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConversationApi#conversationAssigntomePost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **assignConversationToMeCommand** | [**AssignConversationToMeCommand**](AssignConversationToMeCommand.md)|  | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="conversationChatbotGet"></a>
# **conversationChatbotGet**
> BooleanApiReturn conversationChatbotGet(phoneNumber)

Sohbette AI chatbot&#39;un açık olup olmadığını döner.

&#x60;data&#x60; &#x3D; true: AI bu müşteriye otomatik cevap verir. false: AI susar, sohbet temsilcidedir.  Numara kişilerde kayıtlı değilse varsayılan olarak true döner.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ConversationApi()
val phoneNumber : kotlin.String = phoneNumber_example // kotlin.String | Müşterinin telefonu (conversation/list içindeki phoneNumber).
try {
    val result : BooleanApiReturn = apiInstance.conversationChatbotGet(phoneNumber)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConversationApi#conversationChatbotGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConversationApi#conversationChatbotGet")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **phoneNumber** | **kotlin.String**| Müşterinin telefonu (conversation/list içindeki phoneNumber). | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

<a id="conversationChatbotPost"></a>
# **conversationChatbotPost**
> BooleanApiReturn conversationChatbotPost(setChatBotCommand)

Sohbette AI chatbot&#39;u açar veya kapatır.

&#x60;isActive&#x60; istenen durumdur (açma/kapama değiştirme değil; tekrar göndermek durumu geri çevirmez).  Ayar kişi kaydında tutulduğu için numara kişilerde kayıtlı değilse &#x60;success:false&#x60; döner.  &#x60;data&#x60; &#x3D; yeni durum.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ConversationApi()
val setChatBotCommand : SetChatBotCommand =  // SetChatBotCommand | 
try {
    val result : BooleanApiReturn = apiInstance.conversationChatbotPost(setChatBotCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConversationApi#conversationChatbotPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConversationApi#conversationChatbotPost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **setChatBotCommand** | [**SetChatBotCommand**](SetChatBotCommand.md)|  | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="conversationListGet"></a>
# **conversationListGet**
> ConversationListItemDtoPagedApiReturn conversationListGet(currentPage, pageSize)

Sohbet listesi: her müşteri için son mesaj, okunmadı durumu, kişi ve ticket bilgisi.

En son yazışılan sohbet önce gelir. Her satırdaki &#x60;phoneNumber&#x60; sohbetin kimliğidir ve diğer tüm  conversation uçlarına bu değer gönderilir. Numara kişilerde kayıtlı değilse &#x60;contact&#x60; null,  sohbet hiç ticket&#39;a dönüşmemişse &#x60;ticket&#x60; null gelir. Toplu (kampanya) gönderimler listede yer almaz.                Liste açıkken yeni mesajlar için realtime/token ile canlı bağlantı kurulur; tekrar tekrar istek atmaya gerek yoktur.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ConversationApi()
val currentPage : kotlin.Int = 56 // kotlin.Int | İstenen sayfa (1'den başlar). Varsayılan: 1.
val pageSize : kotlin.Int = 56 // kotlin.Int | Sayfa başına kayıt. Varsayılan: 20, en fazla: 100.
try {
    val result : ConversationListItemDtoPagedApiReturn = apiInstance.conversationListGet(currentPage, pageSize)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConversationApi#conversationListGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConversationApi#conversationListGet")
    e.printStackTrace()
}
```

### Parameters
| **currentPage** | **kotlin.Int**| İstenen sayfa (1&#39;den başlar). Varsayılan: 1. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **pageSize** | **kotlin.Int**| Sayfa başına kayıt. Varsayılan: 20, en fazla: 100. | [optional] |

### Return type

[**ConversationListItemDtoPagedApiReturn**](ConversationListItemDtoPagedApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

<a id="conversationMarkasreadPost"></a>
# **conversationMarkasreadPost**
> BooleanApiReturn conversationMarkasreadPost(phoneNumberRequest)

Sohbeti okundu olarak işaretler (okunmadı rozeti kalkar).

İşaret web panelle ortaktır. Müşteriden yeni mesaj geldiğinde işaret sıfırlanır ve rozet yeniden görünür.  Numara kişilerde kayıtlı değilse işaret saklanamaz ama hata dönmez. &#x60;data&#x60; &#x3D; true.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ConversationApi()
val phoneNumberRequest : PhoneNumberRequest =  // PhoneNumberRequest | 
try {
    val result : BooleanApiReturn = apiInstance.conversationMarkasreadPost(phoneNumberRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConversationApi#conversationMarkasreadPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConversationApi#conversationMarkasreadPost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **phoneNumberRequest** | [**PhoneNumberRequest**](PhoneNumberRequest.md)|  | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="conversationMarkasunreadPost"></a>
# **conversationMarkasunreadPost**
> BooleanApiReturn conversationMarkasunreadPost(phoneNumberRequest)

Sohbeti okunmadı olarak işaretler (okunmadı rozeti görünür).

İşaret web panelle ortaktır. &#x60;data&#x60; &#x3D; true.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ConversationApi()
val phoneNumberRequest : PhoneNumberRequest =  // PhoneNumberRequest | 
try {
    val result : BooleanApiReturn = apiInstance.conversationMarkasunreadPost(phoneNumberRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConversationApi#conversationMarkasunreadPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConversationApi#conversationMarkasunreadPost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **phoneNumberRequest** | [**PhoneNumberRequest**](PhoneNumberRequest.md)|  | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="conversationMessagesGet"></a>
# **conversationMessagesGet**
> ConversationMessagesDtoApiReturn conversationMessagesGet(phoneNumber, beforeDate, beforeId, pageSize)

Bir sohbetin mesaj geçmişi (imleçli sayfalama).

Mesajlar sayfa içinde eskiden yeniye sıralıdır.                1. İlk istekte yalnızca &#x60;phoneNumber&#x60; (ve isteğe bağlı &#x60;pageSize&#x60;) gönderilir: en yeni mesajlar gelir.  2. Kullanıcı yukarı kaydırdığında, yanıttaki &#x60;nextBeforeDate&#x60; ve &#x60;nextBeforeId&#x60; değerleri &#x60;beforeDate&#x60;     ve &#x60;beforeId&#x60; olarak gönderilir: bir önceki (daha eski) sayfa gelir.  3. &#x60;hasMore&#x60; false olduğunda sohbetin başına gelinmiştir.                Otomasyonların bıraktığı iç notlar da &#x60;isInternalNote&#x60; &#x3D; true olarak araya karışık gelir (müşteri görmez).

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ConversationApi()
val phoneNumber : kotlin.String = phoneNumber_example // kotlin.String | Müşterinin telefonu (conversation/list içindeki phoneNumber).
val beforeDate : kotlin.Long = 789 // kotlin.Long | İlk istekte boş bırakılır (en yeni mesajlar). Daha eskiler için önceki yanıttaki nextBeforeDate gönderilir.
val beforeId : kotlin.Int = 56 // kotlin.Int | beforeDate ile birlikte, önceki yanıttaki nextBeforeId gönderilir.
val pageSize : kotlin.Int = 56 // kotlin.Int | Sayfa başına mesaj. Varsayılan: 20, en fazla: 50.
try {
    val result : ConversationMessagesDtoApiReturn = apiInstance.conversationMessagesGet(phoneNumber, beforeDate, beforeId, pageSize)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConversationApi#conversationMessagesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConversationApi#conversationMessagesGet")
    e.printStackTrace()
}
```

### Parameters
| **phoneNumber** | **kotlin.String**| Müşterinin telefonu (conversation/list içindeki phoneNumber). | [optional] |
| **beforeDate** | **kotlin.Long**| İlk istekte boş bırakılır (en yeni mesajlar). Daha eskiler için önceki yanıttaki nextBeforeDate gönderilir. | [optional] |
| **beforeId** | **kotlin.Int**| beforeDate ile birlikte, önceki yanıttaki nextBeforeId gönderilir. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **pageSize** | **kotlin.Int**| Sayfa başına mesaj. Varsayılan: 20, en fazla: 50. | [optional] |

### Return type

[**ConversationMessagesDtoApiReturn**](ConversationMessagesDtoApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

<a id="conversationSendPost"></a>
# **conversationSendPost**
> BooleanApiReturn conversationSendPost(sendConversationMessageCommand)

Müşteriye metin veya konum mesajı gönderir. GERÇEK WhatsApp mesajı gider.

- Metin mesajı: &#x60;text&#x60; dolu; &#x60;latitude&#x60;, &#x60;longitude&#x60;, &#x60;externalIdOfReplied&#x60; null.  - Konum mesajı: &#x60;latitude&#x60; ve &#x60;longitude&#x60; birlikte, nokta ondalıklı sayı olarak (\&quot;41.0082\&quot;, \&quot;28.9784\&quot;).  - Yanıt (alıntı): &#x60;externalIdOfReplied&#x60; &#x3D; yanıtlanan mesajın &#x60;externalId&#x60; değeri.                Sohbet size atanmış olmalıdır (değilse önce conversation/assigntome). 24 saat penceresi kapalıysa &#x60;success:false&#x60; döner (bkz. conversation/window). Gönderilen mesaj canlı  bağlantıda &#x60;receiveMessage&#x60; olayıyla da gelir; listeye eklemek için o olay beklenebilir. &#x60;data&#x60; &#x3D; true.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ConversationApi()
val sendConversationMessageCommand : SendConversationMessageCommand =  // SendConversationMessageCommand | 
try {
    val result : BooleanApiReturn = apiInstance.conversationSendPost(sendConversationMessageCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConversationApi#conversationSendPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConversationApi#conversationSendPost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **sendConversationMessageCommand** | [**SendConversationMessageCommand**](SendConversationMessageCommand.md)|  | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="conversationSendfeedbackPost"></a>
# **conversationSendfeedbackPost**
> BooleanApiReturn conversationSendfeedbackPost(sendFeedbackMessageCommand)

Müşteriye geri bildirim (memnuniyet puanlama) mesajı gönderir. GERÇEK WhatsApp mesajı gider.

Web&#39;deki \&quot;Geri bildirim mesajı gönder\&quot; işlemi.                - İşletmenin tanımlı NPS liste mesajı kişinin dilinde (yoksa işletmenin varsayılan dilinde) gönderilir;    tanımlı mesaj yoksa &#x60;success:false&#x60;.  - Gönderim sonrası ticket durumu \&quot;Kapanış bekliyor\&quot; (3) olur; açık ekranlar &#x60;updateTicketStatus&#x60; olayıyla güncellenir.  - Müşterinin verdiği puan otomatik işlenir; otomatik kapatma açıksa görüşme sistem tarafından kapatılır.  - Sohbet size atanmış olmalı ve 24 saat penceresi açık olmalıdır; değilse &#x60;success:false&#x60;.                &#x60;data&#x60; &#x3D; true.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ConversationApi()
val sendFeedbackMessageCommand : SendFeedbackMessageCommand =  // SendFeedbackMessageCommand | 
try {
    val result : BooleanApiReturn = apiInstance.conversationSendfeedbackPost(sendFeedbackMessageCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConversationApi#conversationSendfeedbackPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConversationApi#conversationSendfeedbackPost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **sendFeedbackMessageCommand** | [**SendFeedbackMessageCommand**](SendFeedbackMessageCommand.md)|  | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="conversationSendmediaPost"></a>
# **conversationSendmediaPost**
> BooleanApiReturn conversationSendmediaPost(phoneNumber, file, caption, externalIdOfReplied)

Müşteriye resim, video, ses veya PDF gönderir. GERÇEK WhatsApp mesajı gider.

&#x60;multipart/form-data&#x60; ile gönderilir: &#x60;phoneNumber&#x60; ve &#x60;file&#x60; zorunlu, &#x60;caption&#x60; ve &#x60;externalIdOfReplied&#x60; opsiyonel.                | Tür | Uzantı | En fazla |  |---|---|---|  | Resim | jpg, jpeg, png | 5 MB |  | Video | mp4 | 16 MB |  | Ses | mp3, m4a | 16 MB |  | Doküman | pdf | 16 MB |                - &#x60;caption&#x60; yalnızca resim ve videoda müşteriye gider; WhatsApp ses ve PDF&#39;te açıklama taşımaz.  - PDF müşterinin WhatsApp&#39;ında yüklenen dosyanın adıyla görünür.  - Sohbet size atanmış olmalıdır (değilse önce conversation/assigntome).  - Desteklenmeyen tür, büyük dosya, size atanmamış sohbet veya kapalı 24 saat penceresinde &#x60;success:false&#x60; döner.  - Gönderilen mesaj canlı bağlantıda &#x60;receiveMessage&#x60; olayıyla gelir (&#x60;MediaContentUrl&#x60; dolu). &#x60;data&#x60; &#x3D; true.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ConversationApi()
val phoneNumber : kotlin.String = phoneNumber_example // kotlin.String | Müşterinin telefonu (conversation/list içindeki phoneNumber).
val file : java.io.File = BINARY_DATA_HERE // java.io.File | Gönderilecek dosya (jpg, jpeg, png, mp4, mp3, m4a, pdf).
val caption : kotlin.String = caption_example // kotlin.String | Resim/video altındaki açıklama. Opsiyonel; ses ve PDF'te müşteriye gitmez.
val externalIdOfReplied : kotlin.String = externalIdOfReplied_example // kotlin.String | Bir mesaja yanıt veriliyorsa o mesajın externalId'si. Yanıt değilse boş bırakılır.
try {
    val result : BooleanApiReturn = apiInstance.conversationSendmediaPost(phoneNumber, file, caption, externalIdOfReplied)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConversationApi#conversationSendmediaPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConversationApi#conversationSendmediaPost")
    e.printStackTrace()
}
```

### Parameters
| **phoneNumber** | **kotlin.String**| Müşterinin telefonu (conversation/list içindeki phoneNumber). | [optional] |
| **file** | **java.io.File**| Gönderilecek dosya (jpg, jpeg, png, mp4, mp3, m4a, pdf). | [optional] |
| **caption** | **kotlin.String**| Resim/video altındaki açıklama. Opsiyonel; ses ve PDF&#39;te müşteriye gitmez. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **externalIdOfReplied** | **kotlin.String**| Bir mesaja yanıt veriliyorsa o mesajın externalId&#39;si. Yanıt değilse boş bırakılır. | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: text/plain, application/json

<a id="conversationTerminatePost"></a>
# **conversationTerminatePost**
> BooleanApiReturn conversationTerminatePost(terminateConversationCommand)

Görüşmeyi sonlandırır (ticket&#39;ı kapatır).

- Sohbetin son ticket&#39;ı kapatılır ve temsilci ataması kaldırılır.  - \&quot;Temsilciye devredildi\&quot; etiketi kişiden kaldırılır; müşteri yeniden yazdığında akış baştan başlar.  - İşletmenin tanımlı bir kapanış hazır mesajı varsa ve 24 saat penceresi açıksa bu mesaj müşteriye    GERÇEKTEN gönderilir.  - Açık ekranlar &#x60;updateTicketStatus&#x60; ve &#x60;assign&#x60; olaylarıyla güncellenir.                Sohbet size atanmış olmalıdır. Ticket zaten kapalıysa hiçbir şey yapmadan &#x60;data&#x60; &#x3D; true döner. Sohbette hiç  ticket yoksa veya sohbet size atanmamışsa &#x60;success:false&#x60;.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ConversationApi()
val terminateConversationCommand : TerminateConversationCommand =  // TerminateConversationCommand | 
try {
    val result : BooleanApiReturn = apiInstance.conversationTerminatePost(terminateConversationCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConversationApi#conversationTerminatePost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConversationApi#conversationTerminatePost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **terminateConversationCommand** | [**TerminateConversationCommand**](TerminateConversationCommand.md)|  | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="conversationWindowGet"></a>
# **conversationWindowGet**
> ChatWindowDtoApiReturn conversationWindowGet(phoneNumber)

WhatsApp 24 saat mesaj penceresinin durumu.

WhatsApp, işletmenin müşteriye serbest mesaj atmasına yalnızca müşterinin son mesajından sonraki 24 saat  içinde izin verir. &#x60;isOpen&#x60; false ise conversation/send reddedilir; mesaj kutusu kapatılmalıdır.  &#x60;remainingSeconds&#x60; ile geri sayım gösterilebilir. Müşteriden yeni mesaj geldiğinde pencere yeniden açılır.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ConversationApi()
val phoneNumber : kotlin.String = phoneNumber_example // kotlin.String | Müşterinin telefonu (conversation/list içindeki phoneNumber).
try {
    val result : ChatWindowDtoApiReturn = apiInstance.conversationWindowGet(phoneNumber)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConversationApi#conversationWindowGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConversationApi#conversationWindowGet")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **phoneNumber** | **kotlin.String**| Müşterinin telefonu (conversation/list içindeki phoneNumber). | [optional] |

### Return type

[**ChatWindowDtoApiReturn**](ChatWindowDtoApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

