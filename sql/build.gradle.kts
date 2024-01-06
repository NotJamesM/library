plugins {
    id("java")
    id("org.flywaydb.flyway") version "10.4.1"
}

group = "com.github.notjamesm"
version = "DEV-SNAPSHOT"

val libraryRolePassword = System.getenv("LIBRARY_ROLE_PASSWORD") ?: "password"

flyway {
    url = System.getenv("DATABASE_URL")
    user = System.getenv("DATABASE_USERNAME")
    password = System.getenv("DATABASE_PASSWORD")
    locations = arrayOf("filesystem:src/main/resources/db")
    placeholders = mapOf(
        "libraryRolePassword" to libraryRolePassword
    )
}

buildscript {
    dependencies {
        classpath("org.flywaydb:flyway-database-postgresql:10.4.1")
    }
}

dependencies {
    implementation("org.postgresql:postgresql:42.7.1")
}