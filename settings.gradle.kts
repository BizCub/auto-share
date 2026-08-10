pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.kikugie.dev/snapshots")
        maven("https://maven.fabricmc.net")
    }
}

plugins {
    id("dev.kikugie.stonecutter") version "0.9+"
    id("io.github.bizcub.multiloader") version "0.8+"
}

multiloader {
    match("26.1.2", fb, nf)
    match("1.21.1", fb, nf)
    match("1.20.4", fb)
    match("1.20.2", fb)
    match("1.20.1", fb)
}
