[English](../../en/geoapi/poi-lookup.md) | [中文](poi-lookup.md) · [← Back](../../../README-zh.md)

# POI搜索

使用关键字和坐标查询POI信息（景点、火车站、飞机场、港口等）

| 接口代码 | 接口 | 数据类 |
| ----------- | ------------------ | ------------ |
| geoPoiLookup | POI搜索 | [GeoPoiResponse](https://dev.qweather.com/docs/api/geoapi/poi-lookup/#response) |

## 参数

**GeoPoiLookupParameter**

- `location` ***（必选）*** `String` 需要查询地区的名称，支持文字、以英文逗号分隔的[经度,纬度坐标](https://dev.qweather.com/docs/resource/glossary/#coordinate)（十进制，最多支持小数点后两位）、[LocationID](https://dev.qweather.com/docs/resource/glossary/#locationid)或[Adcode](https://dev.qweather.com/docs/resource/glossary/#adcode)（仅限中国城市）。例如 `location=北京` 或 `location=116.41,39.92`
- `type` ***（必选）*** `Poi` POI类型，可选择搜索某一类型的POI。
  - `scenic` 景点
  - `TSTA` 潮汐站点
- `city` `String` 选择POI所在城市，可设定只搜索在特定城市内的POI信息。城市名称可以是文字或城市的LocationID。**默认不限制特定城市**。  
   > 城市名称为精准匹配，建议使用LocaitonID，如文字无法匹配，则数据返回为空。
- `number` `Int` 返回结果的数量，取值范围1-20，默认返回10个结果。
- `lang` `Lang` 多语言设置，请阅读[多语言](https://dev.qweather.com/docs/resource/language/)文档，了解我们的多语言是如何工作、如何设置以及数据是否支持多语言。

## 示例代码

```java
GeoPoiLookupParameter parameter = new GeoPoiLookupParameter("116.41,39.92", Poi.SCENIC);
instance.geoPoiLookup(parameter, new Callback<GeoPoiResponse>() {
    @Override
    public void onSuccess(GeoPoiResponse response) {
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

[GeoPoiResponse](https://dev.qweather.com/docs/api/geoapi/poi-lookup/#response)
