plugins {
    alias(libs.plugins.yumyard.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.yumyard.android.hilt)
    alias(libs.plugins.yumyard.android.ktor.client)
    alias(libs.plugins.yumyard.android.sharedLibrary)
}

android {
    namespace = "com.joel.domain"
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":core:remote"))
    implementation(project(":core:data"))

    implementation(libs.retrofit)
}