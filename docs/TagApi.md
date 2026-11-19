# TagApi

All URIs are relative to *https://api.whappio.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**tagAddcontacttagPost**](TagApi.md#tagAddcontacttagPost) | **POST** /tag/addcontacttag | Kişiye etiket ekler. |
| [**tagContacttagsGet**](TagApi.md#tagContacttagsGet) | **GET** /tag/contacttags | Bir kişinin etiket ekranı: işletmenin tüm etiketleri, kişiye ekli olanlar işaretli. |
| [**tagCreatePost**](TagApi.md#tagCreatePost) | **POST** /tag/create | Yeni etiket ekler. |
| [**tagDeletePost**](TagApi.md#tagDeletePost) | **POST** /tag/delete | Etiketi siler. |
| [**tagListGet**](TagApi.md#tagListGet) | **GET** /tag/list | İşletmenin etiketlerini sayfalı listeler. |
| [**tagRemovecontacttagPost**](TagApi.md#tagRemovecontacttagPost) | **POST** /tag/removecontacttag | Kişiden etiketi kaldırır. |
| [**tagUpdatePost**](TagApi.md#tagUpdatePost) | **POST** /tag/update | Etiketin adını ve açıklamasını günceller. |


<a id="tagAddcontacttagPost"></a>
# **tagAddcontacttagPost**
> BooleanApiReturn tagAddcontacttagPost(addContactTagCommand)

Kişiye etiket ekler.

Ek yetki gerekmez. Etiket zaten ekliyse hata vermez, yine &#x60;data&#x60; &#x3D; true döner (tekrar denemek güvenlidir).  Kişi veya etiket bulunamazsa &#x60;success:false&#x60; döner.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = TagApi()
val addContactTagCommand : AddContactTagCommand =  // AddContactTagCommand | 
try {
    val result : BooleanApiReturn = apiInstance.tagAddcontacttagPost(addContactTagCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagApi#tagAddcontacttagPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagApi#tagAddcontacttagPost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **addContactTagCommand** | [**AddContactTagCommand**](AddContactTagCommand.md)|  | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="tagContacttagsGet"></a>
# **tagContacttagsGet**
> ContactTagDtoListApiReturn tagContacttagsGet(contactId)

Bir kişinin etiket ekranı: işletmenin tüm etiketleri, kişiye ekli olanlar işaretli.

Ek yetki gerekmez. Her etikette &#x60;isAssigned&#x60; &#x3D; true ise etiket kişide ekli, false ise eklenebilir.  Kişi bulunamazsa &#x60;success:false&#x60; döner.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = TagApi()
val contactId : kotlin.Int = 56 // kotlin.Int | Kişi id'si (contact/list veya conversation/list içindeki contact.id).
try {
    val result : ContactTagDtoListApiReturn = apiInstance.tagContacttagsGet(contactId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagApi#tagContacttagsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagApi#tagContacttagsGet")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **contactId** | **kotlin.Int**| Kişi id&#39;si (contact/list veya conversation/list içindeki contact.id). | [optional] |

### Return type

[**ContactTagDtoListApiReturn**](ContactTagDtoListApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

<a id="tagCreatePost"></a>
# **tagCreatePost**
> TagDtoApiReturn tagCreatePost(createTagCommand)

Yeni etiket ekler.

Yetki: &#x60;tagcreatepermission&#x60;. Aynı adda etiket varsa &#x60;success:false&#x60; döner. Yanıt eklenen etikettir.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = TagApi()
val createTagCommand : CreateTagCommand =  // CreateTagCommand | 
try {
    val result : TagDtoApiReturn = apiInstance.tagCreatePost(createTagCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagApi#tagCreatePost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagApi#tagCreatePost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createTagCommand** | [**CreateTagCommand**](CreateTagCommand.md)|  | [optional] |

### Return type

[**TagDtoApiReturn**](TagDtoApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="tagDeletePost"></a>
# **tagDeletePost**
> BooleanApiReturn tagDeletePost(deleteTagCommand)

Etiketi siler.

Yetki: &#x60;tagdeletepermission&#x60;. Etiket, eklenmiş olduğu tüm kişilerden de kaldırılır. &#x60;data&#x60; &#x3D; true.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = TagApi()
val deleteTagCommand : DeleteTagCommand =  // DeleteTagCommand | 
try {
    val result : BooleanApiReturn = apiInstance.tagDeletePost(deleteTagCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagApi#tagDeletePost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagApi#tagDeletePost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **deleteTagCommand** | [**DeleteTagCommand**](DeleteTagCommand.md)|  | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="tagListGet"></a>
# **tagListGet**
> TagDtoPagedApiReturn tagListGet(search, currentPage, pageSize)

İşletmenin etiketlerini sayfalı listeler.

Yetki: &#x60;taglistpermission&#x60;. En son eklenen etiket önce gelir. &#x60;search&#x60; etiket adı ve açıklamasında arar.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = TagApi()
val search : kotlin.String = search_example // kotlin.String | Etiket adında veya açıklamasında geçen metin. Boş bırakılırsa tüm etiketler.
val currentPage : kotlin.Int = 56 // kotlin.Int | İstenen sayfa (1'den başlar). Varsayılan: 1.
val pageSize : kotlin.Int = 56 // kotlin.Int | Sayfa başına kayıt. Varsayılan: 20, en fazla: 100.
try {
    val result : TagDtoPagedApiReturn = apiInstance.tagListGet(search, currentPage, pageSize)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagApi#tagListGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagApi#tagListGet")
    e.printStackTrace()
}
```

### Parameters
| **search** | **kotlin.String**| Etiket adında veya açıklamasında geçen metin. Boş bırakılırsa tüm etiketler. | [optional] |
| **currentPage** | **kotlin.Int**| İstenen sayfa (1&#39;den başlar). Varsayılan: 1. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **pageSize** | **kotlin.Int**| Sayfa başına kayıt. Varsayılan: 20, en fazla: 100. | [optional] |

### Return type

[**TagDtoPagedApiReturn**](TagDtoPagedApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

<a id="tagRemovecontacttagPost"></a>
# **tagRemovecontacttagPost**
> BooleanApiReturn tagRemovecontacttagPost(removeContactTagCommand)

Kişiden etiketi kaldırır.

Ek yetki gerekmez. Etiket zaten ekli değilse hata vermez, yine &#x60;data&#x60; &#x3D; true döner.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = TagApi()
val removeContactTagCommand : RemoveContactTagCommand =  // RemoveContactTagCommand | 
try {
    val result : BooleanApiReturn = apiInstance.tagRemovecontacttagPost(removeContactTagCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagApi#tagRemovecontacttagPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagApi#tagRemovecontacttagPost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **removeContactTagCommand** | [**RemoveContactTagCommand**](RemoveContactTagCommand.md)|  | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a id="tagUpdatePost"></a>
# **tagUpdatePost**
> TagDtoApiReturn tagUpdatePost(updateTagCommand)

Etiketin adını ve açıklamasını günceller.

Yetki: &#x60;tageditpermission&#x60;. Yeni ad başka bir etiketle aynıysa ya da etiket bulunamazsa &#x60;success:false&#x60; döner.  Yanıt güncellenmiş etikettir.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = TagApi()
val updateTagCommand : UpdateTagCommand =  // UpdateTagCommand | 
try {
    val result : TagDtoApiReturn = apiInstance.tagUpdatePost(updateTagCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagApi#tagUpdatePost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagApi#tagUpdatePost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateTagCommand** | [**UpdateTagCommand**](UpdateTagCommand.md)|  | [optional] |

### Return type

[**TagDtoApiReturn**](TagDtoApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

