import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame {
    private Pad[][] cells;
    private JLabel statusLabel;
    private JButton startButton;
    private int whoseTurn;
    private boolean isStarted;
    private JPanel mainPanel;
    private JPanel statusPanel;

    TicTacToe () {
        super("Tic-Tac-Toe");
        setSize(360, 400);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainPanel = new JPanel(new GridLayout(3, 3));
        addMainPanel(mainPanel);
        statusPanel = new JPanel(new BorderLayout());
        addStatusPanel(statusPanel);
    }

    public void addMainPanel(JPanel mainPanel) {
        cells = new Pad[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                cells[i][j] = new Pad();
                mainPanel.add(cells[i][j]);
            }
        }
        mainPanel.setVisible(true);
        add(mainPanel);
    }

    public void addStatusPanel(JPanel statusPanel) {
        statusLabel = new JLabel();
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusPanel.add(statusLabel);

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                whoseTurn = 0;
                startButton.setText("Started");
                startButton.setEnabled(false);
                statusLabel.setText("Player1's turn");
                isStarted = true;
                System.out.println("Fucker");
                for (int i = 0; i < 3; ++i)
                    for (int j = 0; j < 3; ++j) {
                        cells[i][j].repaint();
                        cells[i][j].setFilled(false);
                        cells[i][j].setLabel(-1);
                    }
            }
        });
        statusPanel.add(startButton, BorderLayout.EAST);
        add(statusPanel, BorderLayout.SOUTH);
    }

    class Pad extends JPanel {
        private boolean isFilled;
        private int label;
        private Image image1 = new ImageIcon("1.jpeg").getImage(); 
        private Image image2 = new ImageIcon("2.jpeg").getImage(); 
        Pad() {
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            isFilled = false;
            addCommand();
            label = -1;
        }
        public void addCommand() {
            MouseListener command = new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if (isStarted) {
                        System.out.println("click");
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

