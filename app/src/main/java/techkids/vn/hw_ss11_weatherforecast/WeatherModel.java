package techkids.vn.hw_ss11_weatherforecast;

import java.util.Date;

/**
 * Created by Admins on 10/20/2017.
 */

public class WeatherModel {
    private String date;
    private double pressure;
    private double humidity;
    private double tempDay;
    private String main;

    public WeatherModel(String date, double pressure, double humidity, double tempDay, String main) {
        this.date = date;
        this.pressure = pressure;
        this.humidity = humidity;
        this.tempDay = tempDay;
        this.main = main;
    }

    public String getDate() {
        return date;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getTempDay() {
        return tempDay;
    }

    public String getMain() {
        return main;
    }
}
