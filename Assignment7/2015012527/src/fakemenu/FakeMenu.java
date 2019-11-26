package fakemenu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FakeMenu extends JFrame {
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("FakeMenu");
        frame.setSize(200, 45);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口

        /** add JMenuBar */
        JMenuBar jmb = new JMenuBar();

        /** add JMenu */
        JMenu jm = new JMenu("FakeMenu");
        JMenu jm1 = new JMenu("File");
        JMenu jm2 = new JMenu("Edit");
        JMenu jm3 = new JMenu("Help");

        /** add items to menu */
        jm1.add(new JMenuItem("New"));
        jm1.add(new JMenuItem("Open"));
        jm1.add(new JMenuItem("Save"));

        jm2.add(new JMenuItem("Copy"));
        jm2.add(new JMenuItem("Cut"));
        jm2.add(new JMenuItem("Paste"));
        jm2.add(new JMenuItem("Cancel"));

        jm3.add(new JMenuItem("About"));

        jm.add(jm1);
        jm.add(jm2);
        jm.add(new JMenuItem("Window"));
        jm.add(jm3);
        
        /** add menu to MenuBar */
        jmb.add(jm);

        /** add MenuBar to frame */
        frame.setJMenuBar(jmb);
        frame.setVisible(true);
    }
}