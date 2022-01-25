package moneycalculator.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import moneycalculator.model.Currency;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ExchangeAPI implements Exchange{
    
    public Double exchange(Currency currencyFrom, Currency currencyTo, Double amount){
        try {
            String url = "https://freecurrencyapi.net/api/v2/latest?apikey="
                    + "604914e0-7df1-11ec-8f0f-c91cf8ff0607&base_currency=" 
                    + currencyFrom.getCode();
            URL urlForGetRequest = new URL(url);
            String readLine = null;
            HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
            conection.setRequestMethod("GET");
            int responseCode = conection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
                StringBuffer response = new StringBuffer();
                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                }
                String string = response.toString();
                in.close();
                
                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(string);
                JSONObject name = (JSONObject) json.get("data");
                Double exchangeRate = (Double) name.get(currencyTo.getCode());
                Double result = amount*exchangeRate;
                
                return result;
                
            } else {
                throw new Exception("Error in API Call");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
}
