package moneycalculator.model;

public class CurrencyAmount {
    private final Currency currency;
    private final Integer amount;
    
    public CurrencyAmount(Currency currency, Integer amount){
        this.currency = currency;
        this.amount = amount;
    }
    
    public CurrencyAmount convert(Currency currencyTo){
        CurrencyAmount newAmount = null;
        
        return newAmount;
        
    }

    public Currency getCurrency() {
        return currency;
    }

    public Integer getAmount() {
        return amount;
    }
    
    
    
}
