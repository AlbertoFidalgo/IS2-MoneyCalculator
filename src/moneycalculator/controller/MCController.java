package moneycalculator.controller;

import java.util.List;
import moneycalculator.model.Currency;
import moneycalculator.view.MCView;

public class MCController {
    public List<Currency> currencyList;
    private final MCView view;
    private final ExchangeListener listener;

    public MCController(List<Currency> currencyList, MCView view) {
        this.currencyList = currencyList;
        this.view = view;
        
        listener = new ExchangeListener(view, new ExchangeAPI());
        view.addExchangeListener(listener);
    }
}
