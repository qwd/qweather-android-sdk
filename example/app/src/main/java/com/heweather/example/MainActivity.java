package com.heweather.example;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.qweather.sdk.Callback;
import com.qweather.sdk.JWTGenerator;
import com.qweather.sdk.QWeather;
import com.qweather.sdk.basic.Basin;
import com.qweather.sdk.basic.Indices;
import com.qweather.sdk.basic.Lang;
import com.qweather.sdk.basic.Poi;
import com.qweather.sdk.basic.Range;
import com.qweather.sdk.basic.Unit;
import com.qweather.sdk.parameter.air.AirV1Parameter;
import com.qweather.sdk.parameter.alert.WeatherAlertCurrentParameter;
import com.qweather.sdk.parameter.astronomy.AstronomyMoonParameter;
import com.qweather.sdk.parameter.astronomy.AstronomySunParameter;
import com.qweather.sdk.parameter.astronomy.SolarElevationAngleParameter;
import com.qweather.sdk.parameter.geo.GeoCityLookupParameter;
import com.qweather.sdk.parameter.geo.GeoCityTopParameter;
import com.qweather.sdk.parameter.geo.GeoPoiLookupParameter;
import com.qweather.sdk.parameter.geo.GeoPoiRangeParameter;
import com.qweather.sdk.parameter.historical.HistoricalWeatherParameter;
import com.qweather.sdk.parameter.indices.IndicesParameter;
import com.qweather.sdk.parameter.minutely.MinutelyParameter;
import com.qweather.sdk.parameter.ocean.OceanParameter;
import com.qweather.sdk.parameter.tropical.StormListParameter;
import com.qweather.sdk.parameter.tropical.StormParameter;
import com.qweather.sdk.parameter.weather.WeatherCurrentParameter;
import com.qweather.sdk.parameter.weather.WeatherDailyParameter;
import com.qweather.sdk.parameter.weather.WeatherHourlyParameter;
import com.qweather.sdk.parameter.weather.WeatherParameter;
import com.qweather.sdk.response.air.v1.AirV1CurrentResponse;
import com.qweather.sdk.response.air.v1.AirV1DailyResponse;
import com.qweather.sdk.response.air.v1.AirV1HourlyResponse;
import com.qweather.sdk.response.alert.WeatherAlertCurrentResponse;
import com.qweather.sdk.response.astronomy.AstronomyMoonResponse;
import com.qweather.sdk.response.astronomy.AstronomySolarElevationAngleResponse;
import com.qweather.sdk.response.astronomy.AstronomySunResponse;
import com.qweather.sdk.response.error.ErrorResponse;
import com.qweather.sdk.response.geo.GeoCityLookupResponse;
import com.qweather.sdk.response.geo.GeoCityTopResponse;
import com.qweather.sdk.response.geo.GeoPoiResponse;
import com.qweather.sdk.response.historical.HistoricalWeatherResponse;
import com.qweather.sdk.response.indices.IndicesDailyResponse;
import com.qweather.sdk.response.minutely.MinutelyResponse;
import com.qweather.sdk.response.ocean.OceanTideResponse;
import com.qweather.sdk.response.tropical.StormForecastResponse;
import com.qweather.sdk.response.tropical.StormListResponse;
import com.qweather.sdk.response.tropical.StormTrackResponse;
import com.qweather.sdk.response.weather.WeatherCurrentResponse;
import com.qweather.sdk.response.weather.WeatherDailyResponse;
import com.qweather.sdk.response.weather.WeatherForecastDailyResponse;
import com.qweather.sdk.response.weather.WeatherForecastHourlyResponse;
import com.qweather.sdk.response.weather.WeatherHourlyResponse;
import com.qweather.sdk.response.weather.WeatherNowResponse;

