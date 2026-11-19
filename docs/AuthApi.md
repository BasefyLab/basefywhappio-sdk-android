# AuthApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**authLoginPost**](AuthApi.md#authLoginPost) | **POST** /auth/login | Kullanıcı adı ve parola ile giriş yapar, JWT döner. |


<a id="authLoginPost"></a>
# **authLoginPost**
> LoginResponseApiReturn authLoginPost(loginRequest)

Kullanıcı adı ve parola ile giriş yapar, JWT döner.

Backoffice kullanıcı adı/parolası kullanılır. Dönen &#x60;data.token&#x60; diğer tüm isteklerde  &#x60;Authorization: Bearer {token}&#x60; başlığıyla gönderilir.                - Token uzun ömürlüdür (ayara bağlı, şu an 200 gün); yenileme (refresh) ucu yoktur. Herhangi bir uç    HTTP 401 döndüğünde kullanıcı yeniden giriş yapmalıdır.  - Hatalı parola, kilitli hesap, pasif hesap veya işletmeye bağlı olmayan hesapta HTTP 200 +    &#x60;success:false&#x60; ve açıklayıcı &#x60;message&#x60; döner.  - Art arda hatalı denemelerde bekleme süresi uygulanır ve hesap kilitlenebilir (Backoffice ile ortak sayaç).  - &#x60;permissions&#x60; yalnızca menü/buton göstermek içindir; yetki her istekte sunucuda yeniden kontrol edilir.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = AuthApi()
val loginRequest : LoginRequest =  // LoginRequest | 
try {
    val result : LoginResponseApiReturn = apiInstance.authLoginPost(loginRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AuthApi#authLoginPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AuthApi#authLoginPost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **loginRequest** | [**LoginRequest**](LoginRequest.md)|  | [optional] |

### Return type

[**LoginResponseApiReturn**](LoginResponseApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

