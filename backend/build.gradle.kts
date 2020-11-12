plugins {
    kotlin("jvm")
    application
    id("org.jlleitschuh.gradle.ktlint")
}

val coroutinesVersion: String by project
val ktorVersion: String by project

application {
    mainClass.set("com.github.virelion.template.backend.MainKt")
}

kotlin {
    dependencies {
        implementation(project(":commons"))

        implementation(kotlin("stdlib-jdk8"))

        implementation("io.ktor:ktor-server-core:$ktorVersion")
        implementation("io.ktor:ktor-server-netty:$ktorVersion")
    }
}
