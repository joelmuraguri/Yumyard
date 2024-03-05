import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.joel.conventions.config.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target){
            extensions.findByType(LibraryExtension::class.java)?.apply {
                configureAndroidCompose(this)
            }

            extensions.findByType(ApplicationExtension::class.java)?.apply {
                configureAndroidCompose(this)
            }
        }
    }

}