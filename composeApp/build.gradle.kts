import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.buildkonfig)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        outputModuleName = "composeApp"
//        compilerOptions {
//            freeCompilerArgs.add("-Xwasm-attach-js-exception")
//        }
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }

    sourceSets {

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            //Window Size class
            implementation("org.jetbrains.compose.material3:material3-window-size-class:1.7.3")

            //Constraints Layout
            implementation("tech.annexflow.compose:constraintlayout-compose-multiplatform:0.5.1")
        }
    }
}

buildkonfig {
    packageName = "syn.circus.portfolio"
    defaultConfigs {
        buildConfigField(STRING, "githubUrl", project.findProperty("githubUrl") as String? ?: "")
        buildConfigField(STRING, "linkedInUrl", project.findProperty("linkedInUrl") as String? ?: "")
        buildConfigField(STRING, "email", project.findProperty("email") as String? ?: "")
        buildConfigField(STRING, "address", project.findProperty("address") as String? ?: "")
        buildConfigField(STRING, "phone", project.findProperty("phone") as String? ?: "")
    }
}