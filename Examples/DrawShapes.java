import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;

public class DrawShapes extends JFrame {
    public DrawShapes () { // construct func
        setVisible(true); // set window visible
        setSize(420, 200);
    }
    public void paint (Graphics g) {
        super.paint(g); // use g as painter
        g.drawLine(15, 50, 350, 50);
        g.drawRect(15, 60, 90, 55);
        g.fillRect(110, 60, 90, 55);
        g.fillRoundRect(205, 60, 90, 55, 50, 50);
        g.drawRoundRect(300, 60, 90, 55, 20, 20);
        g.drawOval(15, 120, 90, 55);
        g.fillOval(110, 120, 90, 55);
    }
    public static void main (String[] arguments) {
        DrawShapes app = new DrawShapes();
        app.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);
    }
}