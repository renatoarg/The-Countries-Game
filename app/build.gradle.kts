import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("org.jetbrains.kotlin.plugin.serialization")
    id ("com.google.devtools.ksp")
    // Hilt
    id ("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.renatoarg.composelist"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.renatoarg.composelist"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        val key: String = gradleLocalProperties(rootDir).getProperty("API_KEY")
        buildConfigField("String","API_KEY", "\"$key\"")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildToolsVersion = "34.0.0"
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.5.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    // Coil
    implementation("io.coil-kt:coil:2.6.0")
    implementation("io.coil-kt:coil-compose:2.6.0")

    // Lifecycle
    val lifecycle_version = "2.7.0"
    val arch_version = "2.2.0"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version") // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version") // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version") // LiveData
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version") // Lifecycle utilities for Compose
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version") // Annotation processor
    testImplementation("androidx.arch.core:core-testing:$arch_version") // optional - Test helpers for LiveData
    testImplementation ("androidx.lifecycle:lifecycle-runtime-testing:$lifecycle_version") // optional - Test helpers for Lifecycle runtime

    // OkHttp
    implementation("com.squareup.okhttp:okhttp:2.6.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    // retrofit
    val retrofitVersion = "2.9.0"
    implementation ("com.squareup.retrofit2:retrofit:${retrofitVersion}")
    implementation ("com.squareup.retrofit2:converter-gson:${retrofitVersion}")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Ktor
    val ktorVersion = "2.3.2"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-android:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}