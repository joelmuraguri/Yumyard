plugins {
    alias(libs.plugins.yumyard.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.yumyard.android.ktor.client)
    alias(libs.plugins.yumyard.android.sharedLibrary)

}

android {
    namespace = "com.joel.remote"

    kotlinOptions {
        jvmTarget = "17"
    }
}
