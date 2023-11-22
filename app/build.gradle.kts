plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.securitycameraials"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.securitycameraials"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // FIREBASE
    implementation(platform("com.google.firebase:firebase-bom:32.6.0"))
    implementation ("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-firestore:24.8.1-ktx")
    implementation("com.google.firebase:firebase-database-ktx:20.2.2")
    implementation ("com.google.firebase:firebase-storage:20.3.0")
    implementation ("com.firebaseui:firebase-ui-firestore:8.0.1")
    // PICASSO
    implementation ("com.squareup.picasso:picasso:2.5.2")
    implementation ("com.squareup.picasso:picasso:2.71828")
    // ANDROIDX

    implementation ("com.google.android.material:material:1.10.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-storage:20.3.0")
    // TESTING
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
}
