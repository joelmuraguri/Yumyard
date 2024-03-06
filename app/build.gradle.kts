@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.yumyard.android.application)
    alias(libs.plugins.yumyard.kotlin.android)
    alias(libs.plugins.yumyard.android.compose)
    alias(libs.plugins.yumyard.android.sharedLibrary)
    alias(libs.plugins.yumyard.android.hilt)
    alias(libs.plugins.yumyard.android.room)
    alias(libs.plugins.yumyard.android.ktor.client)

}

android {
    namespace = "com.joel.yumyard"
}

dependencies{
    implementation(project(":core:design"))
    implementation(project(":feature:authentication"))
}