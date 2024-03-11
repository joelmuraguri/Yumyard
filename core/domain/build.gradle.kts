plugins {
    alias(libs.plugins.yumyard.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.yumyard.android.sharedLibrary)
}

android {
    namespace = "com.joel.domain"
    kotlinOptions {
        jvmTarget = "17"
    }
}

