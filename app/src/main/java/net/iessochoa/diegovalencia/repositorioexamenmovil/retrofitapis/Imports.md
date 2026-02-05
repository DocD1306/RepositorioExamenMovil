Supongo que los import ya vendrán puestos pero por si acaso:

plugins de build.gradle.kts (Module: app):

    kotlin("plugin.serialization") version "2.2.21"

dependencies de build.gralde.kts (Module: app):

    // Runtime de Kotlin Serialization (JSON)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")

    // Retrofit core
    implementation("com.squareup.retrofit2:retrofit:3.0.0")

    // Converter oficial de Retrofit para kotlinx.serialization (NO Jake Wharton del Codelab que esta deprecated)
    implementation("com.squareup.retrofit2:converter-kotlinx-serialization:3.0.0")

    // 2. Imágenes (Coil)
    implementation("io.coil-kt:coil-compose:2.7.0")

    // 3. ViewModel & Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")

permisos a internet desde AndroidManifest.xml (se encuentra en la carpeta manifests):

    <uses-permission android:name="android.permission.INTERNET" />
