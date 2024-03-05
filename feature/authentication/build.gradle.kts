plugins {
    alias(libs.plugins.yumyard.android.library)
    alias(libs.plugins.yumyard.android.compose)
    alias(libs.plugins.yumyard.android.sharedLibrary)
}

android {
    namespace = "com.joel.authentication"

    buildFeatures{
        compose = true
    }
}

dependencies {

    implementation(libs.accompanist.pager.indicators)
    implementation(libs.accompanist.pager)
    implementation(libs.androidx.navigation)

}