package ru.alishev.happy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
@Component
abstract public class ColorFrame extends JFrame {
//    @Autowired
//    private Color color;

//    1@Autowired
//    ApplicationContext context;

    ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(1200));
 //       getContentPane().setBackground(color);
        getContentPane().setBackground(getColor());
//       1getContentPane().setBackground(context.getBean(Color.class));
        repaint();
    }

    protected abstract Color getColor();

}
