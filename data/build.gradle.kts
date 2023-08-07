plugins {
    id("java")
}

group = "org.gardencorporation"
version = "unspecified"

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.hibernate.orm:hibernate-core:6.2.7.Final")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("com.mysql:mysql-connector-j:8.1.0")
}

tasks.test {
    useJUnitPlatform()
}
