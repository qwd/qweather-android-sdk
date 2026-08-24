[English](air-daily-forecast.md) | [中文](../../zh/air-quality/air-daily-forecast.md) · [← Back](../../../README.md)

# Air quality daily forecast

Get daily AQI forecasts, pollutant concentrations, and health guidance for the next 3 days.


| Interface code | Interface                         | Class       |
| --------------- | ---------------------------- | ------------ |
| airDaily | Air quality daily forecast     | [AirV1DailyResponse](https://dev.qweather.com/en/docs/api/air-quality/air-daily-forecast/#response) |

## Parameters

**AirV1Parameter**

- `latitude` ***(required)*** `Double` The latitude of the desired location. Decimal format, up to 2 decimal places. For example `39.92`

- `longitude` ***(required)*** `Double` The longitude of the desired location. Decimal format, up to 2 decimal places. For example `116.41`

- `lang` `Lang` Multi-language setting, please see [Language](https://dev.qweather.com/en/docs/resource/language/) to find out how our multi-language works and how to set up.

## Sample code

```java
AirV1Parameter parameter  = new AirV1Parameter( 39.92, 116.41);
instance.airDaily(parameter, new Callback<AirV1DailyResponse>() {
    @Override
    public void onSuccess(AirV1DailyResponse response) {
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

[AirV1DailyResponse](https://dev.qweather.com/en/docs/api/air-quality/air-daily-forecast/#response)
