plugins {
    kotlin("multiplatform")
    id("org.jlleitschuh.gradle.ktlint")
}

val coroutinesVersion: String by project
val ktorVersion: String by project

kotlin {
//    jvm()
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
                api(project(":commons"))
                implementation("io.ktor:ktor-client-core:$ktorVersion")

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            }
        }

        val commonTest by getting {
            dependencies {
            }
        }

//        val jvmMain by getting {
//            dependencies {
//            }
//        }
//
//        val jvmTest by getting {
//            dependencies {
//            }
//        }

        val jsTest by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:$ktorVersion")
            }
        }
    }
}
