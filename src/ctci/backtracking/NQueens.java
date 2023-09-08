package ctci.backtracking;

import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {
        int n = 5; // Number of queens and board size (5x5 in this case)
        boolean[][] board = new boolean[n][n]; // Create a 2D boolean array to represent the chessboard
        System.out.println(queens(board, 0)); // Call the queens function to solve the problem and print the count of solutions.
    }

    // The main recursive function to solve the N-Queens problem.
    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            Display(board); // If all queens are placed successfully, display the board configuration.
            System.out.println();
            return 1; // Return 1 to indicate that a solution has been found.
        }
        int count = 0; // Initialize a count to keep track of the number of solutions.

        // Try placing a queen in each column of the current row.
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) { // Check if it's safe to place a queen at the current position.
                board[row][col] = true; // Place the queen at the current position.
                count += queens(board, row + 1); // Recursively try to place queens in the next row.
                board[row][col] = false; // Backtrack by removing the queen from the current position.
            }
        }
        return count; // Return the total count of solutions.
    }

    // Function to check if it's safe to place a queen at a given position (row, col).
    static boolean isSafe(boolean[][] board, int row, int col) {
        // Check if there is a queen in the same column.
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false; // If there is a queen in the same column, it's not safe.
            }
        }

        // Check the diagonal (top-left to bottom-right) for queens.
        int maxLeft = Math.min(col, row);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false; // If there is a queen in the diagonal, it's not safe.
            }
        }

        // Check the diagonal (top-right to bottom-left) for queens.
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false; // If there is a queen in the diagonal, it's not safe.
            }
        }

        return true; // If no conflicts were found, it's safe to place a queen at the given position.
    }

    // Function to display the current board configuration.
    static void Display(boolean[][] board) {
        for (boolean[] arr : board) {
            for (boolean val : arr) {
                if (val) {
                    System.out.print(" X "); // Display 'X' for queen positions.
                } else {
                    System.out.print(" O "); // Display 'O' for empty positions.
                }
            }
            System.out.println(); // Move to the next row.
        }
    }
}
