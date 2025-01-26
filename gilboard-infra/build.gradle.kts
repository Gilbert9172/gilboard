dependencies {
    implementation(project(":gilboard-domain"))
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.redisson:redisson-spring-boot-starter:3.42.0")
    implementation("org.springframework.boot:spring-boot-starter-aop:3.4.1")
}

