package drawarc;

import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;

public class DrawArc extends JFrame {
    public DrawArc() { // construct func
        super("DrawArc");
        setVisible(true); // set window visible
        setSize(600, 600);
    }
    public void paint (Graphics g) {
        super.paint(g); // use g as painter
        g.setColor(Color.GREEN);
        g.fillRect(295, 200, 10, 350);
        g.setColor(Color.BLUE);
        g.fillArc(150, 50, 300, 300, 120, 30);
        g.fillArc(150, 50, 300, 300, 30, 30);
        g.fillArc(150, 50, 300, 300, 210, 30);
        g.fillArc(150, 50, 300, 300, 300, 30);
        g.setColor(Color.BLACK);
        g.setFont( new Font( "Monospaced", Font.ITALIC, 24 ) );
        g.drawString("Gone with the wind", 20,500);
    }
    public static void main (String[] arguments) {
        DrawArc app = new DrawArc();
        app.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);
    }
}