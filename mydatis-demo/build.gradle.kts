plugins {
    kotlin("jvm") version "2.3.20"
}

group = "jp.ac.it_college.std.s25005.kotlin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val mybatisGenerator by configurations.creating

dependencies {
    implementation("org.mybatis:mybatis:3.5.19")
    implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:2.0.0")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client:3.5.8")
    testImplementation(kotlin("test"))
    mybatisGenerator("org.mybatis.generator:mybatis-generator-core:2.0.0")
}

kotlin {
    jvmToolchain(25)
}

tasks.test {
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