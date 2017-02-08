import org.gradle.jvm.tasks.Jar

buildscript {
    ext {
        val springBootVersion = "$boot_version"
    }
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
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
