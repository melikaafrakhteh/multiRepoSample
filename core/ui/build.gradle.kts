plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.android.application)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.app.core.ui"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
        targetSdk = 35
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        getByName("commonMain").apply {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.material)
                implementation(compose.components.resources)
                implementation("org.jetbrains.compose.runtime:runtime:1.6.2")

                implementation(libs.kotlinx.serialization.json)
                implementation(libs.androidx.lifecycle.runtime)
            }
        }
    }

}