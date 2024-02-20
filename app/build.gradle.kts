plugins {
	id("java")
}

group = "com.github.notjamesm"
version = "DEV-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

tasks.withType<Test> {
	useJUnitPlatform()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web:3.2.2")
	implementation("org.springframework.boot:spring-boot-starter-jersey:3.2.2")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.2.2")
	implementation("org.springframework:spring-jdbc:6.1.4")

	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

	implementation("io.vavr:vavr:0.9.0")

	implementation("com.zaxxer:HikariCP:5.1.0")
	runtimeOnly("org.postgresql:postgresql:42.7.1")

	testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.2")
}