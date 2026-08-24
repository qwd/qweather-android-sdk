[English](air-current.md) | [中文](../../zh/air-quality/air-current.md) · [← Back](../../../README.md)

# Current Air Quality

The Current Air Quality API provides real-time air quality data worldwide for a specified location at 1-kilometer resolution, including:

- AQI, category, color and primary pollutant based on local standards for each country or region
- Generic QWeather AQI
- Pollutant concentrations and sub-indexes
- Health guidance

| Interface code | Interface | Class |
| --------------- | ---------------- | ------------ |
| airCurrent | Current Air Quality | [AirV1CurrentResponse](https://dev.qweather.com/en/docs/api/air-quality/air-current/#response) |

## Parameters

**AirV1Parameter**

- `latitude` ***(required)*** `Double` The latitude of the desired location. Decimal format, up to 2 decimal places. For example `39.92`

- `longitude` ***(required)*** `Double` The longitude of the desired location. Decimal format, up to 2 decimal places. For example `116.41`

- `lang` `Lang` Multi-language setting, please see [Language](https://dev.qweather.com/en/docs/resource/language/) to find out how our multi-language works and how to set up.

## Sample code

```java
AirV1Parameter parameter  = new AirV1Parameter(39.92, 116.41);
instance.airCurrent(parameter, new Callback<AirV1CurrentResponse>() {
    @Override
    public void onSuccess(AirV1CurrentResponse response) {
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

[AirV1CurrentResponse](https://dev.qweather.com/en/docs/api/air-quality/air-current/#response)
