package tictactoe;

public class TicTacToe {
    private int[][] table = new int[3][3];
    TicTacToe () {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                table[i][j] = 0;
            }
        }
    }
    public int place (int player, int row, int column) {
        if (table[row][column] != 0) return 3;
        table[row][column] = player;
        for (int i = 0; i < 3; ++i) {
            if (table[i][0] == table[i][1] && table[i][0] == table[i][2]) return table[i][0];
            if (table[0][i] == table[1][i] && table[0][i] == table[2][i]) return table[0][i];
        }
        if (table[0][0] == table[1][1] && table[0][0] == table[2][2]) return table[0][0];
        if (table[0][2] == table[1][1] && table[0][2] == table[2][0]) return table[0][2];
        return 0;
    }
}