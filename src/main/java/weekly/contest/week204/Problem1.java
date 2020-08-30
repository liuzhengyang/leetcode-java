package weekly.contest.week204;

/**
 * https://leetcode-cn.com/contest/weekly-contest-204/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
 * @author liuzhengyang
 */
public class Problem1 {
    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        System.out.println(problem1.containsPattern(new int[] {1, 2, 1, 2, 1, 3}, 2, 3));
        System.out.println(problem1.containsPattern(new int[] {3,6,6,6,5,1,5,2,2,3,1,5,2,6,1,5,1,2,6,3,3,5,3,6,3,4 }, 6, 2));
    }

    public boolean containsPattern(int[] arr, int m, int k) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean equals = true;
            for (int j = 0; j < m; j++) {
                if (!equals) {
                    break;
                }
                for (int l = 1; l < k; l++) {
                    if (i + j + (l * m) < arr.length) {
                        if (arr[i + j] != arr[i + j + (l * m)]) {
                            equals = false;
                            break;
                        } else {
                            if (l == k - 1 && j == m - 1) {
                                return true;
                            }
                        }
                    } else {
                        equals = false;
                        break;
                    }
                }
            }
        }
        return false;
    }
}
