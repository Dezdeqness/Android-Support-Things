plugins {
    alias(ast.plugins.dezdeqness.cmp.feature)
}

android {
    namespace = "com.dezdeqness.ast.viewbook.core"
}

kotlin {

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.material3)
            implementation(ast.material.icons.core)
            implementation(libs.coil.compose)
            implementation(project(":core-ui"))
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}
