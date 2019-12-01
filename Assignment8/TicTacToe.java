import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe extends JFrame {
    private DrawingPad[][] cells;
    private JLabel statusLabel;
    private JButton startButton;
    private char whoseTurn;
    private boolean isStarted;

    private TicTacToe () {
        super("Tic-Tac-Toe");
        setSize(360, 360);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new GridLayout(3, 3));
        cells = new DrawingPad[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                cells[i][j] = new DrawingPad();
                cells[i][j].addCommand();
                cells[i][j].setBackground(Color.WHITE);
                cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                // cells[i][j].repaint();
                mainPanel.add(cells[i][j]);
            }
        }
        mainPanel.setVisible(true);
        add(mainPanel);

        JPanel statusPanel = new JPanel(new BorderLayout());
        statusLabel = new JLabel();
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusPanel.add(statusLabel);

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                startButton.setText("Started");
                startButton.setEnabled(false);
                statusLabel.setText("O's turn");
                isStarted = true;
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        // repaint();
                    }
                }
                whoseTurn = 'O';
            }
        });
        statusPanel.add(startButton, BorderLayout.EAST);
        add(statusPanel, BorderLayout.SOUTH);
    }

    public static void main (String[] args) {
        new TicTacToe().setVisible(true);
    }


    class DrawingPad extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (isStarted) {
                g.setColor(Color.BLACK);
                if (whoseTurn == 'O') {
                    g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
                } 
                if (whoseTurn == 'X') {
                    int x = getWidth() - 10;
                    int y = getHeight() - 10;
                    g.drawLine(10, 10, x, y);
                    g.drawLine(x, 10, 10, y);
                }
            }
        }
        public void addCommand() {
            MouseListener command = new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if (isStarted) {
                        System.out.println("click");
                        repaint();
                        whoseTurn = whoseTurn == 'O' ? 'X' : 'O';
                        statusLabel.setText(whoseTurn + "'s turn");
                    }
                }
            };
            this.addMouseListener(command);
        }
        
    }
}