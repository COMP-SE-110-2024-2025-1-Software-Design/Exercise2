package org.example;

import com.google.gson.JsonObject;

public class CryptoPricesHolder {

    private final String coinName;
    private final JsonObject jsonResponse;

    public CryptoPricesHolder(String coinName, JsonObject jsonResponse) {
        this.coinName = coinName;
        this.jsonResponse = jsonResponse;
    }

    public double getPriceForCurrency(String currencyName) {
        if (jsonResponse.has(coinName) && jsonResponse.getAsJsonObject(coinName).has(currencyName)) {
            return jsonResponse.getAsJsonObject(coinName).get(currencyName).getAsDouble();
        } else {
            System.out.println("Price for currency " + currencyName + " not found.");
            return -1;
        }
    }
}
