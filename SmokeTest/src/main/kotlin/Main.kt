import com.basefywhappio.sdk.apis.AuthApi
import com.basefywhappio.sdk.apis.TagApi
import com.basefywhappio.sdk.infrastructure.ApiClient
import com.basefywhappio.sdk.infrastructure.ClientException
import com.basefywhappio.sdk.models.LoginRequest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import kotlin.system.exitProcess

fun main() {
    val user = System.getenv("SDK_USER")
    val pass = System.getenv("SDK_PASS")
    if (user.isNullOrBlank() || pass.isNullOrBlank()) {
        System.err.println("SDK_USER ve SDK_PASS ortam değişkenleri tanımlı olmalı (GitHub'da repo secret olarak).")
        exitProcess(1)
    }

    // UYARI: Seviye BASIC kalmalı. HEADERS/BODY token'ı ve parolayı herkese açık Actions loglarına yazar.
    val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
    val client = OkHttpClient.Builder().addInterceptor(logging).build()

    // Sunucu adresi verilmiyor: SDK'nın varsayılan adresi kullanılır.
    val authApi = AuthApi(client = client)
    val tagApi = TagApi(client = client)

    println("Sunucu: ${AuthApi.defaultBasePath}")
    var failed = false

    // 1) Giriş + sayısal enum (userType) okuma
    println("\n== 1) Giriş (AuthApi.authLoginPost) ==")
    var token: String? = null
    try {
        val res = authApi.authLoginPost(LoginRequest(username = user, password = pass))
        println("success = ${res.success}")
        println("message = ${res.message}")
        println("data.userType = ${res.data?.userType} (değer: ${res.data?.userType?.value})")
        token = res.data?.token
        when {
            res.success != true -> { println("BAŞARISIZ: success true değil."); failed = true }
            token.isNullOrEmpty() -> { println("BAŞARISIZ: yanıtta token yok."); failed = true }
            res.data?.userType == null -> { println("BAŞARISIZ: userType okunamadı (null)."); failed = true }
            else -> println("OK")
        }
    } catch (e: Exception) {
        println("BAŞARISIZ: ${e::class.qualifiedName}: ${e.message}")
        failed = true
    }

    // 2) Geçerli token ile tag listesi
    println("\n== 2) Geçerli token ile TagApi.tagListGet ==")
    if (token.isNullOrEmpty()) {
        println("ATLANDI: token yok.")
        failed = true
    } else {
        ApiClient.apiKey["Authorization"] = token
        ApiClient.apiKeyPrefix["Authorization"] = "Bearer"
        try {
            val res = tagApi.tagListGet()
            println("success = ${res.success}")
            println("message = ${res.message}")
            if (res.success == true) println("OK") else { println("BAŞARISIZ: success true değil."); failed = true }
        } catch (e: Exception) {
            println("BAŞARISIZ: ${e::class.qualifiedName}: ${e.message}")
            failed = true
        }
    }

    // 3) Geçersiz token ile 401 beklenir
    println("\n== 3) Geçersiz token ile TagApi.tagListGet (401 bekleniyor) ==")
    ApiClient.apiKey["Authorization"] = "gecersiz-token"
    ApiClient.apiKeyPrefix["Authorization"] = "Bearer"
    try {
        tagApi.tagListGet()
        println("BAŞARISIZ: istek başarılı oldu, 401 bekleniyordu.")
        failed = true
    } catch (e: ClientException) {
        println("statusCode = ${e.statusCode}")
        if (e.statusCode == 401) println("OK") else { println("BAŞARISIZ: 401 bekleniyordu."); failed = true }
    } catch (e: Exception) {
        println("BAŞARISIZ: ${e::class.qualifiedName}: ${e.message}")
        failed = true
    } finally {
        ApiClient.apiKey.remove("Authorization")
        ApiClient.apiKeyPrefix.remove("Authorization")
    }

    println()
    if (failed) {
        println("SONUÇ: Duman testi BAŞARISIZ.")
        exitProcess(1)
    }
    println("SONUÇ: Duman testi başarılı.")
    exitProcess(0)
}
