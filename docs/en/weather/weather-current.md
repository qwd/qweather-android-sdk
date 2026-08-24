[English](weather-current.md) | [中文](../../zh/weather/weather-current.md) · [← Back](../../../README.md)

# Current Weather

Returns current weather data for the specified latitude and longitude, with 1-kilometer resolution, global coverage, and minute-level updates.

The response includes weather condition, temperature, feels-like temperature, relative humidity, wind direction and speed, wind gust, precipitation amount, mean sea-level pressure, visibility, dew point, cloud cover, UV index, and more.

| Interface code  | Interface         | Class            |
| ------------ | ------------- | ---------------- |
| weatherCurrent  | Current Weather     | [WeatherCurrentResponse](https://dev.qweather.com/en/docs/api/weather/weather-current/#response) |

## Parameters

**WeatherCurrentParameter**

- `longitude` ***(required)*** `Double` The longitude of the desired location. Decimal format, up to 2 decimal places. For example `116.41`
- `latitude` ***(required)*** `Double` The latitude of the desired location. Decimal format, up to 2 decimal places. For example `39.92`
- `localTime` `Bool` Whether to return the local time of the queried location. `true` for local time, `false` for UTC time (default).
- `lang` `Lang` Multi-language setting, please see [Language](https://dev.qweather.com/en/docs/resource/language/) to find out how our multi-language works and how to set up.

## Sample code

```java
WeatherCurrentParameter parameter = new WeatherCurrentParameter(39.92,116.41)
                .localTime(true)
                .lang(Lang.ZH_HANS);
instance.weatherCurrent(parameter, new Callback<WeatherCurrentResponse>() {
    @Override
    public void onSuccess(WeatherCurrentResponse response) {
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

## Response

[WeatherCurrentResponse](https://dev.qweather.com/en/docs/api/weather/weather-current/#response)
