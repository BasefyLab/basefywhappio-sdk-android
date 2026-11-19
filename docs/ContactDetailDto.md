
# ContactDetailDto

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.Int** | Kişi id&#39;si. |  [optional] |
| **fullName** | **kotlin.String** | Ad soyad. |  [optional] |
| **emailAddress** | **kotlin.String** | E-posta; girilmemişse null. |  [optional] |
| **phoneNumber** | **kotlin.String** | Ülke kodlu telefon, yalnızca rakam (ör. 905321112233). |  [optional] |
| **gender** | [**Gender**](Gender.md) |  |  [optional] |
| **dateOfBirth** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Doğum tarihi (ISO 8601, ör. 1990-01-31T00:00:00); girilmemişse null. |  [optional] |
| **cityId** | **kotlin.Int** | Şehir id&#39;si (contact/cities listesinden); girilmemişse null. |  [optional] |
| **cityName** | **kotlin.String** | Şehir adı (gösterim için); şehir yoksa null. |  [optional] |
| **languageType** | [**LanguageType**](LanguageType.md) |  |  [optional] |
| **isAcceptPublications** | [**IsAcceptPublications**](IsAcceptPublications.md) |  |  [optional] |
| **isBlocked** | **kotlin.Boolean** | Kişi WhatsApp&#39;ta engelli mi. Değiştirmek için contact/block kullanılır. |  [optional] |



