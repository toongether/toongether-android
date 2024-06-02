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
        maven { url = uri("https://jitpack.io") }
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
include(
    ":feature:episode:interface",
    ":feature:episode:source",
    ":feature:episode:demo"
)
include(
    ":feature:comic:interface",
    ":feature:comic:source",
    ":feature:comic:demo"
)

include(
    ":feature:main:demo",
    ":feature:main:source"
)
//include(":feature:home:source")
include(":feature:community:source")
include(":feature:my:source")
include(":feature:auth:login")
include(":feature:auth:signup")
//include(":feature:home:interface")

include(":feature:archive:source")
