plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.kapt)
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(libs.versions.java.get()))

kapt.correctErrorTypes = true

android {
    namespace = "com.glovoapp.uabformacions.dogapi"

    compileSdk = libs.versions.android.compileSDK.get().toInt()
    defaultConfig.minSdk = libs.versions.android.minSDK.get().toInt()
}

dependencies {
    implementation(projects.data)

    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.android)

    implementation(libs.androidx.activity.compose)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.uiToolingPreview)
    debugImplementation(libs.androidx.compose.uiTooling)
    testImplementation(libs.androidx.compose.junit4)

}
