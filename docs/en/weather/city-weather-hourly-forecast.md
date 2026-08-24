[English](city-weather-hourly-forecast.md) | [中文](../../zh/weather/city-weather-hourly-forecast.md) · [← Back](../../../README.md)

# Hourly Forecast (City-based)

Get hourly weather forecasts for cities around the world for the next 24-168 hours.

| Interface code  | Interface         | Class            |
| --------------- | ----------------- | ---------------- |
| weather24h  | 24-hours forecast  | [WeatherHourlyResponse](https://dev.qweather.com/en/docs/api/weather/weather-hourly-forecast-webapi-v7/#response) |
| weather72h  | 72-hours forecast  | [WeatherHourlyResponse](https://dev.qweather.com/en/docs/api/weather/weather-hourly-forecast-webapi-v7/#response)  |
| weather168h | 168-hours forecast | [WeatherHourlyResponse](https://dev.qweather.com/en/docs/api/weather/weather-hourly-forecast-webapi-v7/#response)  |

## Parameters

**WeatherParameter**

- `location` ***(required)*** `String` The location to be queried, support [LocationID](https://dev.qweather.com/en/docs/resource/glossary/#locationid) or comma-separated [longitude and latitude](https://dev.qweather.com/en/docs/resource/glossary/#coordinate) (decimal, up to 2 decimal places), LocationID can be obtained by [GeoAPI](https://dev.qweather.com/en/docs/api/geoapi/). Example: `location=101010100` or `location=116.41,39.92`
- `lang` `Lang` Multi-language setting, please see [Language](https://dev.qweather.com/en/docs/resource/language/) to find out how our multi-language works and how to set up.
- `unit` `Unit` Set weather data unit, the available value are `unit=m` for metric(default) and `unit=i` for imperial. See more about [Unit](https://dev.qweather.com/en/docs/resource/unit).

## Sample code

```java
WeatherParameter parameter = new WeatherParameter("101120501");
Callback<WeatherHourlyResponse> responseCallback = new Callback<WeatherHourlyResponse>() {
    @Override
    public void onSuccess(WeatherHourlyResponse response) {
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
}

/*
* 24-hours forecast
*/
instance.weather24h(parameter, responseCallback);

/*
* 72-hours forecast
*/
instance.weather72h(parameter, responseCallback);

/*
* 168-hours forecast
*/
instance.weather168h(parameter, responseCallback);
```

## Response

[WeatherHourlyResponse](https://dev.qweather.com/en/docs/api/weather/weather-hourly-forecast-webapi-v7/#response)
