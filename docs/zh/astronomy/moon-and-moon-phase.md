[English](../../en/astronomy/moon-and-moon-phase.md) | [中文](moon-and-moon-phase.md) · [← Back](../../../README-zh.md)

# 月升月落和月相

获取未来60天全球城市月升月落和逐小时的月相数据。

> 月相已考虑南北半球的差异，不需要再进行转换

| 接口代码 | 接口 | 数据类 |
| --------------------------- | -------------- | ------------- |
| astronomyMoon | 月升月落和月相 | [AstronomyMoonResponse](https://dev.qweather.com/docs/api/astronomy/moon-and-moon-phase/#response) |

## 参数

**AstronomyMoonParameter**

- `location` ***（必选）*** `String` 需要查询地区的[LocationID](https://dev.qweather.com/docs/resource/glossary/#locationid)或以英文逗号分隔的[经度,纬度坐标](https://dev.qweather.com/docs/resource/glossary/#coordinate)（十进制，最多支持小数点后两位），LocationID可通过[GeoAPI](https://dev.qweather.com/docs/api/geoapi/)获取。例如 `location=101010100` 或 `location=116.41,39.92`
- `date` ***（必选）*** `String` 选择日期，最多可选择未来60天（包含今天）的数据。日期格式为yyyyMMdd，例如 `date=20200531`
- `lang` `Lang` 多语言设置，请阅读[多语言](https://dev.qweather.com/docs/resource/language/)文档，了解我们的多语言是如何工作、如何设置以及数据是否支持多语言。

## 示例代码

```java
SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
String formattedDate = formatter.format(new Date());
AstronomyMoonParameter parameter = new AstronomyMoonParameter("101120501",formattedDate);
instance.astronomyMoon(parameter, new Callback<AstronomyMoonResponse>() {
    @Override
    public void onSuccess(AstronomyMoonResponse response) {
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

[AstronomyMoonResponse](https://dev.qweather.com/docs/api/astronomy/moon-and-moon-phase/#response)
