plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.home"
}

dependencies {

    implementation(project(":core:designsystem"))
}
