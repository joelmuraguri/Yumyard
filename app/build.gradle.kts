import java.util.Properties

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.yumyard.android.application)
    alias(libs.plugins.yumyard.kotlin.android)
    alias(libs.plugins.yumyard.android.compose)
    alias(libs.plugins.yumyard.android.sharedLibrary)
    alias(libs.plugins.yumyard.android.room)
    alias(libs.plugins.yumyard.android.ktor.client)
    alias(libs.plugins.serialization)

}

val localPropertiesFile = rootProject.file("local.properties")
val localProperties = Properties().apply {
    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use { stream ->
            load(stream)
        }
    }
}

android {
    namespace = "com.joel.yumyard"


    buildTypes {
        getByName("debug") {
            buildConfigField("String", "SPOONACULAR_API_KEY", "\"${localProperties.getProperty("SPOONACULAR_API_KEY")}\"")
        }
        debug {
            // configuration for debug builds
            buildConfigField("boolean", "DEBUG", "true")
        }
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies{
    implementation(project(":core:design"))
    implementation(project(":core:remote"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":feature:authentication"))
    implementation(project(":feature:discover"))
    implementation(project(":feature:search"))
    implementation(project(":feature:mealplan"))
    implementation(project(":feature:favourites"))
    implementation(project(":feature:search"))
    implementation(project(":feature:profile"))

    implementation(libs.retrofit.kotlinx.serialization.converter)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit)

    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.okhttp.interceptor)
    testImplementation(libs.okhttp.mockwebserver)
}