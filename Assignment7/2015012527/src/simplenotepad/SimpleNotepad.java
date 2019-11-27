package simplenotepad;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.InputEvent;
import java.awt.event.TextArea;
import java.awt.FileDialog;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleNotepad extends JFrame {
    public static void main (String[] args) {
        JFrame frame = new JFrame("SimpleNotepad");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /** add TextArea */
        TextArea text = new TextArea();
        text.setFont(new Font("宋体", Font.PLAIN, 14));
        frame.add(text);

        /** add menu */
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        menu.add(open);
        menu.add(save);
        bar.add(menu);
        frame.setJMenuBar(bar);

        /** add listener */
        ActionListener openCommand = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileDialog file = new FileDialog(frame, "打开", FileDialog.LOAD);
                file.setVisible(true);
                String absPath = file.getDirectory() + file.getFile();
                if(file.getFile() == null) {
                    return;
                }
                try {
                    text.append("");
                    BufferedReader buf = new BufferedReader(new FileReader(absPath));
                    char[] temp = new char[1024];
                    int len = 0;
                    while ((len = buf.read(temp)) != -1) {
                        String str = new String(temp,0,len);
                        text.append(str);
                    }
                    buf.close();
                } catch (Exception ex) {
                    text.append("Open error");
                }
            }
        };

        ActionListener saveCommand = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileDialog file = new FileDialog(frame, "另存为", FileDialog.SAVE);
                file.setVisible(true);
                String absPath = file.getDirectory() + file.getFile();
                if(file.getFile() == null) {
                    return;
                }
                try {
                    BufferedWriter buf = new BufferedWriter(new FileWriter(absPath));
                    String str = text.getText();
                    buf.write(str);
                    buf.close();
                } catch (Exception ex) { }
            }
        };

        open.addActionListener(openCommand);
        save.addActionListener(saveCommand);

        frame.setVisible(true);
    }
}