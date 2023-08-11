import com.android.build.gradle.LibraryExtension
import kr.toongether.android.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                add("implementation", libs.findLibrary("androidx.compose.material3").get())
                add("implementation", libs.findLibrary("androidx.compose.material").get())
                add("implementation", libs.findLibrary("androidx.navigation.compose").get())

                add("androidTestImplementation", libs.findLibrary("androidx.test.espresso.core").get())
                add("androidTestImplementation", libs.findLibrary("androidx.test.runner").get())
                add("androidTestImplementation", libs.findLibrary("androidx.test.ext").get())
            }
        }
    }
}