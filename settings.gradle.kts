enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
        maven("https://androidx.dev/storage/compose-compiler/repository")
        maven("https://jitpack.io")
        maven("https://androidx.dev/storage/compose-compiler/repository")
    }
}


dependencyResolutionManagement {
    repositories {
        google()
        flatDir { dirs("libs") }
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
        maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
        maven("https://androidx.dev/storage/compose-compiler/repository")
        maven("https://jitpack.io")
    }
}

rootProject.name = "MultiRepoSample"

include(":app")
include(":composeApp")
include(":core:ui")
include(":core:common")
include(":feature:charity")
include(":feature:general")
