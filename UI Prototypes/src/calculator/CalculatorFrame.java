package calculator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class CalculatorFrame extends JFrame {
    JPanel commandtPanel;
    JLabel display;
    double lastNumber;
    double currentNumber;
    String action;
    String output;

    public CalculatorFrame() throws HeadlessException {
        super("Calculator");

        JPanel jp = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        jp.setLayout(borderLayout);
        borderLayout.setVgap(10);
        jp.setBorder(new EmptyBorder(10, 10, 10, 10));

        display = new JLabel("0");
        display.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setHorizontalTextPosition(SwingConstants.RIGHT);

        commandtPanel = new JPanel();
        commandtPanel.setLayout(new GridLayout(4,4, 10, 10));

        JButton button7 = new ButtonCalc("7");
        commandtPanel.add(button7);
        button7.addActionListener(e -> setValue(button7));

        JButton button8 = new ButtonCalc("8");
        commandtPanel.add(button8);
        button8.addActionListener(e -> setValue(button8));

        JButton button9 = new ButtonCalc("9");
        commandtPanel.add(button9);
        button9.addActionListener(e -> setValue(button9));

        JButton buttonPlus = new ButtonCalc("+");
        commandtPanel.add(buttonPlus);
        buttonPlus.addActionListener(e -> setAction(buttonPlus));

        JButton button4 = new ButtonCalc("4");
        commandtPanel.add(button4);
        button4.addActionListener(e -> setValue(button4));

        JButton button5 = new ButtonCalc("5");
        commandtPanel.add(button5);
        button5.addActionListener(e -> setValue(button5));

        JButton button6 = new ButtonCalc("6");
        commandtPanel.add(button6);
        button6.addActionListener(e -> setValue(button6));

        JButton buttonNegative = new ButtonCalc("-");
        commandtPanel.add(buttonNegative);
        buttonNegative.addActionListener(e -> setAction(buttonNegative));

        JButton button1 = new ButtonCalc("1");
        commandtPanel.add(button1);
        button1.addActionListener(e -> setValue(button1));

        JButton button2 = new ButtonCalc("2");
        commandtPanel.add(button2);
        button2.addActionListener(e -> setValue(button2));

        JButton button3 = new ButtonCalc("3");
        commandtPanel.add(button3);
        button3.addActionListener(e -> setValue(button3));

        JButton buttonMult = new ButtonCalc("*");
        commandtPanel.add(buttonMult);
        buttonMult.addActionListener(e -> setAction(buttonMult));

        JButton buttonClear = new ButtonCalc("CE");
        commandtPanel.add(buttonClear);
        buttonClear.addActionListener(e -> clearDisp());

        JButton button0 = new ButtonCalc("0");
        commandtPanel.add(button0);
        button0.addActionListener(e -> setValue(button0));

        JButton buttonPoint = new ButtonCalc(".");
        commandtPanel.add(buttonPoint);
        buttonPoint.addActionListener(e -> setDecim(buttonPoint));

        JButton buttonPart = new ButtonCalc("/");
        commandtPanel.add(buttonPart);
        buttonPart.addActionListener(e -> setAction(buttonPart));

        JButton buttonEqual = new ButtonCalc("=");
        buttonEqual.addActionListener(e -> setAction(buttonEqual));

        jp.add(display, BorderLayout.PAGE_START);
        jp.add(commandtPanel, BorderLayout.CENTER);
        jp.add(buttonEqual, BorderLayout.PAGE_END);


        getContentPane().add(jp);

    }

    private void setValue(JButton button){
        if (currentNumber==0 && display.getText().length() < 2)
            display.setText(button.getText());
        else if (currentNumber==0 && action != null && !display.getText().endsWith("."))
            display.setText(button.getText());
        else display.setText(display.getText() + button.getText());
        currentNumber = Double.valueOf(display.getText());
    }

    private void setDecim(JButton button){
        if (!display.getText().contains("."))
            display.setText(display.getText() + button.getText());
    }

    private void clearDisp(){
        currentNumber = 0;
        action = null;
        lastNumber = 0;
        display.setText("0");
    }

    private void setAction(JButton button){
        if (action!=null){
            calculate();
            lastNumber = Double.valueOf(display.getText());
        }
        else lastNumber = currentNumber;
        action = button.getText();
        currentNumber = 0;
    }

    private void calculate(){
        currentNumber = Double.valueOf(display.getText());
        switch (action){
            case "+": lastNumber += currentNumber;
                break;
            case "-": lastNumber -= currentNumber;
                break;
            case "*": lastNumber *= currentNumber;
                break;
            case "/": lastNumber /= currentNumber;
                break;
            case "=": lastNumber = currentNumber;
        }
        output = String.valueOf(lastNumber);
        display.setText(output);
    }
}
