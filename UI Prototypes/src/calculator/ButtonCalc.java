package calculator;

import javax.swing.*;
import java.awt.*;

public class ButtonCalc extends JButton {

    public ButtonCalc(String text) {
        super(text);
        this.setMargin(new Insets(10, 10, 10, 10));
        this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    }
}
