[English](../../en/astronomy/solar-elevation-angle.md) | [中文](solar-elevation-angle.md) · [← Back](../../../README-zh.md)

# 太阳高度角

任意时间点的全球太阳高度及方位角。

| 接口代码 | 接口 | 数据类 |
| -------------------------------- | ---------- | ----------------- |
| astronomySolarElevationAngle | 太阳高度角 | [AstronomySolarElevationAngleResponse](https://dev.qweather.com/docs/api/astronomy/solar-elevation-angle/#response) |

## 参数

**SolarElevationAngleParameter**

- `location` ***（必选）*** `String` 需要查询地区的以英文逗号分隔的[经度,纬度坐标](https://dev.qweather.com/docs/resource/glossary/#coordinate)（十进制，最多支持小数点后两位）。例如 `location=116.41,39.92`
- `date` ***（必选）*** `String` 查询日期，格式为yyyyMMdd，例如 `date=20170809`
- `time` ***（必选）*** `String` 查询时间，格式为HHmm，24时制，例如 `time=1230`
- `tz` ***（必选）*** `String` 查询地区所在时区，例如`tz=0800`或`tz=-0530`
- `alt` ***（必选）*** `Int` 海拔高度，单位为米，例如`alt=43`

## 示例代码

```java
Date currentDate = new Date();
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyMMdd", Locale.getDefault());
String date = dateFormat.format(currentDate);

SimpleDateFormat timeFormat = new SimpleDateFormat("HHmm", Locale.getDefault());
String time = timeFormat.format(currentDate);
SolarElevationAngleParameter parameter = new SolarElevationAngleParameter("116.41,39.92",date,time,"0800","43");

instance.astronomySolarElevationAngle(parameter, new Callback<AstronomySolarElevationAngleResponse>() {
    @Override
    public void onSuccess(AstronomySolarElevationAngleResponse response) {
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

[AstronomySolarElevationAngleResponse](https://dev.qweather.com/docs/api/astronomy/solar-elevation-angle/#response)
