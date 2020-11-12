plugins {
    kotlin("multiplatform")
    id("org.jlleitschuh.gradle.ktlint")
    kotlin("plugin.serialization")
}

val coroutinesVersion: String by project
val kotlinxSerializationVersion: String by project

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
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
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
