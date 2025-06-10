import org.gradle.kotlin.dsl.mavenCentral

rootProject.name = "MultiRepoSample"

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}


include(":app")
include(":composeApp")
include(":core:ui")
include(":core:common")
include(":feature:charity")
include(":feature:general")
