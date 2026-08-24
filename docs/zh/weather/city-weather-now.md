[English](../../en/weather/city-weather-now.md) | [中文](city-weather-now.md) · [← Back](../../../README-zh.md)

# 城市实时天气

获取中国3000+市县区和海外20万个城市实时天气数据，包括实时温度、体感温度、风力风向、相对湿度、大气压强、降水量、能见度、露点温度、云量等。

> **注意**：实况数据均为近实时数据，相比真实的物理世界有5-20分钟的延迟，请根据实况数据中的 `obsTime` 确定数据对应的准确时间。

| 接口代码 | 接口 | 数据类 |
| ------------ | ------------- | ---------------- |
| weatherNow | 城市实时天气 | [WeatherNowResponse](https://dev.qweather.com/docs/api/weather/weather-now-webapi-v7/#response) |

## 参数

**WeatherParameter**

- `location` ***（必选）*** `String` 需要查询地区的[LocationID](https://dev.qweather.com/docs/resource/glossary/#locationid)或以英文逗号分隔的[经度,纬度坐标](https://dev.qweather.com/docs/resource/glossary/#coordinate)（十进制，最多支持小数点后两位），LocationID可通过[GeoAPI](https://dev.qweather.com/docs/api/geoapi/)获取。例如 `location=101010100` 或 `location=116.41,39.92`
- `lang` `Lang` 多语言设置，请阅读[多语言](https://dev.qweather.com/docs/resource/language/)文档，了解我们的多语言是如何工作、如何设置以及数据是否支持多语言。
- `unit` `Unit` 数据单位设置，可选值包括`unit=m`（公制单位，默认）和`unit=i`（英制单位）。更多选项和说明参考[度量衡单位](https://dev.qweather.com/docs/resource/unit)。

## 示例代码

```java
WeatherParameter parameter = new WeatherParameter("101120501")
                .lang(Lang.ZH_HANS)
                .unit(Unit.METRIC);
instance.weatherNow(parameter, new Callback<WeatherNowResponse>() {
    @Override
    public void onSuccess(WeatherNowResponse response) {
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

[WeatherNowResponse](https://dev.qweather.com/docs/api/weather/weather-now-webapi-v7/#response)
