plugins {
	id("java")
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.github.notjamesm"
version = "DEV-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

tasks.withType<Test> {
	useJUnitPlatform()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-jersey")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

	implementation("io.vavr:vavr:0.9.0")

	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}