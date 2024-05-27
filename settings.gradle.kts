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
include(
    ":core:designsystem",
    ":core:network",
    ":core:model",
    ":core:data",
    ":core:domain",
    ":core:common",
    ":core:ui",
    ":core:datastore",
)
include(
    ":feature:series:interface",
    ":feature:series:source",
    ":feature:series:demo",
    ":feature:series:test",
    ":feature:series:testing"
)
include(
    ":feature:shorts:interface",
    ":feature:shorts:source",
    ":feature:shorts:demo"
)
//include(":feature:home:source")
//include(":feature:comic:source")
//include(":feature:comic:demo")
//include(":feature:comic:interface")
//include(":feature:community")
//include(":feature:my")
//include(":feature:auth:login")
//include(":feature:auth:signup")
//include(":feature:episode:source")
//include(":feature:episode:interface")
//include(":feature:episode:demo")
//include(":feature:home:interface")
//include(":feature:shorts:demo")
//include(":feature:main:source")
