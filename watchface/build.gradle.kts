plugins {
    id("com.android.application")
}
android {
    namespace = "jp.ne.sakura.tomatojuice.apexface"

    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }
    defaultConfig {
        applicationId = "jp.ne.sakura.tomatojuice.apexface"
        minSdk = 34
        targetSdk = 36
        versionCode = 11000011
        versionName = "3.2.0"
    }

    sourceSets {
        getByName("main") {
            java.directories.clear()
            kotlin.directories.clear()
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        buildConfig = false
        aidl = false
        resValues = false
    }

    packaging {
        resources {
            excludes += "classes.dex"
            excludes += "**/classes.dex"
            excludes += "kotlin/**"
            excludes += "META-INF/*.kotlin_module"
            excludes += "META-INF/com.android.tools/**"
        }
    }
    enableKotlin = false
}

dependencies {
}