import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.joel.convention.config.configureRoom
import org.gradle.api.Plugin
import org.gradle.api.Project

class RoomAndroidConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target){
            with(pluginManager){
                apply("com.google.devtools.ksp")
            }

            extensions.findByType(ApplicationExtension::class.java)?.let {
                configureRoom(it)
            }

            extensions.findByType(LibraryExtension::class.java)?.let {
                configureRoom(it)
            }
        }
    }
}