Hello Guys!!

This is my simple portfolio using the KMP (Kotlin Multiplatform Mobile) framework.

In this project, I have used KMM to create a simple portfolio app that showcases my projects and
skills. The app is built using Kotlin and Jetpack Compose for the UI, and it runs on both Android
and iOS platforms.

## Developer Guide

I use environment variables setup for [buildkonfig](https://github.com/yshrsmz/BuildKonfig) library.

SetUp what is said in the main repository ,setUp the buildkonfig and run the following commend in
terminal to generate the BuildConfig file.

```
.\gradlew generateBuildKonfig
```

To run the project, you can use the following commands:

```
:composeApp:wasmJsBrowserDevelopmentRun -a -t
:composeApp:wasmJsBrowserProductionRun -a -t
``` 

The following command is to generate the file which is to be able to use GitHub Page

```:composeApp:wasmJsBrowserProductionWebpack```

and then copy the file to the `docs` folder in the root directory of the project.