plugins {
    kotlin("js") version "1.5.30"
}

group = "me.tristanrothman"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.236-kotlin-1.5.30")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.236-kotlin-1.5.30")

    implementation(npm("postcss", "8.3.6"))
    implementation(npm("postcss-loader", "6.1.1"))
    implementation(npm("autoprefixer", "10.3.2"))
    implementation(npm("tailwindcss", "2.2.7"))
    implementation(npm("react", "17.0.2"))
    implementation(npm("react-dom", "17.0.2"))
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}

val copyTailwindConfig = tasks.register<Copy>("copyTailwindConfig") {
    from("./tailwind.config.js")
    into("${rootProject.buildDir}/js/packages/${rootProject.name}")

    dependsOn(":kotlinNpmInstall")
}

val copyPostcssConfig = tasks.register<Copy>("copyPostcssConfig") {
    from("./postcss.config.js")
    into("${rootProject.buildDir}/js/packages/${rootProject.name}")

    dependsOn(":kotlinNpmInstall")
}

tasks.named("compileKotlinJs") {
    dependsOn(copyTailwindConfig)
    dependsOn(copyPostcssConfig)
}

afterEvaluate {
    extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
        versions.webpackDevServer.version = "4.0.0"
    }
}

