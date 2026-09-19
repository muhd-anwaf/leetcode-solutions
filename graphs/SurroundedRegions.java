/*
 * LeetCode #130 - Surrounded Regions
 * Difficulty: Medium
 * Topic: Graphs / DFS / Matrix
 *
 * Approach:
 * 1. Start DFS from all 'O's on the boundary.
 * 2. Mark boundary-connected 'O's as 'S' (safe).
 * 3. Convert remaining 'O's to 'X'.
 * 4. Convert 'S' back to 'O'.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) - recursion stack in the worst case
 */

class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(0, j, board);
            if (board[m - 1][j] == 'O') dfs(m - 1, j, board);
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board);
            if (board[i][n - 1] == 'O') dfs(i, n - 1, board);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = (board[i][j] == 'S') ? 'O' : 'X';
            }
        }
    }

    private void dfs(int row, int col, char[][] board) {
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'S';

        dfs(row + 1, col, board);
        dfs(row - 1, col, board);
        dfs(row, col + 1, board);
        dfs(row, col - 1, board);
    }
}