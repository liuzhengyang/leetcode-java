package dynamicprogramming.maximalrectangle;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution rect = new Solution();
        char[][] chars = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        System.out.println(rect.maximalRectangle(chars));
    }

    private Rect[][] cacheTable;

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        cacheTable = new Rect[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            cacheTable[i] = new Rect[matrix[i].length];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (cacheTable[i][j] == null) {
                    cacheTable[i][j] = maximalRectangle(matrix, i, j);
                }
            }
        }
        int maxRectangle = 0;
        for (int i = 0; i < cacheTable.length; i++) {
            for (int j = 0; j < cacheTable[i].length; j++) {
                if (cacheTable[i][j] == null) {
                    continue;
                }
                maxRectangle = Math.max(maxRectangle,
                        cacheTable[i][j].width * cacheTable[i][j].height);
            }
        }

        return maxRectangle;
    }

    private Rect maximalRectangle(char[][] matrix, int m, int n) {
        if (cacheTable[m][n] != null) {
            return cacheTable[m][n];
        }
        Rect result;

        if (matrix[m][n] == '0') {
            result = ZERO_RECT;
        } else if (m == matrix.length - 1 && n == matrix[m].length - 1) {
            result = matrix[m][n] == '1' ? new Rect(1, 1) : new Rect();
        } else if (m + 1 == matrix.length) {
            result = new Rect(maximalRectangle(matrix, m, n + 1).width + 1, 1);
        } else if (n + 1 == matrix[m].length) {
            result = new Rect(1, maximalRectangle(matrix, m + 1, n).height + 1);
        } else {
            Rect rect1 = maximalRectangle(matrix, m, n + 1);
            Rect rect2 = maximalRectangle(matrix, m + 1, n);
            int widht = Math.max(1, Math.min(rect1.width + 1, rect2.width));
            int height = Math.max(1, Math.min(rect1.height, rect2.height + 1));
            result = new Rect(widht, height);
        }
        cacheTable[m][n] = result;
        return result;
    }

    private static Rect ZERO_RECT = new Rect();

    private static class Rect {
        private int width;
        private int height;

        public Rect() {
        }

        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Rect{" +
                    "width=" + width +
                    ", height=" + height +
                    '}';
        }
    }
}
