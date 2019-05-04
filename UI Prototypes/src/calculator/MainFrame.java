package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainFrame {

    public static void main(String[] args) {
        CalculatorFrame f = new CalculatorFrame();
        f.setBounds(10, 10, 300, 450);
        f.setMinimumSize(new Dimension(300, 450));
        f.setMaximizedBounds(new Rectangle(450, 625));
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);


    }
}
