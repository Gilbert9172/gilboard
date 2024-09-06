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
    group = "com.gilbertkdbshop"
    version = "0.0.1-SNAPSHOT"

    tasks.withType<JavaCompile> {
        sourceCompatibility = "21"
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenCentral()
    }

    dependencies {
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