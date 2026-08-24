[English](../../en/ocean/tide.md) | [中文](tide.md) · [← Back](../../../README-zh.md)

# 潮汐

未来10天全球潮汐数据，包括满潮、干潮高度和时间，逐小时潮汐数据。

| 接口代码 | 接口 | 数据类 |
| ----------------------- | ---- | ------------------ |
| oceanTide | 潮汐 | [OceanTideResponse](https://dev.qweather.com/docs/api/ocean/tide/#response) |

## 参数

**OceanParameter**

- `location` ***（必选）*** `String` 需要查询的潮汐站点，请填写潮汐站点的[LocationID](https://dev.qweather.com/docs/resource/glossary/#locationid)，LocationID可通过[POI搜索服务](https://dev.qweather.com/docs/api/geoapi/poi-lookup/)获取。例如 `location=P2951`

- `date` ***（必选）*** 选择日期，最多可选择未来10天（包含今天）的数据。日期格式为yyyyMMdd，例如 `date=20200531`

## 示例代码

```java
Calendar calendar = Calendar.getInstance();
calendar.add(Calendar.DAY_OF_MONTH, 7);
Date sevenDaysAgo = calendar.getTime();
// 创建日期格式化对象
SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
// 格式化当前日期
String formattedDate = formatter.format(sevenDaysAgo);
OceanParameter parameter = new OceanParameter("P2236", formattedDate);
instance.oceanTide(parameter, new Callback<OceanTideResponse>() {
    @Override
    public void onSuccess(OceanTideResponse response) {
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

[OceanTideResponse](https://dev.qweather.com/docs/api/ocean/tide/#response)
