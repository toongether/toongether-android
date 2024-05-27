plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.series"
}

dependencies {
//    implementation(project(":feature:comic:interface"))
    implementation(project(":core:common"))
//    implementation(project(":feature:episode:interface"))
    implementation(project(":feature:series:interface"))

    implementation(libs.androidx.paging.compose)
    implementation(libs.kotlinx.datetime)
}
