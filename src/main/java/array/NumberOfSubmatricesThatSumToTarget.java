package array;

public class NumberOfSubmatricesThatSumToTarget {
    public static void main(String[] args) {

    }

    private int[][] sumMatrics;

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        sumMatrics = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            sumMatrics[i] = new int[matrix[0].length];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    sumMatrics[i][j] = matrix[i][j];
                }
                else if (i == 0) {
                    sumMatrics[i][j] = matrix[i][j - 1] + matrix[i][j];
                } else if (j == 0) {
                    sumMatrics[i][j] = sumMatrics[i - 1][j] + matrix[i][j];
                } else {
                    sumMatrics[i][j] = sumMatrics[i - 1][j - 1] + matrix[i][j - 1] + matrix[i - 1][j];
                }
            }
        }
        int count = 0;

        return 0;
    }
}
