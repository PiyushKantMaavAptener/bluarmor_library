plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")


}

android {
    namespace = "com.aptener.bluarmor_library"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {


    implementation(project(":bluConnect", configuration = "default"))
    implementation(project(path = ":rtk-bbpro"))
//    implementation(files("libs/bluconnect.aar"))
//    implementation(files("libs/rtk-bbpro.aar"))

//    implementation(project(":bluconnect"))
//    implementation(project(":rtk-bbpro"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

//
//    implementation("com.google.code.gson:gson:2.11.0")
//
//    implementation("com.google.dagger:dagger:2.51.1")
//
//    implementation("com.google.zxing:core:3.5.3")
//    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
//
//    implementation("com.jakewharton.timber:timber:5.0.1")
//
//    implementation("com.google.accompanist:accompanist-systemuicontroller:0.34.0")
//    implementation ("com.google.accompanist:accompanist-permissions:0.34.0")
//    implementation ("com.google.accompanist:accompanist-flowlayout:0.34.0")
//    implementation("com.google.android.gms:play-services-auth:21.2.0")
//
//
//    implementation(platform("com.google.firebase:firebase-bom:33.1.1"))
//    implementation("com.google.firebase:firebase-config-ktx")
//    implementation("com.google.firebase:firebase-storage-ktx")
//    implementation("com.google.firebase:firebase-analytics-ktx")
//    implementation("com.google.firebase:firebase-firestore-ktx")
//
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.8.1")
//    implementation("com.google.android.gms:play-services-location:21.3.0")
//
//    implementation("androidx.room:room-runtime:2.6.1")
////    ksp("androidx.room:room-compiler:2.6.1")
//    implementation("androidx.room:room-ktx:2.6.1")
//
//    implementation("no.nordicsemi.android:ble-ktx:2.7.5")
//    implementation("no.nordicsemi.android.support.v18:scanner:1.6.0")
//    implementation("no.nordicsemi.android:dfu:2.5.0")
//    implementation("com.google.protobuf:protobuf-javalite:4.26.1")
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.aptener" // Change this based on your organization
            artifactId = "bluarmor_library" // Change this based on your library name
            version = "1.0.4" // Update the version as needed

            afterEvaluate {
                from(components["release"])
            }

//            artifact("libs/bluconnect.aar")
//            artifact("libs/rtk-bbpro.aar")
        }
    }
}

