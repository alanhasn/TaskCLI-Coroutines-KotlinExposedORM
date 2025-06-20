plugins {
    kotlin("jvm") version "2.1.20"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // Exposed ORM
    implementation("org.jetbrains.exposed:exposed-core:0.50.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.50.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.50.1")

    // SQLite
    implementation("org.xerial:sqlite-jdbc:3.42.0.0")

    implementation("org.slf4j:slf4j-simple:2.0.9")

    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}