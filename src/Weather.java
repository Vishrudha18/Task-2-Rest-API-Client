import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Weather {

    public static void main(String[] args) {

        String apiKey = "f72ace1f6a05ba938044edf7f8f45a53";   // replace with your API key
        String city = "Coimbatore";

        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q="
                        + city + "&appid=" + apiKey + "&units=metric";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();

            if (responseCode == 200) {

                BufferedReader br =
                        new BufferedReader(new InputStreamReader(con.getInputStream()));

                String line;
                StringBuilder response = new StringBuilder();

                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                br.close();

                JSONObject json = new JSONObject(response.toString());

                String cityName = json.getString("name");
                JSONObject main = json.getJSONObject("main");
                double temp = main.getDouble("temp");
                int humidity = main.getInt("humidity");

                JSONObject weather = json.getJSONArray("weather").getJSONObject(0);
                String description = weather.getString("description");

                System.out.println("----- Weather Report -----");
                System.out.println("City        : " + cityName);
                System.out.println("Temperature : " + temp + " °C");
                System.out.println("Humidity    : " + humidity + " %");
                System.out.println("Condition   : " + description);

            } else {
                System.out.println("HTTP Error : " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

