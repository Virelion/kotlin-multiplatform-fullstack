plugins {
    kotlin("js")
    id("org.jlleitschuh.gradle.ktlint")
}

val coroutinesVersion: String by project
val kotlinReactVersion: String by project

kotlin {
    js {
        browser {
            testTask {
                useMocha()
            }
        }
        binaries.executable()
    }
}

dependencies {
    implementation(project(":frontend:frontend-commons"))

    implementation("org.jetbrains:kotlin-react:$kotlinReactVersion")
    implementation("org.jetbrains:kotlin-react-dom:$kotlinReactVersion")
    implementation("org.jetbrains:kotlin-react-router-dom:5.1.2-pre.124-kotlin-1.4.10")


    implementation(npm("react-quill", "1.3.5"))
    implementation(npm("axios", "0.19.2"))
    implementation(npm("react-router-dom", "5.2.0"))
}