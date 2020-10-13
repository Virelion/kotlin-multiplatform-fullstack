plugins {
    kotlin("multiplatform")
    id("org.jlleitschuh.gradle.ktlint")
}

val coroutinesVersion: String by project

kotlin {
    jvm()
    js {
        nodejs {
            testTask {
                useMocha()
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            }
        }

        val commonTest by getting {
            dependencies {
            }
        }

        val jvmMain by getting {
            dependencies {
            }
        }

        val jvmTest by getting {
            dependencies {
            }
        }

        val jsTest by getting {
            dependencies {
            }
        }
    }
}
