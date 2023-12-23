plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = org.gradle.api.JavaVersion.VERSION_17
    targetCompatibility = org.gradle.api.JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "com.app.mova.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidApplication") {
            id = "com.app.mova.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidHilt") {
            id = "com.app.mova.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "com.app.mova.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidFeatures") {
            id = "com.app.mova.features"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
    }
}