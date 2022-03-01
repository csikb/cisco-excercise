import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("java-conventions")
    id("io.spring.dependency-management")
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2021.0.0"
extra["springdocVersion"] = "1.6.6"

dependencyManagement {
    imports {
        // https://docs.spring.io/spring-boot/docs/2.6.3/gradle-plugin/reference/htmlsingle/#managing-dependencies.dependency-management-plugin.using-in-isolation
        mavenBom(SpringBootPlugin.BOM_COORDINATES)
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}
