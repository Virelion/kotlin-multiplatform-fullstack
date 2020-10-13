plugins {
    kotlin("js")
    id("org.jlleitschuh.gradle.ktlint")
}

val coroutinesVersion: String by project

kotlin {
    js {
        nodejs {
            testTask {
                useMocha()
            }
        }
    }
}
