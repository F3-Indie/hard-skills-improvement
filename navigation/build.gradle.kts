plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
}

android {
  namespace = "com.example.navigation"
  compileSdk = 33
  
  defaultConfig {
    minSdk = 24
    
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }
  
  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
  implementation(dependencyCatalog.bundles.ktxCommons)
  implementation(dependencyCatalog.navigation)
  implementation(dependencyCatalog.bundles.composeCommons)
  implementation(dependencyCatalog.navigationCompose)
}