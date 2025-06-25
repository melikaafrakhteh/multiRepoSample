plugins {
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.androidGradlePlugin) apply false
    alias(libs.plugins.kotlinxSerialization) apply false
    alias(libs.plugins.kspGradlePlugin) apply false
    alias(libs.plugins.androidGradleLibraryPlugin) apply false
    alias(libs.plugins.kotlinGradlePlugin) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}
