// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false

    // Para dagger hilt
    id("com.google.dagger.hilt.android") version "2.48" apply false

    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
}