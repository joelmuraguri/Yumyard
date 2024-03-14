plugins {
    alias(libs.plugins.yumyard.android.library)
    alias(libs.plugins.yumyard.android.compose)
    alias(libs.plugins.yumyard.android.sharedLibrary)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.yumyard.android.hilt)
}

android {
    namespace = "com.joel.discover"

    buildFeatures{
        compose = true
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {


    implementation(project(":core:domain"))
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation(libs.androidx.navigation)
    
}