plugins {
    // SDK'nın build.gradle dosyasındaki kotlin_version ile aynı tutulmalı.
    kotlin("jvm") version "2.4.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // Sürüm yok: composite build bunu üst klasördeki SDK projesiyle eşleştirir.
    implementation("com.basefywhappio:basefywhappio-sdk-android")
    // SDK'nın kullandığı OkHttp sürümüyle aynı.
    implementation("com.squareup.okhttp3:logging-interceptor:5.4.0")
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}
