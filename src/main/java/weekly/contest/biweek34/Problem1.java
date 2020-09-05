package weekly.contest.biweek34;

/**
 * @author liuzhengyang
 */
public class Problem1 {
    public static void main(String[] args) {

    }

    public int diagonalSum(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return 0;
        }
        int sum = 0;
        int len = mat.length;
        for (int i = 0; i < mat.length; i++) {
            if (i != (len - i - 1)) {
                sum += (mat[i][i] + mat[i][len - i - 1]);
            } else {
                sum += mat[i][i];
            }
        }
        return sum;
    }
}
