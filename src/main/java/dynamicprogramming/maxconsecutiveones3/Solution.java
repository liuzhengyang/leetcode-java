package dynamicprogramming.maxconsecutiveones3;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(solution.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

    private int[][] cache;

    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }

        cache = new int[A.length][K + 1];
        for (int i = 0; i < A.length; i++) {
            cache[i] = new int[K + 1];
            Arrays.fill(cache[i], -1);
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, findMaxAt(A, i, K));
        }

        return max;
    }

    private int findMaxAt(int[] A, int i, int leftOnes) {
        if (i == A.length) {
            return 0;
        }
        if (cache[i][leftOnes] > -1) {
            return cache[i][leftOnes];
        }
        int result;
        if (leftOnes == 0) {
            result = A[i] == 0 ? 0 : 1 + findMaxAt(A, i + 1, leftOnes);
        } else if (A[i] == 1) {
            result = 1 + findMaxAt(A, i + 1, leftOnes);
        } else {
            result = 1 + findMaxAt(A, i + 1, leftOnes - 1);
        }
        cache[i][leftOnes] = result;
        return result;
    }
}