import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "QWeatherExampleMainActivity";
    QWeather instance;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            JWTGenerator jwt = new JWTGenerator(
                    "{YOUR_PRIVATE_KEY}",
                    "{YOUR_PROJECT_ID}",
                    "{YOUR_KID}",
                    "{YOUR_DEVELOPER_ID}");
            instance = QWeather.getInstance(MainActivity.this, "{YOUR_HOST}")
                    .setTokenGenerator(jwt)
                    .setLogEnable(true);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        testWeatherNow();

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void testGeoCityTop() {
        GeoCityTopParameter parameter = new GeoCityTopParameter().range(Range.CN);
        instance.geoCityTop(parameter, new Callback<GeoCityTopResponse>() {
            @Override
            public void onSuccess(GeoCityTopResponse response) {
                Log.i(TAG, response.toString());
            }

            @Override
            public void onFailure(ErrorResponse errorResponse) {
                Log.i(TAG, errorResponse.toString());
            }

            @Override
            public void onException(Throwable e) {
                e.printStackTrace();
                Log.e(TAG,e.toString());
            }
        });
    }

    private void testGeoCityLookup() {
        GeoCityLookupParameter parameter = new GeoCityLookupParameter("101120501");
        QWeather.instance.geoCityLookup(parameter, new Callback<GeoCityLookupResponse>() {
            @Override
            public void onSuccess(GeoCityLookupResponse response) {
                Log.i(TAG, response.toString());
            }

            @Override
            public void onFailure(ErrorResponse errorResponse) {
                Log.i(TAG, errorResponse.toString());
            }

            @Override
            public void onException(Throwable e) {
                e.printStackTrace();
            }
        });
    }

    private void testGeoPoiRange() {
        GeoPoiRangeParameter parameter = new GeoPoiRangeParameter("116.41,39.92", Poi.SCENIC)
                .radius(50);
        instance.geoPoiRange(parameter, new Callback<GeoPoiResponse>() {
            @Override
            public void onSuccess(GeoPoiResponse response) {
                Log.i(TAG, response.toString());
            }

            @Override
            public void onFailure(ErrorResponse errorResponse) {
                Log.i(TAG, errorResponse.toString());
            }

            @Override
            public void onException(Throwable e) {
                e.printStackTrace();
            }
        });
    }

    private void testGeoPoiLookup() {
        GeoPoiLookupParameter parameter = new GeoPoiLookupParameter("116.41,39.92", Poi.SCENIC);
        instance.geoPoiLookup(parameter, new Callback<GeoPoiResponse>() {
            @Override
            public void onSuccess(GeoPoiResponse response) {
                Log.i(TAG, response.toString());
            }

            @Override
            public void onFailure(ErrorResponse errorResponse) {
                Log.i(TAG, errorResponse.toString());
            }

            @Override
            public void onException(Throwable e) {
                e.printStackTrace();
            }
        });
    }

    private  void  testWeatherCurrent() {
        WeatherCurrentParameter parameter = new WeatherCurrentParameter(39.92,116.41)
                .localTime(true)
                .lang(Lang.ZH_HANS);
        QWeather.instance.weatherCurrent(parameter, new Callback<WeatherCurrentResponse>() {
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
    }

    private  void  testWeatherDaily() {
        WeatherDailyParameter parameter = new WeatherDailyParameter(39.92, 115.41)
                .days(7)
                .localTime(true)
                .lang(Lang.ZH_HANS);
        QWeather.instance.weatherForecastDaily(parameter, new Callback<WeatherForecastDailyResponse>() {
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
    }

    private  void  testWeatherHourly() {
        WeatherHourlyParameter parameter = new WeatherHourlyParameter(48.52, 2.25)
                .hours(12)
                .localTime(true)
                .lang(Lang.ZH_HANS);
        QWeather.instance.weatherForecastHourly(parameter, new Callback<WeatherForecastHourlyResponse>() {
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
    }

    private void testWeatherNow() {
        WeatherParameter parameter = new WeatherParameter("101120501")
                .lang(Lang.ZH_HANS)
                .unit(Unit.METRIC);
        instance.weatherNow(parameter, new Callback<WeatherNowResponse>() {
            @Override
            public void onSuccess(WeatherNowResponse response) {
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
    }

    private void testWeather3d() {
        WeatherParameter parameter = new WeatherParameter("101120501");
        instance.weather3d(parameter, new Callback<WeatherDailyResponse>() {
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
        });
    }

    private void testWeather7d() {
        try {
            WeatherParameter parameter = new WeatherParameter("101120501");
            instance.weather7d(parameter, new Callback<WeatherDailyResponse>() {
                @Override
                public void onSuccess(WeatherDailyResponse response) {
                    Log.i(TAG, response.toString());
                }

                @Override
                public void onFailure(ErrorResponse errorResponse) {
                    Log.i(TAG, errorResponse.toString());
                }

                @Override
                public void onException(Throwable e) {
                    e.printStackTrace();
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void testWeather10d() {
        WeatherParameter parameter = new WeatherParameter("101120501");
        instance.weather10d(parameter, new Callback<WeatherDailyResponse>() {
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
        });
    }

    private void testWeather15d() {
        WeatherParameter parameter = new WeatherParameter("101120501");
        instance.weather15d(parameter, new Callback<WeatherDailyResponse>() {
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
        });
    }

    private void testWeather30d() {
        WeatherParameter parameter = new WeatherParameter("101120501");
        instance.weather30d(parameter, new Callback<WeatherDailyResponse>() {
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
        });
    }

    private void testWeather24h() {
        WeatherParameter parameter = new WeatherParameter("101120501");
        instance.weather24h(parameter, new Callback<WeatherHourlyResponse>() {
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
        });
    }

    private void testWeather72h() {
        WeatherParameter parameter = new WeatherParameter("101120501");
        instance.weather72h(parameter, new Callback<WeatherHourlyResponse>() {
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
        });
    }

    private void testWeather168h() {
        WeatherParameter parameter = new WeatherParameter("101120501");
        instance.weather168h(parameter, new Callback<WeatherHourlyResponse>() {
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
        });
    }

    private void testMinutely() {
        MinutelyParameter parameter = new MinutelyParameter(116.41, 39.92);
        instance.minutely(parameter, new Callback<MinutelyResponse>() {
            @Override
            public void onSuccess(MinutelyResponse response) {
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
    }

    private void testWeatherAlertCurrent(){
        WeatherAlertCurrentParameter parameter = new WeatherAlertCurrentParameter(39.2,  116.41, true);
        instance.weatherAlertCurrent(parameter, new Callback<WeatherAlertCurrentResponse>() {
            @Override
            public void onSuccess(WeatherAlertCurrentResponse response) {
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
    }

    private void testIndices1d() {
        IndicesParameter parameter = new IndicesParameter("101120501", Indices.CW, Indices.DRSG);
        instance.indices1d(parameter, new Callback<IndicesDailyResponse>() {
            @Override
            public void onSuccess(IndicesDailyResponse response) {
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
    }

    private void testIndices3d() {
        IndicesParameter parameter = new IndicesParameter("101120501", Indices.CW, Indices.UV);
        instance.indices3d(parameter, new Callback<IndicesDailyResponse>() {
            @Override
            public void onSuccess(IndicesDailyResponse response) {
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
    }

    private void testAirV1Current() {
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
    }

    private void testAirV1Daily() {
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
    }

    private void testAirV1Hourly() {
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
    }

    private void testHistoricalWeather() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        Date sevenDaysAgo = calendar.getTime();
        // 创建日期格式化对象
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        // 格式化当前日期
        String formattedDate = formatter.format(sevenDaysAgo);
        HistoricalWeatherParameter parameter = new HistoricalWeatherParameter("101120501",formattedDate);
        instance.historicalWeather(parameter, new Callback<HistoricalWeatherResponse>() {
            @Override
            public void onSuccess(HistoricalWeatherResponse response) {
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

    }

    private void testTropicalStormList() {
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
    }

    private void testTropicalStormForecast() {
        StormParameter parameter = new StormParameter("NP_2426");
        instance.tropicalStormForecast(parameter, new Callback<StormForecastResponse>() {
            @Override
            public void onSuccess(StormForecastResponse response) {
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
    }

    private void testTropicalStormTrack() {
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
    }

    private void testOceanTide() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        Date sevenDaysAgo = calendar.getTime();
        // 创建日期格式化对象
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        // 格式化当前日期
        String formattedDate = formatter.format(sevenDaysAgo);
        OceanParameter parameter = new OceanParameter("P2236", formattedDate);
        instance.oceanTide(parameter, new Callback<OceanTideResponse>() {
            @Override
            public void onSuccess(OceanTideResponse response) {
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
    }

    private void testAstronomySun() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        String formattedDate = formatter.format(new Date());
        AstronomySunParameter parameter = new AstronomySunParameter("101120501",formattedDate);
        instance.astronomySun(parameter, new Callback<AstronomySunResponse>() {
            @Override
            public void onSuccess(AstronomySunResponse response) {
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
    }

    private void testAstronomyMoon() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        String formattedDate = formatter.format(new Date());
        AstronomyMoonParameter parameter = new AstronomyMoonParameter("101120501",formattedDate);
        instance.astronomyMoon(parameter, new Callback<AstronomyMoonResponse>() {
            @Override
            public void onSuccess(AstronomyMoonResponse response) {
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
    }

    private void testAstronomySolarElevationAngle() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyMMdd", Locale.getDefault());
        String date = dateFormat.format(currentDate);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HHmm", Locale.getDefault());
        String time = timeFormat.format(currentDate);
        SolarElevationAngleParameter parameter = new SolarElevationAngleParameter("116.41,39.92",date,time,"0800","43");

        instance.astronomySolarElevationAngle(parameter, new Callback<AstronomySolarElevationAngleResponse>() {
            @Override
            public void onSuccess(AstronomySolarElevationAngleResponse response) {
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
    }

}