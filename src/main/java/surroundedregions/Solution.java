package surroundedregions;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }



    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        boolean[] visited = new boolean[board.length * board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
                    if (board[i][j] == 'O' && !visited[i * board[i].length + j]) {
                        dfs(board, visited, i, j);
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, boolean[] visited, int row, int col) {
        if (board[row][col] != 'O' || visited[row * board[row].length + col]) {
            return;
        }
        visited[row * board[row].length + col] = true;
        board[row][col] = 'Y';
        if (row > 0) {
            dfs(board,visited, row - 1, col);
        }
        if (row < board.length - 1) {
            dfs(board,visited, row + 1, col);
        }
        if (col > 0) {
            dfs(board,visited, row, col - 1);
        }
        if (col < board[row].length - 1) {
            dfs(board,visited, row, col + 1);
        }
    }
}
