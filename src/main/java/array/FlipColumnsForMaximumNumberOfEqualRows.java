package array;

public class FlipColumnsForMaximumNumberOfEqualRows {
    public static void main(String[] args) {
        FlipColumnsForMaximumNumberOfEqualRows flipColumnsForMaximumNumberOfEqualRows = new FlipColumnsForMaximumNumberOfEqualRows();
        System.out.println(flipColumnsForMaximumNumberOfEqualRows.maxEqualRowsAfterFlips(new int[][]{{0, 1}, {1, 1}}));
        System.out.println(flipColumnsForMaximumNumberOfEqualRows.maxEqualRowsAfterFlips(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(flipColumnsForMaximumNumberOfEqualRows.maxEqualRowsAfterFlips(new int[][]{{0, 0, 0}, {0, 0, 1}, {1, 1, 0}}));
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int maxCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = i + 1; j < matrix.length; j++) {
                if (xorEquals(matrix[i], matrix[j])) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount + 1;
    }

    private boolean xorEquals(int[] row1, int[] row2) {
        int xor = row1[0] ^ row2[0];
        for (int i = 0; i < row1.length; i++) {
            if (xor == (row1[i] ^ row2[i])) {
            } else {
                return false;
            }
        }
        return true;
    }
}
