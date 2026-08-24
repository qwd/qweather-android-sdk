[English](../../en/air-quality/air-hourly-forecast.md) | [中文](air-hourly-forecast.md) · [← Back](../../../README-zh.md)

# 空气质量小时预报

空气质量小时预报API提供未来24小时空气质量的数据，包括AQI、污染物浓度、分指数以及健康建议。

| 接口代码 | 接口 | 数据类 |
| --------------- | ---------------------------- | ------------ |
| airHourly | 空气质量小时预报 | [AirV1HourlyResponse](https://dev.qweather.com/docs/api/air-quality/air-hourly-forecast/#response) |

## 参数

**AirV1Parameter**

- `latitude` ***（必选）*** `Double` 所需位置的纬度。十进制，最多支持小数点后两位。例如 `39.92`
- `longitude` ***（必选）*** `Double` 所需位置的经度。十进制，最多支持小数点后两位。例如 `116.41`
- `lang` `Lang` 多语言设置，请阅读[多语言](https://dev.qweather.com/docs/resource/language/)文档，了解我们的多语言是如何工作、如何设置以及数据是否支持多语言。

## 示例代码

```java
AirV1Parameter parameter  = new AirV1Parameter( 39.92, 116.41);
instance.airHourly(parameter, new Callback<AirV1HourlyResponse>() {
    @Override
    public void onSuccess(AirV1HourlyResponse response) {
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

[AirV1HourlyResponse](https://dev.qweather.com/docs/api/air-quality/air-hourly-forecast/#response)
