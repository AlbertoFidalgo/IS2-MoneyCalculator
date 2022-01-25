package moneycalculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moneycalculator.model.Currency;
import moneycalculator.view.MCView;

public class ExchangeListener implements ActionListener {

    private final MCView view;
    private final Exchange exchange;

    public ExchangeListener(MCView view, Exchange exchange) {
        this.view = view;
        this.exchange = exchange;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Currency currencyFrom = view.getFromCurrency();
            Currency currencyTo = view.getToCurrency();
            Double amount = view.getAmount();

            Double result = exchange.exchange(currencyFrom, currencyTo, amount);
            view.setExchange(result);
        } catch (NumberFormatException nfe) {
        }
    }
}
