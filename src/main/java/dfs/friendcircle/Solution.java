package dfs.friendcircle;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    private int[] visited;
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(i, M);
                count ++;
            }
        }

        return count;
    }

    private void dfs(int index, int[][] M) {
        if (visited[index] == 0) {
            visited[index] = 1;
        }
        for (int i = 0; i < M[index].length; i++) {
            if (M[index][i] == 1 && visited[i] == 0) {
                dfs(i, M);
            }
        }
        visited[index] = 2;
    }
}
