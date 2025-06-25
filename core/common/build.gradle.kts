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
    compileSdk = 35
    buildFeatures.buildConfig = true

    defaultConfig {
        minSdk = 21
        targetSdk = 35
    }

}