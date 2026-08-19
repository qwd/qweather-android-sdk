[English](config.md) | [中文](../zh/config.md) · [← Back](../../README.md)

# Configuration

**Requirement**

Android 8.0+, minSDK 26

## 1. Create project and credential

Make sure you have created a Project and Credential, see [Project and KEY](https://dev.qweather.com/en/docs/configuration/project-and-key/) and [JWT](https://dev.qweather.com/en/docs/configuration/authentication/#json-web-token) authentication.

## 2. Installation

Download SDK: [QWeatherSDK 5.2.3](https://github.com/qwd/qweather-android-sdk/releases/tag/5.2.3)  • [Release note](https://github.com/qwd/qweather-android-sdk/releases)

* Copy the JAR file to the `app/libs/`

```bash
YOUR-PROJECT/
├── app/
│   ├── libs/
│   │   └── QWeather_Public_Android_V5.2.2.jar
│   ├── src/
│   └── build.gradle
```

* Update the Gradle configuration `app/build.gradle`

```bash
dependencies {
    // add QWeather jar
    implementation files('libs/QWeather_Public_Android_V5.2.2.jar')
    
    // or add all jar
    implementation fileTree(dir: 'libs', include: ['*.jar'])
}
```

* Reference library

```bash
implementation 'com.squareup.okhttp3:okhttp:4.12.0'
implementation 'com.google.code.gson:gson:2.10.1'
implementation 'net.i2p.crypto:eddsa:0.3.0'
```

* Add the following code to the obfuscation file `proguard-rules.pro`

```java
-keep public class com.qweather.sdk.QWeather {
    public *;
}

-keep public class com.qweather.sdk.basic.**{ *; }
-keepclassmembers class com.qweather.sdk.basic** { *; }

-keep public class com.qweather.sdk.parameter.**{ *; }
-keepclassmembers class com.qweather.sdk.parameter** { *; }

-keep public class com.qweather.sdk.response.**{ *; }
-keepclassmembers class com.qweather.sdk.response** { *; }

-keep interface com.qweather.sdk.Callback{  *; }
-keep interface com.qweather.sdk.TokenGenerator{  *; }
-keep public class com.qweather.sdk.JWTGenerator {
    public *;
}
```

## 3. Add API Host and token

Replace `YOUR_HOST` with your [API Host](http://dev.qweather.com/en/docs/configuration/api-host/)

```java
QWeather.getInstance(MainActivity.this, "{YOUR_HOST}") // Initialize api host
        .setLogEnable(true);   // Enable debug logging (set false for production environments)
```

**Set up the token generator**

> **Hint:** QWeatherSDK only support [JWT](https://dev.qweather.com/en/docs/configuration/authentication/#json-web-token) for authentication.

For security purposes, please ensure proper management of sensitive information such as private key, project ID, and credential ID, avoiding storage or transmission in plaintext.

```java
// Set up the token generator using the JWTGenerator provided by the SDK, which implements the TokenGenerator interface.
JWTGenerator jwt = new JWTGenerator("{YOUR_PRIVATE_KEY}", // Private key
                           "{YOUR_PROJECT_ID}", // Project ID
                           "{YOUR_KID}"); // Credential ID
instance.setTokenGenerator(jwt);

//NOTE: Developers can customize their token generators by implementing the TokenGenerator interface. 
```
