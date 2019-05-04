package colorpicker;

import sun.plugin2.util.ColorUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ColorPicker extends JFrame {

    private int r = 125;
    private int g = 125;
    private int b = 125;
    JPanel color;

    public ColorPicker() throws HeadlessException {
        super("Color Picker");

        JPanel mainP = new JPanel();
        mainP.setLayout(new BoxLayout(mainP, BoxLayout.X_AXIS));
        mainP.setBorder(new EmptyBorder(10, 10, 10, 10));


        color = new JPanel();
        color.setBackground(new Color(r, g, b));
        color.setPreferredSize(new Dimension(250, 250));

        JPanel names = new JPanel(new GridLayout(3, 1));
        names.setBorder(new EmptyBorder(0, 5, 0, 0));
        JLabel name = new JLabel("Red:");
        name.setVerticalAlignment(SwingConstants.TOP);
        name.setBorder(new EmptyBorder(10, 5, 0, 0));
        names.add(name);
        name = new JLabel("Green:");
        name.setVerticalAlignment(SwingConstants.TOP);
        name.setBorder(new EmptyBorder(10, 5, 0, 0));
        names.add(name);
        name = new JLabel("Blue:");
        name.setVerticalAlignment(SwingConstants.TOP);
        name.setBorder(new EmptyBorder(10, 5, 0, 0));
        names.add(name);


        JPanel settings = new JPanel(new GridLayout(3, 1));
        settings.setPreferredSize(new Dimension( 350,250));


        JSlider slRed = new JSlider(SwingConstants.HORIZONTAL,0, 255, 125);
        slRed.setMajorTickSpacing(255);
        slRed.setMinorTickSpacing(20);
        slRed.setPaintLabels(true);
        slRed.setPaintTicks(true);
        JSlider slGreen = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 125);
        slGreen.setMajorTickSpacing(255);
        slGreen.setMinorTickSpacing(20);
        slGreen.setPaintLabels(true);
        slGreen.setPaintTicks(true);
        JSlider slBlue = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 125);
        slBlue.setMajorTickSpacing(255);
        slBlue.setMinorTickSpacing(20);
        slBlue.setPaintLabels(true);
        slBlue.setPaintTicks(true);

        color.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                String c = Integer.toHexString(color.getBackground().getRGB());
                color.setToolTipText("#" + c.substring(2, c.length()));
            }
        });

        ChangeListener cl = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (e.getSource().equals(slBlue))
                    b = slBlue.getValue();
                if (e.getSource().equals(slGreen))
                    g = slGreen.getValue();
                if (e.getSource().equals(slRed))
                    r = slRed.getValue();
                color.setBackground(new Color(r,g,b));
            }
        };

        slBlue.addChangeListener(cl);
        slGreen.addChangeListener(cl);
        slRed.addChangeListener(cl);

        settings.add(slRed);
        settings.add(slGreen);
        settings.add(slBlue);


        mainP.add(color);
        mainP.add(names);
        mainP.add(settings);
        getContentPane().add(mainP);

    }
}
