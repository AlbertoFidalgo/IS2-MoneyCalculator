package moneycalculator.controller;

import java.util.List;
import moneycalculator.model.Currency;

public interface Reader {
    
    List<Currency> read();
    
}
