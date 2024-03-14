plugins {
    alias(libs.plugins.yumyard.android.library)
    alias(libs.plugins.yumyard.android.compose)
    alias(libs.plugins.yumyard.android.sharedLibrary)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.joel.search"
    buildFeatures{
        compose = true
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.androidx.navigation)
    implementation("io.coil-kt:coil-compose:2.4.0")


}