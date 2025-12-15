
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    jvm("desktop")

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.material3)
            implementation(libs.material.icons.core)
            implementation(compose.components.resources)
            implementation(libs.coil.compose)
            implementation(project(":core-ui"))
            implementation(project(":ast-viewbook-core"))
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.dezdeqness.ast.MainKt"
    }
}
