package techkids.vn.hw_ss11_weatherforecast;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Admins on 10/20/2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    List<WeatherModel> weatherModels;

    public WeatherAdapter(List<WeatherModel> weatherModels) {
        this.weatherModels = weatherModels;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_list_weather, parent, false);

        return new WeatherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        holder.setData(weatherModels.get(position));
    }

    @Override
    public int getItemCount() {
        return weatherModels.size();
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView tvMain;
        TextView tvDate;
        TextView tvHum;
        TextView tvPress;
        TextView tvTemp;

        public WeatherViewHolder(View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tv_date);
            tvMain = itemView.findViewById(R.id.tv_main);
            tvHum = itemView.findViewById(R.id.tv_humidity);
            tvPress = itemView.findViewById(R.id.tv_pressure);
            tvTemp = itemView.findViewById(R.id.tv_tempDay);
        }

        public void setData(WeatherModel weatherModel) {
            tvDate.setText(weatherModel.getDate());
            tvHum.setText("Humidity (%): " + String.valueOf(weatherModel.getHumidity()));
            tvPress.setText("Pressure (hPa): " + String.valueOf(weatherModel.getPressure()));

            double tempDay = weatherModel.getTempDay();
            DecimalFormat formatter = new DecimalFormat("#0.0");
            tvTemp.setText(String.valueOf(formatter.format(tempDay - 273)));
            tvMain.setText(weatherModel.getMain());
        }
    }
}
