[English](../../en/tropical-cyclone/storm-track.md) | [中文](storm-track.md) · [← Back](../../../README-zh.md)

# 台风实况和路径

台风实况和路径提供全球主要海洋流域的台风实时位置、等级、气压、风力、速度以及活跃台风的轨迹路径。

| 接口代码 | 接口 | 数据类 |
| ---------------- | -------------- | ------------------- |
| tropicalStormTrack | 台风实况和路径 | [StormTrackResponse](https://dev.qweather.com/docs/api/tropical-cyclone/storm-track/#response) |

## 参数

**StormParameter**

- `stormid` ***（必选）*** `String` 需要查询的台风ID，StormID可通过[台风列表](#storm-list)获取。例如 `stormid=NP2018`

## 示例代码

```java
StormParameter parameter = new StormParameter("NP_2421");
instance.tropicalStormTrack(parameter, new Callback<StormTrackResponse>() {
    @Override
    public void onSuccess(StormTrackResponse response) {
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

[StormTrackResponse](https://dev.qweather.com/docs/api/tropical-cyclone/storm-track/#response)

[台风等级](https://dev.qweather.com/docs/api/tropical-cyclone/storm-track/#%E5%8F%B0%E9%A3%8E%E7%AD%89%E7%BA%A7)
