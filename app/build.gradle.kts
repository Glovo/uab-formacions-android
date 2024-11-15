plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.glovoapp.uabformacions.dogapi"

    compileSdk = libs.versions.android.compileSDK.get().toInt()
}
