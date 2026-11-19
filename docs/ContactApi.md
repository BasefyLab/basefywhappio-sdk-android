# ContactApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**contactBlockPost**](ContactApi.md#contactBlockPost) | **POST** /contact/block | Kişiyi WhatsApp&#39;ta engeller veya engelini kaldırır. |
| [**contactCitiesGet**](ContactApi.md#contactCitiesGet) | **GET** /contact/cities | Kişi formundaki şehir seçimi için şehirleri listeler. |
| [**contactCreatePost**](ContactApi.md#contactCreatePost) | **POST** /contact/create | Yeni kişi ekler. |
| [**contactDeletePost**](ContactApi.md#contactDeletePost) | **POST** /contact/delete | Kişiyi siler. |
| [**contactDetailGet**](ContactApi.md#contactDetailGet) | **GET** /contact/detail | Kişinin tüm bilgilerini döner (düzenleme formu bu verilerle doldurulur). |
| [**contactListGet**](ContactApi.md#contactListGet) | **GET** /contact/list | İşletmenin kişilerini sayfalı listeler. |
| [**contactUpdatePost**](ContactApi.md#contactUpdatePost) | **POST** /contact/update | Kişi bilgilerini günceller. |


<a id="contactBlockPost"></a>
# **contactBlockPost**
> BooleanApiReturn contactBlockPost(setContactBlockedCommand)

Kişiyi WhatsApp&#39;ta engeller veya engelini kaldırır.

Yetki: &#x60;contactspermission&#x60;. Engelli kişiden işletmeye mesaj gelmez.                - &#x60;isBlocked&#x60; istenen durumdur (true &#x3D; engelle, false &#x3D; engeli kaldır); kişi zaten o durumdaysa hiçbir    işlem yapılmadan &#x60;data&#x60; &#x3D; true döner.  - İşlem WhatsApp (GupShup) tarafında yapılır ve başarısız olursa kişi değişmez, &#x60;success:false&#x60; döner.    WhatsApp kuralı gereği genellikle yalnızca son 24 saatte işletmeye yazmış müşteriler engellenebilir.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ContactApi()
val setContactBlockedCommand : SetContactBlockedCommand =  // SetContactBlockedCommand | 
try {
    val result : BooleanApiReturn = apiInstance.contactBlockPost(setContactBlockedCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#contactBlockPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#contactBlockPost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **setContactBlockedCommand** | [**SetContactBlockedCommand**](SetContactBlockedCommand.md)|  | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="contactCitiesGet"></a>
# **contactCitiesGet**
> CityDtoListApiReturn contactCitiesGet(Q)

Kişi formundaki şehir seçimi için şehirleri listeler.

Yetki: &#x60;contactspermission&#x60;. &#x60;q&#x60; şehir adında veya plaka kodunda arar (ör. \&quot;ist\&quot;, \&quot;34\&quot;); boşsa tüm  şehirler alfabetik döner. Sayfalanmaz.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ContactApi()
val Q : kotlin.String = Q_example // kotlin.String | Şehir adında veya plaka kodunda geçen metin (ör. \"ist\" veya \"34\"). Boş bırakılırsa tüm şehirler.
try {
    val result : CityDtoListApiReturn = apiInstance.contactCitiesGet(Q)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#contactCitiesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#contactCitiesGet")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **Q** | **kotlin.String**| Şehir adında veya plaka kodunda geçen metin (ör. \&quot;ist\&quot; veya \&quot;34\&quot;). Boş bırakılırsa tüm şehirler. | [optional] |

### Return type

[**CityDtoListApiReturn**](CityDtoListApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

<a id="contactCreatePost"></a>
# **contactCreatePost**
> ContactDetailDtoApiReturn contactCreatePost(createContactCommand)

Yeni kişi ekler.

Yetki: &#x60;contactspermission&#x60;. Zorunlu alanlar: &#x60;fullName&#x60;, &#x60;phoneNumber&#x60;; diğerleri null bırakılabilir.                - Telefon 905321112233, 05321112233, 5321112233 gibi yazılabilir; 905321112233 biçiminde kaydedilir.    Aynı numarayla kayıtlı kişi varsa &#x60;success:false&#x60; döner.  - &#x60;dateOfBirth&#x60; ISO biçiminde gönderilir: \&quot;1990-01-31\&quot;.  - &#x60;cityId&#x60; contact/cities listesinden seçilir.  - Yeni kişide AI chatbot açık başlar.                Yanıt eklenen kişinin detayıdır.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ContactApi()
val createContactCommand : CreateContactCommand =  // CreateContactCommand | 
try {
    val result : ContactDetailDtoApiReturn = apiInstance.contactCreatePost(createContactCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#contactCreatePost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#contactCreatePost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createContactCommand** | [**CreateContactCommand**](CreateContactCommand.md)|  | [optional] |

### Return type

[**ContactDetailDtoApiReturn**](ContactDetailDtoApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="contactDeletePost"></a>
# **contactDeletePost**
> BooleanApiReturn contactDeletePost(deleteContactCommand)

Kişiyi siler.

Yetki: &#x60;contactspermission&#x60;. Kişi listeden kalkar; geçmiş mesajlar silinmez, sohbet listede kayıtsız  numara olarak görünmeye devam eder. &#x60;data&#x60; &#x3D; true.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ContactApi()
val deleteContactCommand : DeleteContactCommand =  // DeleteContactCommand | 
try {
    val result : BooleanApiReturn = apiInstance.contactDeletePost(deleteContactCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#contactDeletePost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#contactDeletePost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **deleteContactCommand** | [**DeleteContactCommand**](DeleteContactCommand.md)|  | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="contactDetailGet"></a>
# **contactDetailGet**
> ContactDetailDtoApiReturn contactDetailGet(id)

Kişinin tüm bilgilerini döner (düzenleme formu bu verilerle doldurulur).

Yetki: &#x60;contactspermission&#x60;. Kişi bulunamazsa &#x60;success:false&#x60; döner.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ContactApi()
val id : kotlin.Int = 56 // kotlin.Int | Kişi id'si.
try {
    val result : ContactDetailDtoApiReturn = apiInstance.contactDetailGet(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#contactDetailGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#contactDetailGet")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.Int**| Kişi id&#39;si. | [optional] |

### Return type

[**ContactDetailDtoApiReturn**](ContactDetailDtoApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

<a id="contactListGet"></a>
# **contactListGet**
> ContactListItemDtoPagedApiReturn contactListGet(search, tagId, isAcceptPublications, currentPage, pageSize)

İşletmenin kişilerini sayfalı listeler.

Yetki: &#x60;contactspermission&#x60;. En son eklenen kişi önce gelir. Filtreler birlikte kullanılabilir:  &#x60;search&#x60; ad soyad ve telefonda arar, &#x60;tagId&#x60; yalnızca o etikete sahip kişileri, &#x60;isAcceptPublications&#x60;  yalnızca o ileti izni durumundaki kişileri getirir.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ContactApi()
val search : kotlin.String = search_example // kotlin.String | Ad soyad veya telefonda geçen metin. Boş bırakılırsa filtre uygulanmaz.
val tagId : kotlin.Int = 56 // kotlin.Int | Yalnızca bu etikete sahip kişiler. Boş bırakılırsa filtre uygulanmaz.
val isAcceptPublications : IsAcceptPublications =  // IsAcceptPublications | Ticari ileti izni filtresi: 0 = Belirsiz, 1 = İzin verdi, 2 = İzin vermedi. Boş bırakılırsa filtre uygulanmaz.
val currentPage : kotlin.Int = 56 // kotlin.Int | İstenen sayfa (1'den başlar). Varsayılan: 1.
val pageSize : kotlin.Int = 56 // kotlin.Int | Sayfa başına kayıt. Varsayılan: 20, en fazla: 100.
try {
    val result : ContactListItemDtoPagedApiReturn = apiInstance.contactListGet(search, tagId, isAcceptPublications, currentPage, pageSize)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#contactListGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#contactListGet")
    e.printStackTrace()
}
```

### Parameters
| **search** | **kotlin.String**| Ad soyad veya telefonda geçen metin. Boş bırakılırsa filtre uygulanmaz. | [optional] |
| **tagId** | **kotlin.Int**| Yalnızca bu etikete sahip kişiler. Boş bırakılırsa filtre uygulanmaz. | [optional] |
| **isAcceptPublications** | [**IsAcceptPublications**](.md)| Ticari ileti izni filtresi: 0 &#x3D; Belirsiz, 1 &#x3D; İzin verdi, 2 &#x3D; İzin vermedi. Boş bırakılırsa filtre uygulanmaz. | [optional] [enum: 0, 1, 2] |
| **currentPage** | **kotlin.Int**| İstenen sayfa (1&#39;den başlar). Varsayılan: 1. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **pageSize** | **kotlin.Int**| Sayfa başına kayıt. Varsayılan: 20, en fazla: 100. | [optional] |

### Return type

[**ContactListItemDtoPagedApiReturn**](ContactListItemDtoPagedApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

<a id="contactUpdatePost"></a>
# **contactUpdatePost**
> ContactDetailDtoApiReturn contactUpdatePost(updateContactCommand)

Kişi bilgilerini günceller.

Yetki: &#x60;contactspermission&#x60;. Tüm form alanları gönderilir (gönderilmeyen alan boşaltılır); kurallar  contact/create ile aynıdır. Engelleme bu uçla değiştirilmez, contact/block kullanılır.  Yanıt güncellenmiş kişinin detayıdır.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = ContactApi()
val updateContactCommand : UpdateContactCommand =  // UpdateContactCommand | 
try {
    val result : ContactDetailDtoApiReturn = apiInstance.contactUpdatePost(updateContactCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#contactUpdatePost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#contactUpdatePost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateContactCommand** | [**UpdateContactCommand**](UpdateContactCommand.md)|  | [optional] |

### Return type

[**ContactDetailDtoApiReturn**](ContactDetailDtoApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

