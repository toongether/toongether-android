plugins {
    id("toongether.android.library")
    id("toongether.android.hilt")
    id("toongether.kotlin.code")
}

android {
    namespace = "kr.toongether.domain"
}

dependencies {

    implementation(project(":core:model"))
    implementation(project(":core:data"))

    implementation(libs.core.ktx)
    testImplementation(libs.junit)
}
