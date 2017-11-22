package techkids.vn.hw_ss11_weatherforecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Admins on 10/20/2017.
 */

public interface GetWeatherForecast {
    @GET(Constant.GET_WEATHER_FORECAST)
    Call<WeatherResponseJSON> getWeather(@Query("q") String city, @Query("appid") String appID);
}
