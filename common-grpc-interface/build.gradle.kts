import com.google.protobuf.gradle.*

extra.apply {
    set("protobufVersion", "3.6.1")
    set("grpcVersion", "1.42.1")
}

plugins {
    id("java-library")
    id("com.google.protobuf") version "0.8.18"
}

group = "ru.tinkoff"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:${project.extra["protobufVersion"]}")
    implementation("io.grpc:grpc-protobuf:${project.extra["grpcVersion"]}")
    implementation("io.grpc:grpc-stub:${project.extra["grpcVersion"]}")
    compileOnly("jakarta.annotation:jakarta.annotation-api:1.3.5") // Java 9+ compatibility - Do NOT update to 2.0.0
}

sourceSets {
    main {
        java {
            srcDirs("src/main/java", "build/generated/source/proto/main")
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

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}