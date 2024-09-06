package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        CryptoPriceChecker checker = new CryptoPriceChecker("ethereum");

        CryptoPricesHolder holder = checker.getCryptoPrice(Arrays.asList("eur", "sek", "usd"));

        System.out.println("Ethereum");;
        System.out.println("\teur: " + holder.getPriceForCurrency("eur"));;
        System.out.println("\tsek: " + holder.getPriceForCurrency("sek"));;
        System.out.println("\tusd: " + holder.getPriceForCurrency("usd"));;

    }
}
