package dynamicprogramming.uniquepaths;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(7, 3));
    }

    private int[][] memoryTable;

    public int uniquePaths(int m, int n) {
        memoryTable = new int[m + 1][];
        for (int i = 0; i <= m; i++) {
            memoryTable[i] = new int[n + 1];
        }
        return uniquePathRecursive(m, n);
    }

    private int uniquePathRecursive(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        if (memoryTable[m][n] > 0) {
            return memoryTable[m][n];
        }
        int result = uniquePathRecursive(m -1, n) + uniquePathRecursive(m, n -1);
        memoryTable[m][n] = result;
        return result;
    }
}
