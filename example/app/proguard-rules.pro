# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-dontwarn com.qweather.sdk.**
-keep class com.qweather.sdk.QWeather { public *; }

#---------------------------------Entry--------------------------------
-keep class com.qweather.sdk.parameter.** { public *; }
-keep class com.qweather.sdk.response.** { public *; }
-keep class com.qweather.sdk.basic.* { public *; }

#---------------------------------Other--------------------------------
-keep class com.qweather.sdk.JWTGenerator { public *; }
-keep interface com.qweather.sdk.TokenGenerator { public *; }
-keep interface com.qweather.sdk.Callback { *; }

#---------------------------------Third Part-------------------------------
# EdDSA
-keep class net.i2p.crypto.eddsa.** { *; }

# okhttp
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**

# Gson
-keep class com.google.gson.** { *; }