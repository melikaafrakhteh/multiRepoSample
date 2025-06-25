import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.androidGradlePlugin)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.kspGradlePlugin)
}

android {
    namespace = "org.company.app"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
        targetSdk = 35
        applicationId = "org.company.app.androidApp"
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kotlin {
    androidTarget()

    sourceSets {
        androidMain{
            dependencies {
                implementation(libs.androidx.activityCompose)
                implementation(libs.androidx.core.ktx)
                implementation(libs.androidx.appcompat)

                implementation(project(":composeApp"))
            }
        }
    }
}