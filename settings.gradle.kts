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
include(":feature:comic")
include(":feature:series")
include(":feature:shorts")
include(":feature:community")
include(":feature:my")
include(":core:network")
include(":core:model")
include(":core:data")
include(":core:domain")
include(":core:common")
include(":core:ui")
include(":feature:auth:login")
