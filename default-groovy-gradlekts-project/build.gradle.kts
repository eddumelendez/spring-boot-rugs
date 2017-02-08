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
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
    }
}

apply {
    plugin("groovy")
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


dependencies {
    compile("org.springframework.boot:spring-boot-starter")
    compile("org.codehaus.groovy:groovy")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}
