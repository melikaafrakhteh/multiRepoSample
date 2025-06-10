plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.app.feature.charity"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
        targetSdk = 35
    }

}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    wasmJs()

    sourceSets {
        getByName("commonMain").apply {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.material)
                implementation(compose.components.resources)

                implementation(libs.androidx.navigation.compose)

                implementation(project(":core:common"))
                implementation(project(":core:ui"))
            }
        }
    }

}