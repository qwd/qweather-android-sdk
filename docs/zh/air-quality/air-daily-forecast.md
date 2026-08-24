[English](../../en/air-quality/air-daily-forecast.md) | [中文](air-daily-forecast.md) · [← Back](../../../README-zh.md)

# 空气质量每日预报

空气质量每日预报API提供未来3天的空气质量（AQI）预报、污染物浓度值和健康建议。

| 接口代码 | 接口 | 数据类 |
| --------------- | ---------------------------- | ------------ |
| airDaily | 空气质量每日预报 | [AirV1DailyResponse](https://dev.qweather.com/docs/api/air-quality/air-daily-forecast/#response) |

## 参数

**AirV1Parameter**

- `latitude` ***（必选）*** `Double` 所需位置的纬度。十进制，最多支持小数点后两位。例如 `39.92`
- `longitude` ***（必选）*** `Double` 所需位置的经度。十进制，最多支持小数点后两位。例如 `116.41`
- `lang` `Lang` 多语言设置，请阅读[多语言](https://dev.qweather.com/docs/resource/language/)文档，了解我们的多语言是如何工作、如何设置以及数据是否支持多语言。

## 示例代码

```java
AirV1Parameter parameter  = new AirV1Parameter( 39.92, 116.41);
instance.airDaily(parameter, new Callback<AirV1DailyResponse>() {
    @Override
    public void onSuccess(AirV1DailyResponse response) {
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

[AirV1DailyResponse](https://dev.qweather.com/docs/api/air-quality/air-daily-forecast/#response)
