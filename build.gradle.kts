plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.0"
}

group = "de.renao"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.RetroAchievements:api-kotlin:1.0.16")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:1.13.16")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}