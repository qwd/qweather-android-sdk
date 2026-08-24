[English](../../en/air-quality/air-current.md) | [中文](air-current.md) · [← Back](../../../README-zh.md)

# 实时空气质量

提供全球指定地点的实时空气质量数据，精度为1x1公里，数据包括：

- 基于各个国家或地区当地标准的AQI、AQI等级、颜色和首要污染物
- 和风天气通用AQI
- 污染物浓度值、分指数
- 健康建议

| 接口代码 | 接口 | 数据类 |
| --------------- | ---------------------------- | ------------ |
| airCurrent | 实时空气质量 | [AirV1CurrentResponse](https://dev.qweather.com/docs/api/air-quality/air-current/#response) |

## 参数

**AirV1Parameter**

- `latitude` ***（必选）*** `Double` 所需位置的纬度。十进制，最多支持小数点后两位。例如 `39.92`
- `longitude` ***（必选）*** `Double` 所需位置的经度。十进制，最多支持小数点后两位。例如 `116.41`
- `lang` `Lang` 多语言设置，请阅读[多语言](https://dev.qweather.com/docs/resource/language/)文档，了解我们的多语言是如何工作、如何设置以及数据是否支持多语言。

## 示例代码

```java
AirV1Parameter parameter  = new AirV1Parameter(39.92, 116.41);
instance.airCurrent(parameter, new Callback<AirV1CurrentResponse>() {
    @Override
    public void onSuccess(AirV1CurrentResponse response) {
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

[AirV1CurrentResponse](https://dev.qweather.com/docs/api/air-quality/air-current/#response)
