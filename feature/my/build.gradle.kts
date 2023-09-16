plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.my"
}

dependencies {
    implementation(project(":feature:auth:login"))
    implementation(project(":feature:auth:signup"))

    implementation(project(":core:datastore"))
}
