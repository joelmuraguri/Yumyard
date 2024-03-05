plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

group = "com.joel.build-logic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

gradlePlugin{
    plugins {
        create("kotlinAndroid"){
            id = "yumyard.kotlin.android"
            implementationClass = "KotlinAndroidConventionPlugin"
        }

        create("androidCompose"){
            id = "yumyard.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }

        create("androidApplication"){
            id = "yumyard.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        create("androidLibrary"){
            id = "yumyard.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        create("androidHilt"){
            id = "yumyard.android.hilt"
            implementationClass = "HiltAndroidConventionPlugin"
        }

        create("androidKtorClient"){
            id = "yumyard.ktor.client"
            implementationClass = "KtorClientConventionPlugin"
        }

        create("androidRoom"){
            id = "yumyard.room.android"
            implementationClass = "RoomAndroidConventionPlugin"
        }

        create("sharedLibrary"){
            id = "yumyard.shared.library"
            implementationClass = "SharedLibraryConventionPlugin"
        }
    }
}