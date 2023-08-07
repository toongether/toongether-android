pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
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

rootProject.name = "Toongether"
include(":app")
include(":core:designsystem")
include(":feature:home")
include(":feature:series")
include(":feature:shorts")
include(":feature:community")
include(":feature:my")
