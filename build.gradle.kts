plugins {
    id("com.gradleup.shadow") version "8.3.0"
    id("java")
}

group = "online.nytheria"
version = "v0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.minestom:minestom-snapshots:96cedb1bab")
    implementation("ch.qos.logback:logback-classic:1.5.16")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

java {
    toolchain {
        // Minestom has a minimum Java version of 21.
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks {
    test {
        useJUnitPlatform()
    }

    jar {
        manifest {
            attributes["Main-Class"] = "online.nytheria.HelloWorld"
        }
    }

    build {
        dependsOn(shadowJar)
    }

    shadowJar {
        mergeServiceFiles()

        // Prevent the -all suffix on the shadow jar file.
        archiveClassifier.set("")
    }
}