import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import java.util.Properties

class ApiKeyProviderConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        val keysProperties = Properties().apply {
            load(project.rootProject.file("keys.properties").inputStream())
        }

        extensions.configure<BaseAppModuleExtension> {
            defaultConfig.buildConfigField(
                "String",
                "API_KEY",
                keysProperties.getProperty("API_KEY")
            )
        }
    }
}
