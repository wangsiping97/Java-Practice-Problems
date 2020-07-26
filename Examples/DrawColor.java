import java.awt.*;
import javax.swing.*;
public class DrawColor extends  JFrame {
        public DrawColor () { 
                super("Color and Font");
                setVisible(true); 
                setSize(360, 200); 
        }
        public void paint(Graphics g) {
                super.paint(g);               
                g.setColor(Color.BLACK);
                g.fillRect(20, 50, 100, 50);
                g.setColor(Color.RED);
                g.fillOval(70, 60, 40, 70);
                g.setColor(Color.BLUE);
                g.setFont( new Font( "Monospaced", Font.ITALIC, 24 ) );
                g.drawString( "Monospaced 24 point italic.", 20, 150 );
        }
       public static void main(String[] args) { 
               DrawColor app = new DrawColor();   
               app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       }}
