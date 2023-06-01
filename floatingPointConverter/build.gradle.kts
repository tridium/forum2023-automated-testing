plugins {
    id("java")
}

group = "us.esanderson"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:6.14.3")
}

tasks.getByName<Test>("test") {
    useTestNG()
}