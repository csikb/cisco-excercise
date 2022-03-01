plugins {
    id("checkstyle-conventions")
    id("spring-module-conventions")
    id("testing-conventions")
}

dependencies {
    api(project(":service"))
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springdoc:springdoc-openapi-ui:${property("springdocVersion")}")
}
