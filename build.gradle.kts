plugins {
    kotlin("jvm") version "2.3.20-RC3"
    id("com.gradleup.shadow") version "8.3.0"
}

allprojects {
    group = "xyz.thehiddenobject"
    version = "1.0.0"
}

repositories {
    mavenCentral()
}

subprojects {
    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/") {
            name = "papermc-repo"
        }
    }

    apply {
        plugin("kotlin")
    }

    dependencies {

    }

    kotlin {
        jvmToolchain(21)
    }
}

tasks.build {
    dependsOn("shadowJar")
}