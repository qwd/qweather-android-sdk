[English](../../en/astronomy/sunrise-sunset.md) | [中文](sunrise-sunset.md) · [← Back](../../../README-zh.md)

# 日出日落

获取未来60天全球任意地点日出日落时间。

> 在[逐天预报API](../weather/weather-daily-forecast.md)中，也会返回对应天数的日出日落、月升月落和月相数据

| 接口代码 | 接口 | 数据类 |
| -------------------------- | -------- | ------------ |
| astronomySun | 日出日落 | [AstronomySunResponse](https://dev.qweather.com/docs/api/astronomy/sunrise-sunset/#response) |

## 参数

**AstronomySunParameter**

- `location` ***（必选）*** `String` 需要查询地区的[LocationID](https://dev.qweather.com/docs/resource/glossary/#locationid)或以英文逗号分隔的[经度,纬度坐标](https://dev.qweather.com/docs/resource/glossary/#coordinate)（十进制，最多支持小数点后两位），LocationID可通过[GeoAPI](https://dev.qweather.com/docs/api/geoapi/)获取。例如 `location=101010100` 或 `location=116.41,39.92`

- `date` ***（必选）*** `String` 选择日期，最多可选择未来60天（包含今天）的数据。日期格式为yyyyMMdd，例如 `date=20200531`

## 示例代码

```java
SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
String formattedDate = formatter.format(new Date());
AstronomySunParameter parameter = new AstronomySunParameter("101120501",formattedDate);
instance.astronomySun(parameter, new Callback<AstronomySunResponse>() {
    @Override
    public void onSuccess(AstronomySunResponse response) {
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

[AstronomySunResponse](https://dev.qweather.com/docs/api/astronomy/sunrise-sunset/#response)
