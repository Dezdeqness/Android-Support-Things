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
    namespace = "com.dezdeqness.core"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
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
        artifactId = "core",
        version = "0.1.3"
    )

    pom {
        name.set("core")
    }
}