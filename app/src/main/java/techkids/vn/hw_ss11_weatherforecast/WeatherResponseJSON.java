package techkids.vn.hw_ss11_weatherforecast;

import java.util.List;

/**
 * Created by Admins on 10/20/2017.
 */

public class WeatherResponseJSON {
    private List<WeatherDay> list;

    public List<WeatherDay> getList() {
        return list;
    }

    class WeatherDay {
        private long dt;
        private Temp temp;
        private double pressure;
        private double humidity;
        private List<Weather> weather;

        public long getDt() {
            return dt;
        }

        public double getPressure() {
            return pressure;
        }

        public double getHumidity() {
            return humidity;
        }

        public List<Weather> getWeather() {
            return weather;
        }

        public Temp getTemp() {
            return temp;
        }

        class Temp {
            private double day;

            public double getDay() {
                return day;
            }
        }

        class Weather {
            private String main;

            public String getMain() {
                return main;
            }
        }
    }
}
