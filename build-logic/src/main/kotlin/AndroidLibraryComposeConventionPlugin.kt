import com.android.build.gradle.LibraryExtension
import com.dantrap.cinemania.fintech.configureAndroidCompose
import com.dantrap.cinemania.fintech.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        pluginManager.apply(libs.plugins.android.library.get().pluginId)
        val extension = extensions.getByType<LibraryExtension>()
        configureAndroidCompose(extension)
    }
}
