package weekly.contest.week206;

/**
 * @author liuzhengyang
 */
public class Problem1 {
    public static void main(String[] args) {

    }

    public int numSpecial(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    boolean isSpecial = true;
                    for (int k = 0; k < mat[i].length; k++) {
                        if (k != j && mat[i][k] == 1) {
                            isSpecial = false;
                            break;
                        }
                    }
                    for (int k = 0; k < mat.length; k++) {
                        if (k != i && mat[k][j] == 1) {
                            isSpecial = false;
                            break;
                        }
                    }
                    if (isSpecial) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
