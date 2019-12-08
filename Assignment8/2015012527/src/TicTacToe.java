import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame {
    private Pad[][] cells;
    private JLabel statusLabel;
    private JButton startButton;
    private JButton exitButton;
    private int whoseTurn;
    private boolean isStarted;
    private JPanel mainPanel = new JPanel(new GridLayout(3, 3));
    private JPanel statusPanel = new JPanel(new BorderLayout());
    private Container contain = this.getContentPane();
    private static ImageIcon bgImage = new ImageIcon("3.jpeg");

    TicTacToe () {
        super("Tic-Tac-Toe");
        setSize(350, 400);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ((JPanel) contain).setOpaque(false);
        addBgImage();
        addMainPanel();
        addStatusPanel();
    }

    public void addBgImage() {
        JLabel imgLabel = new JLabel(bgImage);
        getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0, 0, bgImage.getIconWidth(), bgImage.getIconHeight());
    }

    public void addMainPanel() {
        cells = new Pad[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                cells[i][j] = new Pad();
                mainPanel.add(cells[i][j]);
            }
        }
        mainPanel.setVisible(false);
        contain.add(mainPanel);
    }

    public void addStatusPanel() {
        statusLabel = new JLabel();
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusPanel.add(statusLabel);

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(true);
                whoseTurn = 0;
                startButton.setText("Started");
                startButton.setEnabled(false);
                exitButton.setVisible(true);
                exitButton.setEnabled(true);
                statusLabel.setText("Player1's turn");
                isStarted = true;
                for (int i = 0; i < 3; ++i)
                    for (int j = 0; j < 3; ++j) {
                        cells[i][j].repaint();
                        cells[i][j].setFilled(false);
                        cells[i][j].setLabel(-1);
                    }
            }
        });
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                whoseTurn = 0;
                startButton.setEnabled(true);
                isStarted = true;
                exitButton.setVisible(false);
                exitButton.setEnabled(false);
                statusLabel.setText("");
                for (int i = 0; i < 3; ++i)
                    for (int j = 0; j < 3; ++j) {
                        cells[i][j].repaint();
                        cells[i][j].setFilled(false);
                        cells[i][j].setLabel(-1);
                    }
            }
        });
        statusPanel.add(startButton, BorderLayout.EAST);
        statusPanel.add(exitButton, BorderLayout.WEST);
        exitButton.setEnabled(false);
        exitButton.setVisible(false);
        add(statusPanel, BorderLayout.SOUTH);
    }

    class Pad extends JPanel {
        private boolean isFilled;
        private int label;
        private Image image1 = new ImageIcon("1.jpeg").getImage(); 
        private Image image2 = new ImageIcon("2.jpeg").getImage(); 
        Pad() {
            setBackground(Color.BLACK);
            setBorder(BorderFactory.createLineBorder(Color.WHITE));
            isFilled = false;
            addCommand();
            label = -1;
        }
        public void addCommand() {
            MouseListener command = new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if (isStarted) {
                        if (!isFilled) {
                            repaint();
                            isFilled = true;
                            whoseTurn = (whoseTurn == 0 || whoseTurn == 1) ? 2 : 1;
                            label = whoseTurn == 1 ? 2 : 1;
                        }
                        if (isWon()) {
                            int winner = whoseTurn == 1 ? 2 : 1;
                            statusLabel.setText("Player" + winner + " WINS");
                            isStarted = false;
                            startButton.setText("Restart");
                            startButton.setEnabled(true);
                        }
                        else if (isFull()) {
                            statusLabel.setText("DRAW");
                            isStarted = false;
                            startButton.setText("Restart");
                            startButton.setEnabled(true);
                        }
                        else {
                            statusLabel.setText("Player" + whoseTurn + "'s turn");
                        }
                    }
                }
            };
            addMouseListener(command);
        }

        public void setFilled (boolean filled) {
            isFilled = filled;
        }

        public boolean getFilled () {
            return isFilled;
        }

        public void setLabel (int label) {
            this.label = label;
        }

        public int getLabel () {
            return label;
        }


        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (whoseTurn == 1)
                g.drawImage(image2, 0, 0, this.getWidth(), this.getHeight(), this); 
            if (whoseTurn == 2)
                g.drawImage(image1, 0, 0, this.getWidth(), this.getHeight(), this);
        } 
    }

    public boolean isWon() {
        for (int i = 0; i < 3; ++i) {
            if (cells[i][0].getLabel()  == cells[i][1].getLabel() && cells[i][1].getLabel() == cells[i][2].getLabel() && cells[i][0].getLabel() != -1) {
                return true;
            }
            if (cells[0][i].getLabel()  == cells[1][i].getLabel() && cells[1][i].getLabel() == cells[2][i].getLabel() && cells[0][i].getLabel() != -1) {
                return true;
            }
        }
        if (cells[0][0].getLabel()  == cells[1][1].getLabel() && cells[1][1].getLabel() == cells[2][2].getLabel() && cells[0][0].getLabel() != -1) {
            return true;
        }
        if (cells[2][0].getLabel()  == cells[1][1].getLabel() && cells[1][1].getLabel() == cells[0][2].getLabel() && cells[2][0].getLabel() != -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (!cells[i][j].getFilled()) return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        new TicTacToe().setVisible(true);
    }
}