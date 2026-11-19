
# SendConversationMessageCommand

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **phoneNumber** | **kotlin.String** | Müşterinin telefonu (conversation/list içindeki phoneNumber). |  [optional] |
| **text** | **kotlin.String** | Mesaj metni. Konum gönderilmiyorsa zorunlu. Konum gönderiliyorsa yok sayılır (konum mesajı metin taşımaz). |  [optional] |
| **latitude** | **kotlin.String** | Konum gönderilecekse enlem, nokta ondalıklı (ör. \&quot;41.0082\&quot;). Konum yoksa null; longitude ile birlikte gönderilir. |  [optional] |
| **longitude** | **kotlin.String** | Konum gönderilecekse boylam, nokta ondalıklı (ör. \&quot;28.9784\&quot;). Konum yoksa null; latitude ile birlikte gönderilir. |  [optional] |
| **externalIdOfReplied** | **kotlin.String** | Bir mesaja yanıt veriliyorsa o mesajın externalId&#39;si (conversation/messages). Yanıt değilse null. |  [optional] |



