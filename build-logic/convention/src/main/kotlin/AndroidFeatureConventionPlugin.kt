import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("toongether.android.library")
                apply("toongether.android.hilt")
                apply("toongether.kotlin.code")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                add("implementation", project(":core:model"))
                add("implementation", project(":core:ui"))
                add("implementation", project(":core:designsystem"))
                add("implementation", project(":core:data"))
                add("implementation", project(":core:domain"))

                add("testImplementation", kotlin("test"))
                add("androidTestImplementation", kotlin("test"))

                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
                add("implementation", libs.findLibrary("orbit.mvi.viewmodel").get())
                add("implementation", libs.findLibrary("orbit.mvi.compose").get())
                add("implementation", libs.findLibrary("navigation.animation").get())

                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
            }
        }
    }
}
