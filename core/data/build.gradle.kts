plugins {
    id("toongether.android.library")
    id("toongether.android.hilt")
}

android {
    namespace = "kr.toongether.data"
}

dependencies {

    implementation(project(":core:model"))
    implementation(project(":core:network"))
    implementation(project(":core:common"))

    implementation(libs.kotlinx.datetime)
    implementation(libs.androidx.paging.runtime)
}
