import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.app.mova.library")
            extensions.getByType<LibraryExtension>().apply {
                buildFeatures.compose = true

                val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
                composeOptions.kotlinCompilerExtensionVersion =
                    libs.findVersion("androidComposeCompiler").get().toString()

                dependencies {
                    val bom = libs.findLibrary("androidx-compose-bom").get()
                    add("implementation", platform(bom))
                    add("androidTestImplementation", platform(bom))
                }
            }
        }
    }
}