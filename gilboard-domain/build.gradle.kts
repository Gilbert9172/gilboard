import org.springframework.boot.gradle.tasks.bundling.BootJar

val bootJar: BootJar by tasks
bootJar.enabled = false

val jar: Jar by tasks
jar.enabled = true

dependencies {
    implementation("org.hibernate:hibernate-spatial:6.3.1.Final")
    runtimeOnly("mysql:mysql-connector-java:8.0.33")

    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    annotationProcessor("com.querydsl:querydsl-apt:5.0.0:jakarta")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
}

val buildDir = layout.buildDirectory.get()
val mainDir = "generated/sources/annotationProcessor/java/main"

sourceSets {
    main {
        java {
            srcDir("$buildDir/$mainDir")
        }
    }
}

tasks.withType<JavaCompile> {
    options.generatedSourceOutputDirectory.set(file("$buildDir/$mainDir"))
}

tasks.register<Delete>("cleanGenerated") {
    delete(file("$buildDir/generated"))
}

tasks.named("clean") {
    dependsOn("cleanGenerated")
}