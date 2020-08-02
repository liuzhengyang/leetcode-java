package weekly.contest.week200;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Problem3 {

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.minSwaps(new int[][] {{0, 0, 1}, {1, 1, 0}, {1, 0, 0}}));
        System.out.println(problem3.minSwaps(new int[][] {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}}));
        System.out.println(problem3.minSwaps(new int[][] {{1, 0, 0}, {1, 1, 0}, {1, 1, 1}}));
        System.out.println(problem3.minSwaps(new int[][] {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1,0,0,0}}));
    }

    public int minSwaps(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int length = grid.length;
        int[] rightZeroCounts = new int[length];
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            int currentRowCount = 0;
            for (int j = length - 1; j >= 0; j--) {
                if (row[j] == 0) {
                    currentRowCount++;
                } else {
                    break;
                }
            }
            rightZeroCounts[i] = currentRowCount;
        }
        int[] copyArray = Arrays.copyOf(rightZeroCounts, length);
        Arrays.sort(copyArray);
        for (int i = 0; i < length; i++) {
            if (copyArray[i] < i) {
                return -1;
            }
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (rightZeroCounts[i] < length - i - 1) {
                for (int j = i + 1; j < length; j++) {
                    if (rightZeroCounts[j] >= length - i - 1) {
                        // swap
                        count += j - i;
                        for (int k = j; k > i; k--) {
                            rightZeroCounts[k] = rightZeroCounts[k - 1];
                        }
                        rightZeroCounts[i] = rightZeroCounts[j];
                        break;
                    }
                }
            }
        }
        return count;
    }
}
