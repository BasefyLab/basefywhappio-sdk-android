# RealtimeApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**realtimeTokenGet**](RealtimeApi.md#realtimeTokenGet) | **GET** /realtime/token | Canlı mesaj bağlantısı (SignalR hub) için 24 saat geçerli bağlantı token&#39;ı üretir. |


<a id="realtimeTokenGet"></a>
# **realtimeTokenGet**
> RealtimeTokenDtoApiReturn realtimeTokenGet()

Canlı mesaj bağlantısı (SignalR hub) için 24 saat geçerli bağlantı token&#39;ı üretir.

Uygulama açıkken yeni mesajları anlık almak için kullanılır (web panelle aynı altyapı).                1. Bu uçtan &#x60;token&#x60; alınır.  2. Hookman hub&#39;ına bağlanılır: &#x60;wss://{hookman adresi}/hub?token&#x3D;{token}&#x60; (SignalR istemcisi, WebSockets).  3. Olaylar dinlenir:     - &#x60;receiveMessage(json)&#x60;: gelen veya giden yeni mesaj (JSON metni).     - &#x60;assign(json)&#x60;: sohbetin atandığı temsilci değişti.     - &#x60;updateTicketStatus(phoneNumber, status)&#x60;: görüşme sonlandırıldı veya ticket durumu değişti.  4. Mesaj görüntülendiğinde hub&#39;a &#x60;MarkMessageInboundAsRead(externalId)&#x60; çağrılabilir.  5. &#x60;expiresAt&#x60; dolmadan yeni token alınıp yeniden bağlanılır; süresi dolmuş token&#39;la hub bağlantıyı kapatır.                Token işletme (tenant) bazlıdır: işletmenin tüm sohbetlerinin olayları gelir. Uygulama kapalıyken  bağlantı yoktur.

### Example
```kotlin
// Import classes:
//import com.basefywhappio.sdk.infrastructure.*
//import com.basefywhappio.sdk.models.*

val apiInstance = RealtimeApi()
try {
    val result : RealtimeTokenDtoApiReturn = apiInstance.realtimeTokenGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RealtimeApi#realtimeTokenGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RealtimeApi#realtimeTokenGet")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RealtimeTokenDtoApiReturn**](RealtimeTokenDtoApiReturn.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

