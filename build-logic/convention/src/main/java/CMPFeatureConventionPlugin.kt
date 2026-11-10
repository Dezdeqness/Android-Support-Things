import com.dezdeqness.buildlogic.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class CMPFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.rootProject.project
        with(target) {
            with(pluginManager) {
                apply("com.dezdeqness.kmp.library")
                apply(libs.findPlugin("jetbrains-compose").get().get().pluginId)
                apply(libs.findPlugin("compose-compiler").get().get().pluginId)
            }
        }
    }
}
