package dynamicprogramming.largestsumofaverages;

/**
 * @author liuzhengyang
 */
public class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        if (A == null || K == 0) {
            return 0;
        }
        cache = new Double[A.length];
        return largestSum(A, 0, K);
    }

    private Double[] cache;

    private double largestSum(int[] A, int index, int K) {
        if (index == A.length) {
            return 0;
        }
        if (cache[index] != null) {
            return cache[index];
        }

        double max = Double.MIN_VALUE;
        long currentPartSum = 0;
        for (int i = index; i < index + K; i++) {
            if (i >= A.length) {
                break;
            }
            currentPartSum += A[i];
            max = Math.max(currentPartSum * 1.0 / (i - index + 1) + largestSum(A, i + 1, K),
                    max);
        }
        cache[index] = max;
        return max;
    }
}
