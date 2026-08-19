[English](../en/config.md) | [中文](config.md) · [← Back](../../README-zh.md)

# 配置

**支持下列操作系统：**

Android 8.0+, minSDK 26

## 1、创建项目和凭据

请确保已经创建了[项目和凭据](https://dev.qweather.com/docs/configuration/project-and-key/)，并已了解如何使用 [JWT](https://dev.qweather.com/docs/configuration/authentication/#json-web-token) 身份认证。

## 2、安装SDK

下载 SDK: [QWeatherSDK 5.2.3](https://github.com/qwd/qweather-android-sdk/releases/tag/5.2.3) • [更新记录](https://github.com/qwd/qweather-android-sdk/releases)

* 将JAR文件复制到`app/libs/`目录

```bash
YOUR-PROJECT/
├── app/
│   ├── libs/
│   │   └── QWeather_Public_Android_V5.2.3.jar
│   ├── src/
│   └── build.gradle
```

* 修改Gradle配置`app/build.gradle`文件：

```bash
dependencies {
    // 添加以下配置
    implementation files('libs/QWeather_Public_Android_V5.2.3.jar')
    
    // 或者批量添加所有JAR
    implementation fileTree(dir: 'libs', include: ['*.jar'])
}
```

* 引用库

```bash
implementation 'com.squareup.okhttp3:okhttp:4.12.0'
implementation 'com.google.code.gson:gson:2.10.1'
implementation 'net.i2p.crypto:eddsa:0.3.0'
```

* 请在混淆文件`proguard-rules.pro`中加入如下代码

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

## 3、添加 API Host 和 Token

将代码中的`YOUR_HOST`替换为您的 [API Host](https://dev.qweather.com/docs/configuration/api-host)

```java
QWeather.getInstance(MainActivity.this, "{YOUR_HOST}") // 初始化服务地址
        .setLogEnable(true);  // 启用调试日志（生产环境建议设置为 false）
```

**设置Token生成器**

> **提示**：仅支持 [JWT](https://dev.qweather.com/docs/configuration/authentication/#json-web-token) 身份认证。

出于安全考虑，请确保妥善保管私钥、项目ID及凭据ID等敏感信息，避免以明文形式存储或传输。

```java
// 通过SDK提供的JWTGenerator设置令牌生成器，其实现自TokenGenerator接口
JWTGenerator jwt = new JWTGenerator("{YOUR_PRIVATE_KEY}", // 私钥
                           "{YOUR_PROJECT_ID}", // 项目ID
                           "{YOUR_KID}"); // 凭据ID
instance.setTokenGenerator(jwt);

//NOTE: 开发者也可以通过实现TokenGenerator接口创建自己的令牌生成器
```
