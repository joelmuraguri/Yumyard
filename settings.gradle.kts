pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Yumyard"
include(":app")
include(":feature:authentication")
include(":core:design")
include(":feature:discover")
include(":feature:mealplan")
include(":feature:search")
include(":feature:profile")
include(":feature:favourites")
include(":core:remote")
include(":core:data")
include(":core:domain")
