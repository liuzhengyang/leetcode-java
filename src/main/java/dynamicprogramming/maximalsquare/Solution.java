package dynamicprogramming.maximalsquare;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] chars = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        System.out.println(solution.maximalSquare(chars));
    }

    private Rect[][] cache;

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        cache = new Rect[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            cache[i] = new Rect[matrix[i].length];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (cache[i][j] == null) {
                    cache[i][j] = maxSquare(matrix, i, j);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Rect rect = cache[i][j];
                int shortEdge = Math.min(rect.width, rect.height);
                max = Math.max(max, shortEdge * shortEdge);
            }
        }

        return max;
    }

    private Rect maxSquare(char[][] matrix, int m, int n) {
        if (cache[m][n] != null) {
            return cache[m][n];
        }
        Rect result;
        if (matrix[m][n] == '0') {
            result = new Rect();
        }
        else if (m == matrix.length - 1 && n == matrix[m].length - 1) {
            result = new Rect(1, 1);
        }

        else if (m == matrix.length - 1) {
            result = new Rect(1 + maxSquare(matrix, m, n + 1).width, 1);
        }
        else if (n == matrix[m].length - 1) {
            result = new Rect(1, 1 + maxSquare(matrix, m + 1, n).height);
        } else {
            Rect rect1 = maxSquare(matrix, m, n + 1);
            Rect rect2 = maxSquare(matrix, m + 1, n);
            int width = Math.max(1, Math.min(rect1.width + 1, rect2.width));
            int height = Math.max(1, Math.min(rect1.height, rect2.height + 1));
            result = new Rect(width, height);
        }
        cache[m][n] = result;
        return result;
    }

    private static class Rect {
        private int width;
        private int height;

        public Rect() {
        }

        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}
