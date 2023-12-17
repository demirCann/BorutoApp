plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
}

android {
    namespace = "com.demircandemir.borutoapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.demircandemir.borutoapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    configurations.all {
        resolutionStrategy {
            eachDependency {
                if ((requested.group == "org.jetbrains.kotlin") && (requested.name.startsWith("kotlin-stdlib"))) {
                    useVersion("1.8.0")
                }
            }
        }
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
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material:material:1.6.0-alpha06")
    implementation("androidx.compose.ui:ui-android:1.5.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")



    // Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.4.0-beta02")

    // Room components
    implementation ("androidx.room:room-runtime:2.5.2")
    kapt ("androidx.room:room-compiler:2.5.2")
    annotationProcessor("androidx.room:room-compiler:2.5.2")
    implementation ("androidx.room:room-ktx:2.5.2")
    implementation ("androidx.room:room-paging:2.5.2")


    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

    // Paging 3.0
    implementation ("androidx.paging:paging-compose:1.0.0-alpha14")

    // KotlinX Serialization
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")

    // DataStore Preferences
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // Dagger - Hilt
    implementation ("com.google.dagger:hilt-android:2.44")
    kapt ("com.google.dagger:hilt-android-compiler:2.44")
    kapt ("androidx.hilt:hilt-compiler:1.0.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0-alpha01")

    // Coil
    implementation("io.coil-kt:coil-compose:1.3.2")

    // Horizontal Pager and Indicators - Accompanist
    implementation ("com.google.accompanist:accompanist-pager:0.21.2-beta")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.21.2-beta")

    // Swipe to Refresh - Accompanist
    implementation ("com.google.accompanist:accompanist-swiperefresh:0.21.2-beta")

    // System UI Controller - Accompanist
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.21.2-beta")

    // Palette API
    implementation ("androidx.palette:palette-ktx:1.0.0")

    // Testing
    androidTestImplementation ("androidx.test:runner:1.4.0")
    androidTestImplementation ("androidx.test:rules:1.4.0")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.0.5")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.0.5")

    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.jetbrains.kotlin:kotlin-test-junit:1.5.31")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1")

}

kapt {
    correctErrorTypes = true
}