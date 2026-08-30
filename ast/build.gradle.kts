plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
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
            kotlin.srcDir("build/generated/ksp/desktop/desktopMain/kotlin")
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

dependencies {
    add("kspDesktop", project(":ast-viewbook-processor"))
}

compose.desktop {
    application {
        mainClass = "com.dezdeqness.ast.MainKt"
    }
}
