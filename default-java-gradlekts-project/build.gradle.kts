import org.gradle.jvm.tasks.Jar

buildscript {
    val kotlinVersion = "1.0.6"
    val springBootVersion = "$boot_version"
    extra["kotlinVersion"] = kotlinVersion

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

apply {
    plugin("java")
    plugin("eclipse")
    plugin("org.springframework.boot")
}

tasks.withType<Jar> {
    baseName = "$artifact_id"
    version = "0.0.1-SNAPSHOT"
}

configure<JavaPluginConvention> {
    setSourceCompatibility(1.8)
}

repositories {
    mavenCentral()
}


val kotlinVersion = extra["kotlinVersion"] as String

dependencies {
    compile("org.springframework.boot:spring-boot-starter")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}
