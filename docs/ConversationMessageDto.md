
# ConversationMessageDto

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.Int** | Mesaj id&#39;si. Otomasyon iç notlarında 0&#39;dır (Message satırı yoktur). |  [optional] |
| **externalId** | **kotlin.String** | WhatsApp mesaj id&#39;si. Yanıtlama (conversation/send externalIdOfReplied) ve hub&#39;daki MarkMessageInboundAsRead bununla yapılır. |  [optional] |
| **messageType** | [**MessageType**](MessageType.md) |  |  [optional] |
| **senderType** | [**MessageSenderType**](MessageSenderType.md) |  |  [optional] |
| **isIncoming** | **kotlin.Boolean** | true: müşteriden gelen mesaj (sol balon). false: işletmeden giden mesaj (sağ balon). |  [optional] |
| **text** | **kotlin.String** | Gösterilecek düz metin (metin, buton/liste cevabı, CTA gövdesi vb.). |  [optional] |
| **contentJson** | **kotlin.String** | Zengin tiplerin (liste, sipariş, ürün kartı, konum…) ham kanonik içeriği (JSON metni); istemci gerektiğinde çözer. |  [optional] |
| **mediaUrl** | **kotlin.String** | Resim/ses/video/dosya mesajlarında medyanın adresi; diğer tiplerde null. |  [optional] |
| **date** | **kotlin.Long** | Mesaj zamanı, Unix milisaniye. |  [optional] |
| **isRead** | **kotlin.Boolean** | Mesaj okundu mu. |  [optional] |
| **sentByFullName** | **kotlin.String** | Mesajı panelden/mobilden gönderen temsilci; temsilci mesajı değilse null. |  [optional] |
| **repliedTo** | [**RepliedMessageDto**](RepliedMessageDto.md) |  |  [optional] |
| **isInternalNote** | **kotlin.Boolean** | Otomasyonun bıraktığı iç not: müşteriye gitmez, yalnızca temsilci görür. |  [optional] |



