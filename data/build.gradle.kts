plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(libs.versions.java.get()))

kapt.correctErrorTypes = true

android {
    namespace = "com.glovoapp.uabformacions.dogapi.data"

    compileSdk = libs.versions.android.compileSDK.get().toInt()
    defaultConfig.minSdk = libs.versions.android.minSDK.get().toInt()
}

dependencies {
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.android)

    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp.logging)

    implementation(libs.kotlin.coroutines)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.retrofit.serialization)
}
