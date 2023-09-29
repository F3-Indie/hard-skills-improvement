pluginManagement {
    repositories {
        google()
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

        create("dependencyCatalog") {

            //-----------------------Orbit
            val version = "6.1.0"

            library("orbitCore", "org.orbit-mvi", "orbit-core").version(version)
            library("orbitViewmodel", "org.orbit-mvi", "orbit-viewmodel").version(version)
            library("orbitCompose", "org.orbit-mvi", "orbit-compose").version(version)

            bundle("orbit", listOf("orbitCore", "orbitViewmodel", "orbitCompose"))

            //-----------------------AndroidX core

            val androidxCoreVersion = "1.1.2"
            val androidxLifecycleVersion = "2.6.2"
            val appCompatVersion = "1.6.1"
            val navigationVersion = "2.7.3"

            library("ktxCore", "androidx.core", "core-ktx").version(androidxCoreVersion)
            library("appcompat", "androidx.appcompat", "appcompat").version(appCompatVersion)
            library("navigation", "androidx.navigation", "navigation-ui-ktx").version(
                navigationVersion
            )
            library("ktxLifecycle", "androidx.lifecycle", "lifecycle-runtime-ktx").version(
                androidxLifecycleVersion
            )

            bundle("ktxCommons", listOf("ktxCore", "appcompat", "ktxLifecycle"))

            //-----------------------Compose

            val composeCoreVersion = "1.5.2"
            val composeMaterialVersion = "1.1.2"
            val activityComposeVersion = "1.7.2"

            library("composeUi", "androidx.compose.ui", "ui").version(composeCoreVersion)
            library("composeUiGraphics", "androidx.compose.ui", "ui-graphics").version(composeCoreVersion)
            library("composeToolingPreview", "androidx.compose.ui", "ui-tooling-preview").version(
                composeCoreVersion
            )
            library("composeMaterial3", "androidx.compose.material3", "material3").version(
                composeMaterialVersion
            )
            library("activityCompose", "androidx.activity", "activity-compose").version(
                activityComposeVersion
            )
            library("navigationCompose", "androidx.navigation", "navigation-compose").version(
                navigationVersion
            )

            bundle("composeCommons", listOf("composeUi", "composeUiGraphics", "composeToolingPreview", "composeMaterial3", "activityCompose"))

            //-----------------------Google services

            val guavaVersion = "28.2-android"
            val googleApiVersion = "1.23.0"
            val googleSheetsVersion = "v4-rev612-1.25.0"

            library("guava", "com.google.guava", "guava").version(guavaVersion)
            library("googleApi", "com.google.api-client", "google-api-client-android").version(googleApiVersion)
            library("googleSheets", "com.google.apis", "google-api-services-sheets").version(googleSheetsVersion)

            val gsonVersion = "2.10.1"

            library("gson", "com.google.code.gson", "gson").version(gsonVersion)
        }
    }
}

rootProject.name = "hard-skills-improvement"
include(":app")
include(":myuikit")
include(":navigation")
include(":sheets")
