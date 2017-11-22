package techkids.vn.hw_ss11_weatherforecast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private List<WeatherModel> weatherModels = new ArrayList<>();
    private WeatherAdapter weatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
        loadData();
    }

    private void loadData() {
        GetWeatherForecast getWeatherForecast = RetrofitFactory.getRetrofitInstance().create(GetWeatherForecast.class);
        getWeatherForecast.getWeather("hanoi", Constant.APP_ID).enqueue(new Callback<WeatherResponseJSON>() {
            @Override
            public void onResponse(Call<WeatherResponseJSON> call, Response<WeatherResponseJSON> response) {
                List<WeatherResponseJSON.WeatherDay> weatherDayList = response.body().getList();
                for (WeatherResponseJSON.WeatherDay weatherDay : weatherDayList) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM");
                    String date = simpleDateFormat.format(weatherDay.getDt() * 1000);

                    double pressure = weatherDay.getPressure();
                    double humidity = weatherDay.getHumidity();

                    double tempDay = weatherDay.getTemp().getDay();
                    String main = weatherDay.getWeather().get(0).getMain();

                    WeatherModel weatherModel = new WeatherModel(date, pressure, humidity, tempDay, main);
                    weatherModels.add(weatherModel);
                }
                weatherAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<WeatherResponseJSON> call, Throwable t) {

            }
        });
    }

    private void setupUI() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_weather);
        weatherAdapter = new WeatherAdapter(weatherModels);
        recyclerView.setAdapter(weatherAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
