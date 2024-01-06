rootProject.name = "library"
include("library")
include("app")
include("sql")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}