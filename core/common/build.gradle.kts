plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidGradleLibraryPlugin)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.kspGradlePlugin)
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    wasmJs {
        browser()
        nodejs()
    }

    jvmToolchain(17)
}

android {
    namespace = "com.app.core.common"
    buildFeatures.buildConfig = true

    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
    }
}