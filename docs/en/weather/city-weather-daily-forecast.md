[English](city-weather-daily-forecast.md) | [中文](../../zh/weather/city-weather-daily-forecast.md) · [← Back](../../../README.md)

# Daily Forecast (City-based)

Get weather daily forecasts for the next 3-30 days for cities around the world.

| Interface code | Interface | Class |
| ------------------------- | ----------------- | ---------------- |
| weather3d | 3-days forecast | [WeatherDailyResponse](https://dev.qweather.com/en/docs/api/weather/weather-daily-forecast-webapi-v7/#response) |
| weather7d | 7-days forecast | [WeatherDailyResponse](https://dev.qweather.com/en/docs/api/weather/weather-daily-forecast-webapi-v7/#response) |
| weather10d | 10-days forecast | [WeatherDailyResponse](https://dev.qweather.com/en/docs/api/weather/weather-daily-forecast-webapi-v7/#response) |
| weather15d | 15-days forecast | [WeatherDailyResponse](https://dev.qweather.com/en/docs/api/weather/weather-daily-forecast-webapi-v7/#response) |
| weather30d | 30-days forecast | [WeatherDailyResponse](https://dev.qweather.com/en/docs/api/weather/weather-daily-forecast-webapi-v7/#response) |

## Parameters

**WeatherParameter**

- `location` ***(required)*** `String` The location to be queried, support [LocationID](https://dev.qweather.com/en/docs/resource/glossary/#locationid) or comma-separated [longitude and latitude](https://dev.qweather.com/en/docs/resource/glossary/#coordinate) (decimal, up to 2 decimal places), LocationID can be obtained by [GeoAPI](https://dev.qweather.com/en/docs/api/geoapi/). Example: `location=101010100` or `location=116.41,39.92`
- `lang` `Lang` Multi-language setting, please see [Language](https://dev.qweather.com/en/docs/resource/language/) to find out how our multi-language works and how to set up.
- `unit` `Unit` Set weather data unit, the available value are `unit=m` for metric(default) and `unit=i` for imperial. See more about [Unit](https://dev.qweather.com/en/docs/resource/unit).

## Sample code

**Swift**

```java
WeatherParameter parameter = new WeatherParameter("101120501");
Callback<WeatherDailyResponse> responseCallback = new Callback<WeatherDailyResponse>() {
    @Override
    public void onSuccess(WeatherDailyResponse response) {
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

/*
* Get 3-days forecast data
*/
instance.weather3d(parameter, responseCallback);

/*
* Get 7-days forecast data
*/
instance.weather7d(parameter, responseCallback);

/*
* Get 10-days forecast data
*/
instance.weather10d(parameter, responseCallback);

/*
* Get 15-days forecast data
*/
instance.weather15d(parameter, responseCallback);

/*
* Get 30-days forecast data
*/
instance.weather30d(parameter, responseCallback);
```

## Response

[WeatherDailyResponse](https://dev.qweather.com/en/docs/api/weather/weather-daily-forecast-webapi-v7/#response)
