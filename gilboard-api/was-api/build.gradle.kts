import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation(project(":gilboard-domain"))
    implementation(project(":gilboard-infra"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.named<BootJar>("bootJar") {
    mainClass.set("com.gilboard.was.GilboardApiApplication")
}

sourceSets {
    main {
        java {
            srcDir("src/main/java")
        }
    }
}
