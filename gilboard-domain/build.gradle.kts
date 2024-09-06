import org.springframework.boot.gradle.tasks.bundling.BootJar

val bootJar: BootJar by tasks
bootJar.enabled = false

val jar: Jar by tasks
jar.enabled = true

dependencies {
    implementation("org.hibernate:hibernate-spatial:6.3.1.Final")
    runtimeOnly("mysql:mysql-connector-java:8.0.33")
}