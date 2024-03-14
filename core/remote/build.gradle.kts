plugins {
    alias(libs.plugins.yumyard.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.yumyard.android.ktor.client)
    alias(libs.plugins.yumyard.android.sharedLibrary)
    alias(libs.plugins.serialization)

}

android {
    namespace = "com.joel.remote"

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.retrofit.kotlinx.serialization.converter)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit)


    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.okhttp.interceptor)
    testImplementation(libs.okhttp.mockwebserver)
}
