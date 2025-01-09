import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    id("maven-publish")
}

val props = Properties().apply {
    load(FileInputStream(rootProject.file("local.properties")))
}

android {
    namespace = "com.dezdeqness.core.ui"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("coreUi") {
                afterEvaluate {
                    from(components["release"])
                }
                groupId = "com.dezdeqness.support"
                artifactId = "core-ui"
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
    implementation(libs.google.material)

    implementation(libs.androidx.core)

    implementation(libs.androidx.appcompat)

    testImplementation(libs.junit.api)
    testImplementation(libs.junit.engine)
    implementation(libs.androidx.test.junit)
    implementation(libs.androidx.test.espresso)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui.ui)
    implementation(libs.androidx.compose.ui.util)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.preview)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.activity.compose)
}