plugins {
    alias(libs.plugins.yumyard.android.library)
    alias(libs.plugins.yumyard.android.compose)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.joel.design"

    buildFeatures{
        compose = true
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}
dependencies {
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.core.ktx)
}
