[English](../../en/warning/weather-alert.md) | [中文](weather-alert.md) · [← Back](../../../README-zh.md)

# 实时天气预警

根据指定的经纬度坐标，查询中国和全球正在生效的官方天气预警信息。阅读[实用资料-预警](https://dev.qweather.com/docs/resource/warning-info/)以了解预警信息支持的国家和地区、事件类型等必要信息。

| 接口代码 | 接口 | 数据类 |
| -------------------- | -------- | ---------------- |
| weatherAlertCurrent | 实时天气预警 | [WeatherAlertCurrentResponse](https://dev.qweather.com/docs/api/warning/weather-alert/#response) |

## 参数

**WeatherAlertCurrentParameter**

- `latitude` ***（必选）*** `Double` 所需位置的纬度。十进制，最多支持小数点后两位。例如 `39.92`
- `longitude` ***（必选）*** `Double` 所需位置的经度。十进制，最多支持小数点后两位。例如 `116.41`
- `localTime` `Bool` 是否返回查询地点的本地时间。`true` 返回本地时间，`false` 返回UTC时间（默认）。
- `lang` `Lang` 多语言设置，请阅读[多语言](https://dev.qweather.com/docs/resource/language/)文档，了解我们的多语言是如何工作、如何设置以及数据是否支持多语言。

## 示例代码

```java
WeatherAlertCurrentParameter parameter = new WeatherAlertCurrentParameter(39.2,  116.41, true);
instance.weatherAlertCurrent(parameter, new Callback<WeatherAlertCurrentResponse>() {
    @Override
    public void onSuccess(WeatherAlertCurrentResponse response) {
        Log.i(TAG, response.toString());
    }

    @Override
    public void onFailure(ErrorResponse errorResponse) {
        Log.i(TAG,errorResponse.toString());
    }

    @Override
    public void onException(Throwable e) {
        e.printStackTrace();
    }
});
```

## 返回数据

[WeatherAlertCurrentResponse](https://dev.qweather.com/docs/api/warning/weather-alert/#response)
