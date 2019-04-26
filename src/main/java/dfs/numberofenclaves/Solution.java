package dfs.numberofenclaves;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int numEnclaves(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                dfs(A, i, 0);
            }
            if (A[i][A[i].length - 1] == 1) {
                dfs(A, i, A[i].length - 1);
            }
        }
        for (int i = 0; i < A[0].length; i++) {
            if (A[0][i] == 1) {
                dfs(A, 0, i);
            }
            if (A[A.length - 1][i] == 1) {
                dfs(A, A.length - 1, i);
            }
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    count ++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] graph, int row, int col) {
        if (graph[row][col] != 1) {
            return;
        }
        graph[row][col] = -1;
        if (row > 0 && graph[row - 1][col] == 1) {
            dfs(graph, row - 1, col);
        }
        if (row < graph.length - 1 && graph[row + 1][col] == 1) {
            dfs(graph, row + 1, col);
        }
        if (col > 0 && graph[row][col - 1] == 1) {
            dfs(graph, row, col - 1);
        }
        if (col < graph[row].length - 1 && graph[row][col + 1] == 1) {
            dfs(graph, row, col + 1);
        }
    }
}
