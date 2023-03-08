plugins {
    kotlin("jvm") version "1.8.20-Beta"
}

group = "nxt.extensions"
version = "0.0.1"

repositories {
    mavenLocal()
    maven("https://repo.flawcra.cc/mirrors")
}

val compiles = listOf(
    "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.10",  // Kotlin Standard Library
    "com.github.TheFruxz:Ascend:2023.1",
    "org.spigotmc:spigot-api:1.19.3-R0.1-SNAPSHOT",
    "nxt:nxtbase:0.1.2"
)

dependencies {

    compiles.forEach { dependency ->
        compileOnly(dependency)
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks {

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
        kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
    }

    withType<ProcessResources> {
        filesMatching("extension.json") {
            expand(project.properties)
        }
    }
}

kotlin {
    jvmToolchain(17)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withJavadocJar()
    withSourcesJar()
}