package colorpicker;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    public static void main(String[] args) {
        ColorPicker cp = new ColorPicker();
        cp.setMinimumSize(new Dimension(500, 250));
        cp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp.setVisible(true);
    }
}
