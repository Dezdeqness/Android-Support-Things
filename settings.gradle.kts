pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("version-catalog/libs.versions.toml"))
        }
        create("ast") {
            from(files("gradle/ast.versions.toml"))
        }
    }
}

rootProject.name = "Android Support Things"
include(":core-ui")
include(":core")
include(":core-settings")
include(":version-catalog")

include(":ast")
include(":ast-viewbook-core")
include(":ast-viewbook-processor")