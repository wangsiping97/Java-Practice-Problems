import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class LabelButton extends JFrame {
    public static String text = "Hello, world! ";
    public static void main(String[] args) {
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JTextArea jt1=new JTextArea();
        JTextArea jt2=new JTextArea();
        JTextArea jt3=new JTextArea();
        JTextArea jt4=new JTextArea();
        JTextArea jt5=new JTextArea();
        JTextArea jt6=new JTextArea();
        String title = "ColorWord";
        JFrame jf=new JFrame(title);
        jf.setVisible(true);
        jf.setSize(600, 400);
        jf.setLayout(new BorderLayout()); 
        jf.add(BorderLayout.NORTH,jt1);
        jf.add(BorderLayout.CENTER, jp1);
        jp1.add(BorderLayout.WEST, jt2);
        jp1.add(BorderLayout.EAST, jt2);
        jf.add(BorderLayout.SOUTH, jt3);
        jf.add(BorderLayout.WEST, jp2);
        jp2.add(BorderLayout.EAST, jt4);
        jp2.add(BorderLayout.WEST, jt5);
        jp2.add(BorderLayout.WEST, jt6);
        
        jt1.setFont(new Font("隶书",Font.BOLD,60));
        jt1.setText("祝");
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}