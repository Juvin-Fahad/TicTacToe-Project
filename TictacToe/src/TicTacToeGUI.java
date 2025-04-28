import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame {
    private final JButton[][] buttons = new JButton[3][3];
    private char currentPlayer = 'O'; // Player 1 starts
    private char[][] board = new char[3][3];
    private boolean gameOver = false;

    public TicTacToeGUI() {
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3)); // 3x3 grid for buttons

        // Initialize the board and buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '.'; // Empty space on the board
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].setOpaque(true);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(buttons[i][j]);
            }
        }
        setVisible(true);
    }

    // Listener for button clicks
    private class ButtonClickListener implements ActionListener {
        private final int row;
        private final int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (gameOver || board[row][col] != '.') return;

            // Mark the button
            board[row][col] = currentPlayer;
            buttons[row][col].setText(String.valueOf(currentPlayer));

            if (checkWinner()) {
                gameOver = true;
                endGame("Player " + currentPlayer + " wins!");
            } else if (isBoardFull()) {
                gameOver = true;
                endGame("It's a draw!");
            } else {
                // No win or draw, continue
                currentPlayer = (currentPlayer == 'O') ? 'X' : 'O';
            }
        }

    }
    private void endGame(String message) {
        int choice = JOptionPane.showConfirmDialog(
                this,
                message + "\nPlay another game?",
                "Game Over",
                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            dispose();
            System.exit(0);
        }
    }


    // Check if a player has won
    private boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            return true;
        return false;
    }

    // Check if the board is full (draw)
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') return false;
            }
        }
        return true;
    }

    // Reset the game
    public void resetGame() {
        currentPlayer = 'O';
        gameOver = false; // Make sure to allow moves again
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '.';
                buttons[i][j].setText("");
            }
        }
    }
}