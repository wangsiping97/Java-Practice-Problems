package colorword;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class ColorWord extends JFrame {
    public static String text = "Hello, world! ";
    public static void main(String[] args) {
        JPanel jp = new JPanel();
        JButton jb1 = new JButton("RED");
        jb1.setBackground(Color.RED);
        JButton jb2 = new JButton("GREEN");
        jb2.setBackground(Color.GREEN);
        JButton jb3 = new JButton("BLUE");
        jb3.setBackground(Color.BLUE);
        JTextArea jt=new JTextArea();
        String title = "ColorWord";
        JFrame jf=new JFrame(title);
        jf.setVisible(true);
        jf.setSize(600, 400);
        jf.setLayout(new BorderLayout()); 
        jf.add(BorderLayout.CENTER,jt);
        jf.add(BorderLayout.SOUTH, jp);
        jp.add(BorderLayout.NORTH,jb1);
        jp.add(BorderLayout.CENTER, jb2);
        jp.add(BorderLayout.SOUTH, jb3);
        jt.setFont(new Font("宋体",Font.BOLD,60));
        jt.setText(text);
        jb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jt.setForeground(Color.RED);
                jt.setText(text);
            }
        });
        jb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jt.setForeground(Color.GREEN);
                jt.setText(text);
            }
        });
        jb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jt.setForeground(Color.BLUE);
                jt.setText(text);
            }
        });
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}