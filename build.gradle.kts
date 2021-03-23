plugins {
    kotlin("jvm") version "1.4.21"
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("http://repo.e-iceblue.com/nexus/content/groups/public/")
    }
}
tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.docutil.MainKt"
    }
    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}
dependencies {
    implementation(kotlin("stdlib"))
    implementation("e-iceblue:spire.pdf:3.11.6")
    implementation("org.apache.pdfbox:pdfbox:2.0.21")
    implementation("javax.xml.bind:jaxb-api:2.3.0")
}