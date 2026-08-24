[English](weather-hourly-forecast.md) | [中文](../../zh/weather/weather-hourly-forecast.md) · [← Back](../../../README.md)

# Hourly Forecast

Returns an hourly weather forecast for the specified latitude and longitude for up to 240 hours, with 1-kilometer resolution and global coverage.

The response includes weather condition, temperature, feels-like temperature, relative humidity, wind direction and speed, wind gust, precipitation amount and probability, mean sea-level pressure, visibility, dew point, cloud cover, UV index, and more.

| Interface code  | Interface         | Class            |
| ------------ | ------------- | ---------------- |
| weatherHourly  |   Hourly Forecast   | [WeatherForecastHourlyResponse](https://dev.qweather.com/en/docs/api/weather/weather-hourly-forecast/#response) |

## Parameters

**WeatherHourlyParameter**

- `longitude` ***(required)*** `Double` The longitude of the desired location. Decimal format, up to 2 decimal places. For example `116.41`
- `latitude` ***(required)*** `Double` The latitude of the desired location. Decimal format, up to 2 decimal places. For example `39.92`
- `hours` `Int` Number of forecast hours. Value range: `[1, 240]`. Default: `24`
- `localTime` `Bool` Whether to return the local time of the queried location. `true` for local time, `false` for UTC time (default).
- `lang` `Lang` Multi-language setting, please see [Language](https://dev.qweather.com/en/docs/resource/language/) to find out how our multi-language works and how to set up.

## Sample code

```java
WeatherHourlyParameter parameter = new WeatherHourlyParameter(48.52, 2.25)
                .hours(12)
                .localTime(true)
                .lang(Lang.ZH_HANS);
instance.weatherForecastHourly(parameter, new Callback<WeatherForecastHourlyResponse>() {
    @Override
    public void onSuccess(WeatherForecastHourlyResponse response) {
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

[WeatherForecastHourlyResponse](https://dev.qweather.com/en/docs/api/weather/weather-hourly-forecast/#response)
