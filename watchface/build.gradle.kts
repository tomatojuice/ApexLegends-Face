plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "jp.ne.sakura.tomatojuice.apexface"
    compileSdk = 36

    defaultConfig {
        applicationId = "jp.ne.sakura.tomatojuice.apexface"
        minSdk = 34
        targetSdk = 34
        versionCode = 11000006
        versionName = "3.1.4"
    }

    // 🌟 徹底掃除 1: 警告が出ていた部分を最新の書き方(directories.clear)に修正
    sourceSets {
        getByName("main") {
            java.directories.clear()
            kotlin.directories.clear()
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true // 🌟 これをTRUEにして！
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // 🌟 徹底掃除 2: 警告の出た renderScript を削除してクリーンに
    buildFeatures {
        buildConfig = false
        aidl = false
        resValues = false
    }

    // 🌟 徹底掃除 3: 強制的にDEXとKotlin系を排除
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

// 🌟 徹底掃除 4: ここは空のままでいいけど、念のためプロジェクトの libs フォルダを空にして！
dependencies {
}