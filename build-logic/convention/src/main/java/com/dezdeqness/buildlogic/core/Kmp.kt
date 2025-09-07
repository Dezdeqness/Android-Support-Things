package com.dezdeqness.buildlogic.core

import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureKmp() {
    extensions.configure<KotlinMultiplatformExtension> {
        applyDefaultHierarchyTemplate()

        androidTarget {
            publishLibraryVariants("release", "debug")
        }
        iosSimulatorArm64()
        iosX64()
        iosArm64()
    }
}
