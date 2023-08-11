plugins {
    id("toongether.android.library")
    id("toongether.android.hilt")
}

android {
    namespace = "kr.toongether.domain"
}

dependencies {

    implementation(project(":core:model"))
    implementation(project(":core:data"))
}
