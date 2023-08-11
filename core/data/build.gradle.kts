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
}
