plugins {
    kotlin("jvm") version "2.3.21"
    kotlin("plugin.spring") version "2.3.21"
    id("org.springframework.boot") version "4.0.6"
    id("io.spring.dependency-management") version "1.1.7"
    // kotlin-serialization
    kotlin("plugin.serialization") version "2.3.21"
}

group = "jp.ac.it_college.std.s25005.kotlin"
version = "0.0.1-SNAPSHOT"
description = "book-manager"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

repositories {
    mavenCentral()
}

val mybatisGenerator by configurations.creating

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:4.0.1")
    implementation("tools.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-security")
    testImplementation("org.springframework.security:spring-security-test")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:4.0.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // MyBatis 関連の追加
    implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:2.0.0")
    mybatisGenerator("org.mybatis.generator:mybatis-generator-core:2.0.0")

    // ライブラリの追加
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.8.0")

    // argon2 を使うためのライブラリ
    implementation("org.bouncycastle:bcprov-jdk18on:1.84")

    // AOP を使うためのライブラリ追加
    implementation("org.springframework.boot:spring-boot-starter-aspectj")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register("mbGenerator") {
    description = "run MyBatis Generator"
    doLast {
        val classpath = listOf(
            mybatisGenerator.asPath,
            sourceSets["main"].runtimeClasspath.asPath
        ).joinToString(File.pathSeparator)

        ant.withGroovyBuilder {
            "taskdef"(
                "name" to "mybatisGenerator",
                "classname" to "org.mybatis.generator.ant.GeneratorAntTask",
                "classpath" to classpath
            )
            "mybatisGenerator"(
                "overwrite" to true,
                "configFile" to file("src/main/resources/generatorConfig.xml"),
                "verbose" to true,
            )
        }
    }
}
