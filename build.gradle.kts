group = "io.github.selevinia"
version = "0.3.2"
description = "Spring boot starter for Spring Framework's caching support with Tarantool"

plugins {
    `java-library`
    `maven-publish`
    signing
}

repositories {
    mavenLocal()
    mavenCentral()
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    api("org.springframework.boot:spring-boot-starter:2.5.2")
    api("io.github.selevinia:selevinia-spring-boot-autoconfigure-tarantool:0.3.2")
    api("io.github.selevinia:spring-data-tarantool:0.3.2")
    api("io.tarantool:cartridge-driver:0.4.3") {
        exclude("io.netty", "netty-all")
    }
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            pom {
                name.set("Spring Boot Caching Tarantool Starter")
                description.set("SSpring boot starter for Spring Framework's caching support with Tarantool")
                url.set("https://github.com/selevinia/spring-boot-starter-cache-tarantool")

                scm {
                    connection.set("scm:git:git://github.com/selevinia/spring-boot-starter-cache-tarantool.git")
                    developerConnection.set("scm:git:ssh://github.com/selevinia/spring-boot-starter-cache-tarantool.git")
                    url.set("https://github.com/selevinia/spring-boot-starter-cache-tarantool")
                }

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("rx-alex")
                        name.set("Alexander Rublev")
                        email.set("invalidator.post@gmail.com")
                    }
                    developer {
                        id.set("t-obscurity")
                        name.set("Tatiana Blinova")
                        email.set("blinova.tv@gmail.com")
                    }
                }
            }
        }
    }
    repositories {
        maven {
            val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            credentials {
                username = rootProject.findProperty("nexus.username").toString()
                password = rootProject.findProperty("nexus.password").toString()
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}