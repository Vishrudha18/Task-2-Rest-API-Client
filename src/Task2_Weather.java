import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Task2_Weather {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter city name: ");
        String city = sc.nextLine();

        String apiKey = "YOUR_API_KEY"; // replace with your API key

        String apiUrl =
                " "
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
                double temperature = main.getDouble("temp");
                int humidity = main.getInt("humidity");

                JSONObject weather =
                        json.getJSONArray("weather").getJSONObject(0);
                String condition = weather.getString("description");

                System.out.println("\n----- Weather Report -----");
                System.out.println("City        : " + cityName);
                System.out.println("Temperature : " + temperature + " °C");
                System.out.println("Humidity    : " + humidity + " %");
                System.out.println("Condition   : " + condition);

            } else {
                System.out.println("City not found or API error");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}

