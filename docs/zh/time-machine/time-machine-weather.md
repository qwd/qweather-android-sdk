[English](../../en/time-machine/time-machine-weather.md) | [中文](time-machine-weather.md) · [← Back](../../../README-zh.md)

# 历史天气

获取最近10天的天气历史再分析数据。

> 例如今天是12月30日，最多可获取12月20日至12月29日的天气历史数据。

> 和风天气额外提供了2000年至今的历史再分析气象数据，通过数据文件的形式发送，如需要长时间的历史气象数据数据，请提供下列信息，发送邮件至<sales@qweather.com>，我们将有专人与你联系:
>
> * 企业名称
> * 联系方式
> * 所需要的城市或坐标
> * 所需要的时间范围

| 接口代码 | 接口 | 数据类 |
| --------------- | ----------- | -------------------------- |
| historicalWeather | 历史天气 | [HistoricalWeatherResponse](https://dev.qweather.com/docs/api/time-machine/time-machine-weather/#response) |

## 参数

**HistoricalWeatherParameter**

* `location` ***（必选）*** `String` 需要查询的地区，仅支持[LocationID](https://dev.qweather.com/docs/resource/glossary/#locationid)，LocationID可通过[GeoAPI](https://dev.qweather.com/docs/api/geoapi/)获取。例如 `location=101010100`
* `date` ***（必选）*** `String` 选择日期，最多可选择最近10天（不包含今天）的数据。日期格式为yyyyMMdd，例如 `date=20200531`
* `lang` `Lang` 多语言设置，请阅读[多语言](https://dev.qweather.com/docs/resource/language/)文档，了解我们的多语言是如何工作、如何设置以及数据是否支持多语言。
* `unit` `Unit` 数据单位设置，可选值包括`unit=m`（公制单位，默认）和`unit=i`（英制单位）。更多选项和说明参考[度量衡单位](https://dev.qweather.com/docs/resource/unit)。

## 示例代码

```java
Calendar calendar = Calendar.getInstance();
calendar.add(Calendar.DAY_OF_MONTH, -7);
Date sevenDaysAgo = calendar.getTime();
// 创建日期格式化对象
SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
// 格式化当前日期
String formattedDate = formatter.format(sevenDaysAgo);
HistoricalWeatherParameter parameter = new HistoricalWeatherParameter("101120501",formattedDate);

instance.historicalWeather(parameter, new Callback<HistoricalWeatherResponse>() {
    @Override
    public void onSuccess(HistoricalWeatherResponse response) {
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

[HistoricalWeatherResponse](https://dev.qweather.com/docs/api/time-machine/time-machine-weather/#response)
