plugins {
    alias(libs.plugins.yumyard.android.library)
    alias(libs.plugins.yumyard.android.compose)
}

android {
    namespace = "com.joel.design"

    buildFeatures{
        compose = true
    }
}
dependencies {
    implementation(libs.androidx.material3.android)
}
