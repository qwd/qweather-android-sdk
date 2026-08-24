[English](air-hourly-forecast.md) | [中文](../../zh/air-quality/air-hourly-forecast.md) · [← Back](../../../README.md)

# Air quality hourly forecast

Get hourly air quality data for the next 24 hours, including AQI, pollutant concentrations, sub-indexes, and health guidance.

| Interface code | Interface | Class |
| --------------- | ---------------------------- | ------------ |
| airHourly | Air quality hourly forecast | [AirV1HourlyResponse](https://dev.qweather.com/en/docs/api/air-quality/air-hourly-forecast/#response) |

## Parameters

**AirV1Parameter**

- `latitude` ***(required)*** `Double` The latitude of the desired location. Decimal format, up to 2 decimal places. For example `39.92`

- `longitude` ***(required)*** `Double` The longitude of the desired location. Decimal format, up to 2 decimal places. For example `116.41`

- `lang` `Lang` Multi-language setting, please see [Language](https://dev.qweather.com/en/docs/resource/language/) to find out how our multi-language works and how to set up.

## Sample code

```java
AirV1Parameter parameter  = new AirV1Parameter( 39.92, 116.41);
instance.airHourly(parameter, new Callback<AirV1HourlyResponse>() {
    @Override
    public void onSuccess(AirV1HourlyResponse response) {
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

[AirV1HourlyResponse](https://dev.qweather.com/en/docs/api/air-quality/air-hourly-forecast/#response)
