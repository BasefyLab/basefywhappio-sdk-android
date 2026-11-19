
# LoginResponse

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.Int** | Kullanıcı id&#39;si. |  [optional] |
| **token** | **kotlin.String** | JWT. Diğer isteklerde \&quot;Authorization: Bearer {token}\&quot; başlığıyla gönderilir. |  [optional] |
| **username** | **kotlin.String** | Kullanıcı adı. |  [optional] |
| **fullName** | **kotlin.String** | Ad soyad. |  [optional] |
| **emailAddress** | **kotlin.String** | E-posta. |  [optional] |
| **tenantId** | **kotlin.Int** | Kullanıcının bağlı olduğu işletme (tenant) id&#39;si. |  [optional] |
| **userType** | [**UserType**](UserType.md) |  |  [optional] |
| **permissions** | **kotlin.collections.List&lt;kotlin.String&gt;** | Kullanıcının yetki anahtarları (ör. contactspermission, taglistpermission). Yalnızca menü/buton göstermek  içindir; yönetici (userType&#x3D;1) bu listeden bağımsız olarak her uca erişir. |  [optional] |



