plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "uz.ibrohim.risola"
    compileSdk = 34

    defaultConfig {
        applicationId = "uz.ibrohim.risola"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Toast
    implementation(libs.toasts.saadiftkhar)

    //Navigation Fragment
    implementation (libs.androidx.fragment)
    implementation(libs.androidx.navigation)
    implementation(libs.androidx.navigationUi)

    //Language
    implementation(libs.lingver.language)

    //Glide
    annotationProcessor(libs.glide.compiler)
    implementation(libs.glide.bumptech)

    //ViewModel
    implementation(libs.viewModel.lifecycle)
    implementation(libs.viewModel.runtime)

    //Splash Animation
    implementation(libs.splash.airbnb)

    //CircleImage
    implementation(libs.circle.hdodenhof)
}