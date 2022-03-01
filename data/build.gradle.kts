plugins {
    id("checkstyle-conventions")
    id("spring-module-conventions")
    id("testing-conventions")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")
}
