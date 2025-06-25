plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.androidGradleLibraryPlugin)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.kspGradlePlugin)
}

apply(from = "../android-config.gradle")

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    wasmJs {
        browser()
        nodejs()
    }

    js {
        browser()
        nodejs()
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.material)
        }

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.components.resources)

            implementation(libs.kotlinx.serialization.json)
            implementation(libs.androidx.lifecycle.runtime)
        }
    }

}

android.namespace = "com.app.core.ui"