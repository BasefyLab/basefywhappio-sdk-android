
# ConversationMessagesDto

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **messages** | [**kotlin.collections.List&lt;ConversationMessageDto&gt;**](ConversationMessageDto.md) | Bu sayfadaki mesajlar, eskiden yeniye sıralı. |  [optional] |
| **hasMore** | **kotlin.Boolean** | Daha eski mesaj var mı. false ise sohbetin başına gelindi. |  [optional] |
| **nextBeforeDate** | **kotlin.Long** | Daha eski sayfa için bir sonraki istekte beforeDate olarak gönderilir; HasMore&#x3D;false ise null. |  [optional] |
| **nextBeforeId** | **kotlin.Int** | Daha eski sayfa için bir sonraki istekte beforeId olarak gönderilir; HasMore&#x3D;false ise null. |  [optional] |



