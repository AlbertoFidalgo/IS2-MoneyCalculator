package moneycalculator.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.model.Currency;

public class FileReader implements Reader {

    public List<Currency> read() {
        try {
            Scanner scanner;
            scanner = new Scanner(new java.io.FileReader("currencies.txt"));
            List<Currency> currencyList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String currencyString = scanner.nextLine();
                String split[] = currencyString.split(",");

                Currency currency = new Currency(split[0], split[1], split[2]);
                currencyList.add(currency);
            }

            return currencyList;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
