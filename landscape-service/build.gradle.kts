import com.google.protobuf.gradle.*

extra.apply {
    set("protobufVersion", "3.6.1")
    set("grpcVersion", "1.42.1")
}

plugins {
    java
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
    id("com.google.protobuf") version "0.8.18"
}

group = "ru.tinkoff"
version = "0.0.2-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("io.micrometer:micrometer-registry-prometheus")

    implementation("net.devh:grpc-server-spring-boot-starter:2.14.0.RELEASE")
    implementation(project(":common-grpc-connectivity"))
    implementation("com.google.protobuf:protobuf-java-util:3.22.2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

sourceSets {
    main {
        java {
            srcDirs("src/main/java", "build/generated/source/proto/main/grpc", "build/generated/source/proto/main/java")
        }
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${project.ext["protobufVersion"]}"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${project.ext["grpcVersion"]}"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
            }
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
