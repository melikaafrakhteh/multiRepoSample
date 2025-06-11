plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.android.library")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.google.devtools.ksp") version "2.1.21-2.0.1"
}

android {
    namespace = "com.app.feature.general"
    compileSdk = 35

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }

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

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.androidx.navigation.compose)

                implementation(project(":core:common"))
                implementation(project(":core:ui"))
            }
        }
    }
}
