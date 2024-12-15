dependencies {
    implementation(project(":gilboard-domain"))
    implementation(project(":gilboard-infra"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    testImplementation("org.springframework.security:spring-security-test")
}
