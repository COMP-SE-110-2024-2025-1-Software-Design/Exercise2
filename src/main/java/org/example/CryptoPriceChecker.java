package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CryptoPriceChecker {

    private String coinName;
    private static final String API_URL = "https://api.coingecko.com/api/v3/simple/price";


    public CryptoPriceChecker(String coinName) {
        this.coinName = coinName;
    }

    public CryptoPricesHolder getCryptoPrice(List<String> currencies) {
        try {
            String currencyQuery = String.join(",", currencies);

            String apiUrl = API_URL + "?ids=" + coinName + "&vs_currencies=" + currencyQuery;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();

                return new CryptoPricesHolder(coinName, jsonResponse);
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
