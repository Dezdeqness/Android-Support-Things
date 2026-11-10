plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
}

kotlin {
    jvm("desktop")

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.material3)
            implementation(ast.material.icons.core)
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
