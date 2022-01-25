package moneycalculator.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import moneycalculator.model.Currency;

public class MCView extends JFrame {

    private final JComboBox nameBoxFrom;
    private final JComboBox nameBoxTo;
    private final JTextField numberField;
    private final JTextField solutionField;
    private final JButton exchangeButton;

    public MCView(List<Currency> currencyList) {
        Object[] nameList = currencyList.toArray();

        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        JLabel fromLabel = new JLabel("From:");
        nameBoxFrom = new JComboBox(nameList);
        JLabel toLabel = new JLabel("To:");
        nameBoxTo = new JComboBox(nameList);
        numberField = new JTextField(10);
        solutionField = new JTextField(10);
        solutionField.setEditable(false);
        exchangeButton = new JButton("Exchange");
        
        panel.add(fromLabel);
        panel.add(nameBoxFrom);
        panel.add(numberField);
        panel.add(toLabel);
        panel.add(nameBoxTo);
        panel.add(solutionField);
        panel.add(exchangeButton);
        add(panel);
    }

    public Currency getFromCurrency() {
        return (Currency)nameBoxFrom.getSelectedItem();
    }
    
    public Currency getToCurrency() {
        return (Currency)nameBoxTo.getSelectedItem();
    }
    
    public Double getAmount(){
        return Double.parseDouble(numberField.getText());
    }
    
    public void setExchange(Double solution){
        solutionField.setText(solution.toString());
    }
    
    public void addExchangeListener(ActionListener listener){
        exchangeButton.addActionListener(listener);
    }

}
