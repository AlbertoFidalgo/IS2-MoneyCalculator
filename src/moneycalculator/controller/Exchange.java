package moneycalculator.controller;
import moneycalculator.model.Currency;

public interface Exchange {
    
    Double exchange(Currency currencyFrom ,Currency currencyTo ,Double amount);
    
}
