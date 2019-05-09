package dynamicprogramming.rangesumquery2d;

/**
 * @author liuzhengyang
 */
public class Solution {

}


class NumMatrix {

    private int[][] area;
    public NumMatrix(int[][] matrix) {
        if (matrix != null) {
            area = new int[matrix.length][];
            for (int i = 0; i < matrix.length; i++) {
                area[i] = new int[matrix[i].length];
            }
            calculateCache(matrix);
        }
    }

    private void calculateCache(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    area[i][j] = j == 0 ? matrix[i][j] : area[i][j - 1] + matrix[i][j];
                } else {
                    area[i][j] = j == 0 ? area[i - 1][j] + matrix[i][j] :
                            (area[i][j - 1] + area[i - 1][j] - area[i - 1][j - 1] + matrix[i][j]);
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (area == null) {
            return 0;
        }
        int areaSum = 0;
        areaSum += area[row2][col2];
        if (row1 > 0) {
            areaSum -= area[row1 - 1][col2];
        }
        if (col1 > 0) {
            areaSum -= area[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            areaSum += area[row1 - 1][col1 - 1];
        }
        return areaSum;
    }
}
