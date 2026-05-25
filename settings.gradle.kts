pluginManagement {
    def flutterSdkPath = {
        def properties = new Properties()
        def propertiesFile = settingsDir.parentFile.toPath().resolve("local.properties").toFile()
        if (propertiesFile.exists()) {
            propertiesFile.withReader("UTF-8") { reader -> properties.load(reader) }
        }
        def flutterSdkPath = properties.getProperty("flutter.sdk")
        assert flutterSdkPath != null, "Flutter SDK not found. Define location with flutter.sdk in local.properties."
        return flutterSdkPath
    }()

    includeBuild("$flutterSdkPath/packages/flutter_tools/gradle")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id "dev.flutter.flutter-plugin-loader" version "1.0.0"
    id "com.android.application" version "8.2.0" apply false
    // هنا حددنا إصدار كوتلن المتوافق 1.9.20 عشان يحل المشكلة فوراً
    id "org.jetbrains.kotlin.android" version "1.9.20" apply false
}

include ":app"