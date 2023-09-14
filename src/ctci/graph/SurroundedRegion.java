package ctci.graph;

public class SurroundedRegion {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        solve(board);

        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return; // If the board is empty or null, there's nothing to do.
        }

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Mark 'O' regions on the boundary as temporary 'T' to avoid flipping them
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0); // Start DFS from the left boundary
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1); // Start DFS from the right boundary
            }
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j); // Start DFS from the top boundary
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j); // Start DFS from the bottom boundary
            }
        }

        // Step 2: Flip 'O's inside the grid to 'X' and restore 'T's to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Flip 'O' to 'X' as it's surrounded
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O'; // Restore 'T' to 'O' as it's not surrounded
                }
            }
        }
    }

    static void dfs(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O') {
            return; // Stop DFS if out of bounds or cell is not 'O'
        }

        board[row][col] = 'T'; // Mark 'O' as temporary 'T'

        // Recursively check adjacent cells
        dfs(board, row + 1, col); // Down
        dfs(board, row - 1, col); // Up
        dfs(board, row, col + 1); // Right
        dfs(board, row, col - 1); // Left
    }
}
