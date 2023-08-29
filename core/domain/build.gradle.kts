plugins {
    id("toongether.android.library")
    id("toongether.android.hilt")
}

android {
    namespace = "kr.toongether.domain"
}

dependencies {
    implementation(libs.androidx.paging.common)

    implementation(project(":core:model"))
    implementation(project(":core:data"))
}
