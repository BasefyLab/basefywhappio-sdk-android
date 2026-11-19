# MeApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**meStatusGet**](MeApi.md#meStatusGet) | **GET** /me/status | Kullanıcının çevrimiçi olup olmadığını döner. |
| [**meStatusPost**](MeApi.md#meStatusPost) | **POST** /me/status | Kullanıcıyı çevrimiçi veya çevrimdışı yapar. |


<a id="meStatusGet"></a>
# **meStatusGet**
> BooleanApiReturn meStatusGet()

Kullanıcının çevrimiçi olup olmadığını döner.

&#x60;data&#x60; &#x3D; true: çevrimiçi; sohbetler bu temsilciye atanabilir ve conversation/assigntome kullanılabilir.  false: çevrimdışı. Durum web panelle ortaktır (web&#39;de değiştirilirse burada da görünür).

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = MeApi()
try {
    val result : BooleanApiReturn = apiInstance.meStatusGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MeApi#meStatusGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MeApi#meStatusGet")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

<a id="meStatusPost"></a>
# **meStatusPost**
> BooleanApiReturn meStatusPost(setMyStatusCommand)

Kullanıcıyı çevrimiçi veya çevrimdışı yapar.

&#x60;isOnline&#x60; istenen durumdur (değiştirme değil; tekrar göndermek durumu geri çevirmez).                - **true:** Çevrimiçi olunur. Yeni sohbetler bu temsilciye otomatik atanabilir, \&quot;üstüme al\&quot; kullanılabilir.  - **false:** Çevrimdışı olunur. Üzerindeki kapanmamış sohbetlerin ataması kaldırılır (havuza bırakılır) ve    açık ekranlar canlı bağlantıda &#x60;assign&#x60; olayıyla (&#x60;UserId&#x60; &#x3D; 0) güncellenir.                Durum web panelle ortaktır. &#x60;data&#x60; &#x3D; yeni durum.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = MeApi()
val setMyStatusCommand : SetMyStatusCommand =  // SetMyStatusCommand | 
try {
    val result : BooleanApiReturn = apiInstance.meStatusPost(setMyStatusCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MeApi#meStatusPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MeApi#meStatusPost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **setMyStatusCommand** | [**SetMyStatusCommand**](SetMyStatusCommand.md)|  | [optional] |

### Return type

[**BooleanApiReturn**](BooleanApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

