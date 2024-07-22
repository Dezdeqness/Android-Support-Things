import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    id("maven-publish")
}

val props = Properties().apply {
    load(FileInputStream(rootProject.file("local.properties")))
}

android {
    namespace = "com.dezdeqness.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("core") {
                afterEvaluate {
                    from(components["release"])
                }
                groupId = "com.dezdeqness.support"
                artifactId = "core"
                version = "0.1.0"
            }

            repositories {
                maven {
                    name = "GitHubPackages"
                    url = uri("https://maven.pkg.github.com/Dezdeqness/Android-Support-Things")
                    credentials {
                        username = props["github.username"].toString()
                        password = props["github.token"].toString()
                    }
                }
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core)

    implementation(libs.androidx.appcompat)

    testImplementation(libs.junit.api)
    testImplementation(libs.junit.engine)

    implementation(libs.androidx.test.junit)
    implementation(libs.androidx.test.espresso)
    implementation(libs.dagger.dagger)
    ksp(libs.dagger.compilier)

}