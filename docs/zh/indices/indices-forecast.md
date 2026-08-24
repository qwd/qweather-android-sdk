[English](../../en/indices/indices-forecast.md) | [中文](indices-forecast.md) · [← Back](../../../README-zh.md)

# 天气指数预报

中国和海外城市天气生活指数预报数据。

- 中国天气生活指数：舒适度指数、洗车指数、穿衣指数、感冒指数、运动指数、旅游指数、紫外线指数、空气污染扩散条件指数、空调开启指数、过敏指数、太阳镜指数、化妆指数、晾晒指数、交通指数、钓鱼指数、防晒指数
- 海外天气生活指数：运动指数、洗车指数、紫外线指数、钓鱼指数

| 接口代码 | 接口 | 数据类 |
| ---------- | ------------ | --------------- |
| indices1d | 当天生活指数 | [IndicesDailyResponse](https://dev.qweather.com/docs/api/indices/indices-forecast/#response) |
| indices3d | 3天生活指数 | [IndicesDailyResponse](https://dev.qweather.com/docs/api/indices/indices-forecast/#response) |

## 参数

**IndicesParameter**

- `location` ***（必选）*** `String` 需要查询地区的[LocationID](https://dev.qweather.com/docs/resource/glossary/#locationid)或以英文逗号分隔的[经度,纬度坐标](https://dev.qweather.com/docs/resource/glossary/#coordinate)（十进制，最多支持小数点后两位），LocationID可通过[GeoAPI](https://dev.qweather.com/docs/api/geoapi/)获取。例如 `location=101010100` 或 `location=116.41,39.92`
- `indices` ***（必选）*** `Indices` 生活指数的类型，包括洗车指数、穿衣指数、钓鱼指数等。可以一次性获取多个类型的生活指数。各项生活指数并非适用于所有城市。具体生活指数的ID和等级参考[天气指数信息](https://dev.qweather.com/docs/resource/indices-info/)。
- `lang` `Lang` 多语言设置，请阅读[多语言](https://dev.qweather.com/docs/resource/language/)文档，了解我们的多语言是如何工作、如何设置以及数据

## 示例代码

```java
IndicesParameter parameter = new IndicesParameter("101120501", Indices.CW, Indices.DRSG);

Callback<IndicesDailyResponse> responseCallback = new Callback<IndicesDailyResponse>() {
    @Override
    public void onSuccess(IndicesDailyResponse response) {
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

// 获取1天生活指数数据
instance.indices1d(parameter, responseCallback);

// 获取3天生活指数数据
instance.indices3d(parameter, responseCallback);
```

## 返回数据

[IndicesDailyResponse](https://dev.qweather.com/docs/api/indices/indices-forecast/#response)

### 生活指数类型和等级

请访问[天气指数信息](https://dev.qweather.com/docs/resource/indices-info/)。
