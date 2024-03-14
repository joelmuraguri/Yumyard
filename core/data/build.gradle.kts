plugins {
    alias(libs.plugins.yumyard.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.yumyard.android.ktor.client)
    alias(libs.plugins.yumyard.android.room)
    alias(libs.plugins.yumyard.android.sharedLibrary)
}

android {
    namespace = "com.joel.data"

    kotlinOptions {
        jvmTarget = "17"
    }
}
dependencies {
    implementation(project(":core:remote"))
}

