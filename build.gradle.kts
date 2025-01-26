import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

allprojects {
    group = "com.gilboard"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral() // Maven Central Repository
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = "21"
    }
}

val bootJar: BootJar by tasks
bootJar.enabled = false

val jar: Jar by tasks
jar.enabled = true


subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenCentral() // Maven Central 추가
    }

    dependencies {
        annotationProcessor("jakarta.annotation:jakarta.annotation-api")
        annotationProcessor("jakarta.persistence:jakarta.persistence-api")
        implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
        annotationProcessor("com.querydsl:querydsl-apt:5.0.0:jakarta")

        implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.2")
        implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        // dev tools
        developmentOnly("org.springframework.boot:spring-boot-devtools")
        // Lombok
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")
        // JUnit5
        testImplementation(platform("org.junit:junit-bom:5.10.3"))
        testImplementation("org.junit.jupiter:junit-jupiter")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
        testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
        // AssertJ
        testImplementation("org.assertj:assertj-core:3.25.3")
        // Mockito
        testImplementation("org.mockito:mockito-core:5.11.0")
    }

    tasks.named<Test>("test") {
        useJUnitPlatform()
    }

    tasks.register("prepareKotlinBuildScriptModel") {
        // 빈 작업
    }
}
