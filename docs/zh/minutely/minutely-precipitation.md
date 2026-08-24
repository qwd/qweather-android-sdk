[English](../../en/minutely/minutely-precipitation.md) | [中文](minutely-precipitation.md) · [← Back](../../../README-zh.md)

# 分钟级降水

分钟级降水提供中国地区未来2小时内每5分钟降水数据、降水类型以及未来2小时的降水概况信息。
> 仅限中国地区。

| 接口代码 | 接口 | 数据类 |
| --------- | -------------- | ----------------- |
| minutely | 分钟级降水 | [MinutelyResponse](https://dev.qweather.com/docs/api/minutely/minutely-precipitation/#response) |

## 参数

**MinutelyParameter**

- `latitude` ***（必选）*** `Double` 所需位置的纬度。十进制，最多支持小数点后两位。例如 `39.92`
- `longitude` ***（必选）*** `Double` 所需位置的经度。十进制，最多支持小数点后两位。例如 `116.41`
- `lang` `Lang` 多语言设置，请阅读[多语言](https://dev.qweather.com/docs/resource/language/)文档，了解我们的多语言是如何工作、如何设置以及数据

## 示例代码

```java
MinutelyParameter parameter = new MinutelyParameter(116.41, 39.92);
instance.minutely(parameter, new Callback<MinutelyResponse>() {
    @Override
    public void onSuccess(MinutelyResponse response) {
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

[MinutelyResponse](https://dev.qweather.com/docs/api/minutely/minutely-precipitation/#response)
