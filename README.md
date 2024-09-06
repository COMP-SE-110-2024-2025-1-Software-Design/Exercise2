# Simple API Client for Checking the Prices of a Cryptocurrency Coin
In this exercise solution I provide a simple client for checking the current price of different cryptocurrency coins.\
The prices are read from public APIs provided by "coingecko.com" (i.e. https://api.coingecko.com/api/v3/simple/price).

## Classes
### `CryptoPriceChecker`
The client that receives the coin name (e.g. bitcoin, ethereum, falcon, etc.) and is capable of requesting for their prices from coingecko.
In order to retrieve prices from CryptoPriceChecker, you should provide the currencies for which you need prices — e.g., eur (for Euro), usd (for US Dollar), etc.\
the `getCryptoPrice` method that is responsible for such behavior returns an object of `CryptoPricesHolder` which will be further introduced in this README.

### `CryptoPricesHolder`
A class that is responsible for holding the retrieved data from coingecko. It retrieves the coin name and the data received from coingecko in order to be constructed.
it provides the `getPriceForCurrency` method in order to ask prices for different currencies for this very coin name — returns -1 if the currency was not provided in the returned json data.

### `Main`
The entry point of the program which provides a simple example of how to use this simple client (i.e.  `CryptoPriceChecker`).

### `CryptoPriceCheckerTest`
A simple JUnit test class that provides one single unittest for testing whether every requested currency price is available in the response data, specifically `CryptoPricesHolder`.
