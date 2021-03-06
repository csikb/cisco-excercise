plugins {
    id("checkstyle-conventions")
    id("spring-module-conventions")
    id("testing-conventions")
}

dependencies {
    api(project(":data"))
    implementation("org.springframework:spring-context")
    api("org.springframework.boot:spring-boot-starter-data-jpa")
}
