import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.dezdeqness.kmp.library)
    id("com.vanniktech.maven.publish") version "0.34.0"
}

val props = Properties().apply {
    load(FileInputStream(rootProject.file("local.properties")))
}

android {
    namespace = "com.dezdeqness.core.settings"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.datastore.core)
            implementation(libs.datastore.preferences)
        }
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Dezdeqness/Android-Support-Things")
            credentials {
                username = props["github.username"]?.toString()
                password = props["github.token"]?.toString()
            }
        }
    }
}

mavenPublishing {
    coordinates(
        groupId = "com.dezdeqness.support",
        artifactId = "core-settings",
        version = "0.1.0"
    )

    pom {
        name.set("core-settings")
    }
}
