package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class CryptoPriceCheckerTest {

    @Test
    public void testCryptoPriceChecker() {
        CryptoPriceChecker checker = new CryptoPriceChecker("ethereum");

        CryptoPricesHolder holder = checker.getCryptoPrice(Arrays.asList("eur", "sek"));

        assertNotNull(holder, "CryptoPricesHolder should not be null");

        double eurPrice = holder.getPriceForCurrency("eur");
        assertTrue(eurPrice > 0, "The price for EUR should be greater than 0");

        double sekPrice = holder.getPriceForCurrency("sek");
        assertTrue(sekPrice > 0, "The price for SEK should be greater than 0");

        double usdPrice = holder.getPriceForCurrency("usd");
        assertTrue(usdPrice < 0, "The price for USD should be less than 0 since it was not queried");
    }
}
