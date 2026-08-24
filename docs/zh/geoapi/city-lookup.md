[English](../../en/geoapi/city-lookup.md) | [中文](city-lookup.md) · [← Back](../../../README-zh.md)

# 城市搜索

城市搜索提供全球地理位位置、全球城市搜索服务，支持经纬度坐标反查、多语言、模糊搜索等功能。

天气数据是基于地理位置的数据，因此获取天气之前需要先知道具体的位置信息。使用城市搜索，可获取到该城市的基本信息，包括城市的Location ID（你需要这个ID去查询天气），多语言名称、经纬度、时区、海拔、Rank值、归属上级行政区域、所在行政区域等。

另外，城市搜索也可以帮助你在你的APP中实现模糊搜索，用户只需要输入1-2个字即可获得结果。

| 接口代码 | 接口 | 数据类 |
| -------- | ---------------------------- | ------------ |
| geoCityLookup | 城市搜索 | [GeoCityLookupResponse](https://dev.qweather.com/docs/api/geoapi/city-lookup/#response) |

## 参数

**GeoCityLookupParameter**

- `location` ***（必选）*** `String` 需要查询地区的名称，支持文字、以英文逗号分隔的[经度,纬度坐标](https://dev.qweather.com/docs/resource/glossary/#coordinate)（十进制，最多支持小数点后两位）、[LocationID](https://dev.qweather.com/docs/resource/glossary/#locationid)或[Adcode](https://dev.qweather.com/docs/resource/glossary/#adcode)（仅限中国城市）。例如 `location=北京` 或 `location=116.41,39.92`
- `adm` `String` 城市的上级行政区划，可设定只在某个行政区划范围内进行搜索，用于排除重名城市或对结果进行过滤。例如 `adm=beijing`
- `range` `Range` 搜索范围，可设定只在某个国家或地区范围内进行搜索，国家和地区名称需使用[ISO 3166 所定义的国家代码](https://dev.qweather.com/docs/resource/glossary/#iso-3166)。如果不设置此参数，搜索范围将在所有城市。例如 `range=cn`
- `number` `Int` 返回结果的数量，取值范围1-20，默认返回10个结果。
- `lang` `Lang` 多语言设置，请阅读[多语言](https://dev.qweather.com/docs/resource/language/)文档，了解我们的多语言是如何工作、如何设置以及数据是否支持多语言。

## 示例代码

```java
GeoCityLookupParameter parameter = new GeoCityLookupParameter("101120501");
QWeather.instance.geoCityLookup(parameter, new Callback<GeoCityLookupResponse>() {
    @Override
    public void onSuccess(GeoCityLookupResponse response) {
        Log.i(TAG, response.toString());
    }

    @Override
    public void onFailure(ErrorResponse errorResponse) {
        Log.i(TAG, errorResponse.toString());
    }

    @Override
    public void onException(Throwable e) {
        e.printStackTrace();
    }
});
```

## 返回数据

[GeoCityLookupResponse](https://dev.qweather.com/docs/api/geoapi/city-lookup/#response)
