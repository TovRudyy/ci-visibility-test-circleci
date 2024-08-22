plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "datadog.ci.test"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

kotlin {
    jvmToolchain(8)
}
