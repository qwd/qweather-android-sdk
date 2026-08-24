[English](../../en/geoapi/poi-range.md) | [中文](poi-range.md) · [← Back](../../../README-zh.md)

# POI范围搜索

提供指定区域范围内查询所有POI信息。

| 接口代码 | 接口 | 数据类 |
| ----------- | -------------------------- | ------------ |
| geoPoiRange | POI范围搜索 | [GeoPoiResponse](https://dev.qweather.com/docs/api/geoapi/poi-range/#response) |

## 参数

**GeoPoiRangeParameter**

- `location` ***（必选）*** `String` 需要查询地区的以英文逗号分隔的[经度,纬度坐标](https://dev.qweather.com/docs/resource/glossary/#coordinate)（十进制，最多支持小数点后两位）。例如 `location=116.41,39.92`
- `type` ***（必选）*** `Poi` POI类型，可选择搜索某一类型的POI。
  - `scenic` 景点
  - `TSTA` 潮汐站点
- `radius` `Int` 搜索范围，可设置搜索半径，取值范围1-50，单位：公里。**默认5公里**。
- `number` `Int` 返回结果的数量，取值范围1-20，默认返回10个结果。
- `lang` `Lang` 多语言设置，请阅读[多语言](https://dev.qweather.com/docs/resource/language/)文档，了解我们的多语言是如何工作、如何设置以及数据是否支持多语言。

## 示例代码

```java
GeoPoiRangeParameter parameter = new GeoPoiRangeParameter("116.41,39.92", Poi.SCENIC)
                .radius(50);
instance.geoPoiRange(parameter, new Callback<GeoPoiResponse>() {
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

[GeoPoiResponse](https://dev.qweather.com/docs/api/geoapi/poi-range/#response)
