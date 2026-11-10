import java.io.FileInputStream
import java.util.Properties

plugins {
    `version-catalog`
    id("com.vanniktech.maven.publish") version "0.34.0"
}

val props = Properties().apply {
    val file = rootProject.file("local.properties")
    if (file.exists()) {
        load(FileInputStream(file))
    }
}

catalog {
    versionCatalog {
        from(files("libs.versions.toml"))
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
        artifactId = "version-catalog",
        version = "0.1.0"
    )

    pom {
        name.set("version-catalog")
    }
}
