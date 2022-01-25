package moneycalculator;

import java.io.FileNotFoundException;
import java.util.List;
import moneycalculator.model.*;
import moneycalculator.controller.*;
import moneycalculator.view.*;

public class MoneyCalculator {

    public static void main(String[] args) throws FileNotFoundException {
        Reader reader = new FileReader();
        List<Currency> currencyList = reader.read();
        MCView view = new MCView(currencyList);
        MCController controller = new MCController(currencyList, view);

        view.setVisible(true);
    }
}
