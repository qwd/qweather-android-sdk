[English](../../en/weather/city-weather-daily-forecast.md) | [中文](city-weather-daily-forecast.md) · [← Back](../../../README-zh.md)

# 城市每日预报

每日天气预报iOS SDK，提供全球城市未来3-30天天气预报，包括：日出日落、月升月落、最高最低温度、天气白天和夜间状况、风力、风速、风向、相对湿度、大气压强、降水量、露点温度、紫外线强度、能见度等。

| 接口代码 | 接口 | 数据类 |
| ----------- | ------------ | -------------------- |
| weather3d | 城市3天预报 | [WeatherDailyResponse](https://dev.qweather.com/docs/api/weather/weather-daily-forecast-webapi-v7/#response) |
| weather7d | 城市7天预报 | [WeatherDailyResponse](https://dev.qweather.com/docs/api/weather/weather-daily-forecast-webapi-v7/#response) |
| weather10d | 城市10天预报 | [WeatherDailyResponse](https://dev.qweather.com/docs/api/weather/weather-daily-forecast-webapi-v7/#response) |
| weather15d | 城市15天预报 | [WeatherDailyResponse](https://dev.qweather.com/docs/api/weather/weather-daily-forecast-webapi-v7/#response) |
| weather30d | 城市30天预报 | [WeatherDailyResponse](https://dev.qweather.com/docs/api/weather/weather-daily-forecast-webapi-v7/#response) |

## 参数

**WeatherParameter**

- `location` ***（必选）*** `String` 需要查询地区的[LocationID](https://dev.qweather.com/docs/resource/glossary/#locationid)或以英文逗号分隔的[经度,纬度坐标](https://dev.qweather.com/docs/resource/glossary/#coordinate)（十进制，最多支持小数点后两位），LocationID可通过[GeoAPI](https://dev.qweather.com/docs/api/geoapi/)获取。例如 `location=101010100` 或 `location=116.41,39.92`
- `lang` `Lang` 多语言设置，请阅读[多语言](https://dev.qweather.com/docs/resource/language/)文档，了解我们的多语言是如何工作、如何设置以及数据是否支持多语言。
- `unit` `Unit` 数据单位设置，可选值包括`unit=m`（公制单位，默认）和`unit=i`（英制单位）。更多选项和说明参考[度量衡单位](https://dev.qweather.com/docs/resource/unit)。

## 示例代码

**Swift**

```java
WeatherParameter parameter = new WeatherParameter("101120501");
Callback<WeatherDailyResponse> responseCallback = new Callback<WeatherDailyResponse>() {
            @Override
            public void onSuccess(WeatherDailyResponse response) {
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
        };

/*
* 获取3天预报数据
*/
instance.weather3d(parameter, responseCallback);

/*
* 获取7天预报数据
*/
instance.weather7d(parameter, responseCallback);

/*
* 获取10天预报数据
*/
instance.weather10d(parameter, responseCallback);

/*
* 获取15天预报数据
*/
instance.weather15d(parameter, responseCallback);

/*
* 获取30天预报数据
*/
instance.weather30d(parameter, responseCallback);
```

## 返回数据

[WeatherDailyResponse](https://dev.qweather.com/docs/api/weather/weather-daily-forecast-webapi-v7/#response)
