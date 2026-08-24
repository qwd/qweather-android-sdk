[English](../../en/tropical-cyclone/storm-list.md) | [中文](storm-list.md) · [← Back](../../../README-zh.md)

# 台风列表

台风列表提供全球主要海洋流域最近2年的台风列表。

> 目前仅支持中国沿海地区，即`basin=NP`

| 接口代码 | 接口 | 数据类 |
| ------------------- | -------- | ---------------- |
| tropicalStormList | 台风列表 | [StormListResponse](https://dev.qweather.com/docs/api/tropical-cyclone/storm-list/#response) |

## 参数

**StormListParameter**

- `basin` ***（必选）*** `Basin` 需要查询的台风所在的流域，例如中国处于西北太平洋，即 `basin=NP`。当前仅支持`NP`。
  - `AL` North Atlantic 北大西洋
  - `EP` Eastern Pacific 东太平洋
  - `NP` NorthWest Pacific 西北太平洋
  - `SP` SouthWestern Pacific 西南太平洋
  - `NI` North Indian 北印度洋
  - `SI` South Indian 南印度洋

- `year` ***（必选）*** `String` 支持查询本年度和上一年度的台风，例如：`year=2020`, `year=2019`

## 示例代码

```java
StormListParameter parameter = new StormListParameter(Basin.NP,2024);
instance.tropicalStormList(parameter, new Callback<StormListResponse>() {
    @Override
    public void onSuccess(StormListResponse response) {
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

[StormListResponse](https://dev.qweather.com/docs/api/tropical-cyclone/storm-list/#response)
