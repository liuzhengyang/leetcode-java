package array.maximizesumofarrayafterknegation;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        System.out.println(solution.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println(solution.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
        System.out.println(solution.largestSumAfterKNegations(new int[]{-2, 9, 9, 8, 4}, 5));
        System.out.println(solution.largestSumAfterKNegations(new int[]{-8, 3, -5, -3, -5, -2}, 6));
    }

    public int largestSumAfterKNegations(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int negativeCount = 0;
        int firstNonNegativeIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                negativeCount++;
            } else {
                firstNonNegativeIndex = i;
                break;
            }
        }
        if (negativeCount >= K) {
            int sum = 0;
            for (int i = 0; i < K; i++) {
                sum += -A[i];
            }
            for (int i = K; i < A.length; i++) {
                sum += A[i];
            }
            return sum;
        } else {
            int sum = 0;
            for (int i = 0; i < negativeCount; i++) {
                sum += -A[i];
            }
            for (int i = negativeCount; i < A.length; i++) {
                if (i == firstNonNegativeIndex && (K - negativeCount) % 2 == 1) {
                    int minMinus;
                    if (i > 0) {
                        minMinus = Math.max(A[i] + 2 * A[i - 1], - A[i]);
                    } else {
                        minMinus = -A[i];
                    }
                    sum += minMinus;
                } else {
                    sum += A[i];
                }
            }
            return sum;
        }
    }
}
