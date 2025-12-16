import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.dezdeqness.cmp.feature)
    id("com.vanniktech.maven.publish") version "0.34.0"
}

val props = Properties().apply {
    load(FileInputStream(rootProject.file("local.properties")))
}

android {
    namespace = "com.dezdeqness.core.ui"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.material3)
            implementation(libs.material.icons.core)
            implementation(libs.coil.compose)
        }

        val desktopMain by getting

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
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
        artifactId = "core-ui",
        version = "0.3.1-beta06"
    )

    pom {
        name.set("core-ui")
    }
}
