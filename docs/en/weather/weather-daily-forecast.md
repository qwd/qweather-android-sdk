[English](weather-daily-forecast.md) | [中文](../../zh/weather/weather-daily-forecast.md) · [← Back](../../../README.md)

# Daily Weather

Returns a daily weather forecast for the specified latitude and longitude for up to 10 days, with 1-kilometer resolution and global coverage.

The response provides daytime [07:00, 19:00) and nighttime [19:00, 07:00 the following day) forecasts, including maximum and minimum temperature, weather condition, maximum wind gust, maximum UV index, precipitation amount and probability, mean sea-level pressure, humidity, wind direction and speed, cloud cover, sunrise and sunset, moonrise and moonset, moon phase, and more.

| Interface code | Interface | Class |
| ------------ | ------------- | ---------------- |
| weatherDaily | Daily Weather | [WeatherForecastDailyResponse](https://dev.qweather.com/en/docs/api/weather/weather-daily-forecast/#response) |

## Parameters

**WeatherDailyParameter**

- `longitude` ***(required)*** `Double` The longitude of the desired location. Decimal format, up to 2 decimal places. For example `116.41`
- `latitude` ***(required)*** `Double` The latitude of the desired location. Decimal format, up to 2 decimal places. For example `39.92`
- `days` `Int` Number of forecast days. Value range: `1 - 10`, default: `7`
- `localTime` `Bool` Whether to return the local time of the queried location. `true` for local time, `false` for UTC time (default).
- `lang` `Lang` Multi-language setting, please see [Language](https://dev.qweather.com/en/docs/resource/language/) to find out how our multi-language works and how to set up.

## Sample code

```java
WeatherDailyParameter parameter = new WeatherDailyParameter(39.92, 115.41)
                .days(7)
                .localTime(true)
                .lang(Lang.ZH_HANS);
instance.weatherForecastDaily(parameter, new Callback<WeatherForecastDailyResponse>() {
    @Override
    public void onSuccess(WeatherForecastDailyResponse response) {
        Log.i(TAG, response.toString());
    }

    @Override
    public void onFailure(ErrorResponse errorResponse) {
        Log.e(TAG,errorResponse.toString());
    }

    @Override
    public void onException(Throwable e) {
        e.printStackTrace();
    }
});
```

## Response

[WeatherForecastDailyResponse](https://dev.qweather.com/en/docs/api/weather/weather-daily-forecast/#response)
