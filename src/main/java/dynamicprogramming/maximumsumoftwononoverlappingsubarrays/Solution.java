package dynamicprogramming.maximumsumoftwononoverlappingsubarrays;

public class Solution {
    public static void main(String[] args) {
        // [0,6,5,2,2,5,1,9,4]
        //1
        //2
        Solution solution = new Solution();
        System.out.println(solution.maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3));
        System.out.println(solution.maxSumTwoNoOverlap(new int[]{0,6,5,2,2,5,1,9,4}, 1, 2));
    }

    private int[] leftCache;
    private int[] rightCache;

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        if (A == null || A.length == 0 || A.length < L + M) {
            return 0;
        }
        leftCache = new int[A.length];
        rightCache = new int[A.length];

        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < L; i++) {
            sumLeft += A[i];
        }
        for (int i = 0; i < M; i++) {
            sumRight += A[i];
        }
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                leftCache[i] = sumLeft;
                rightCache[i] = sumRight;
            } else {
                if (i < A.length - L + 1) {
                    sumLeft += A[i + L - 1];
                    sumLeft -= A[i - 1];
                    leftCache[i] = sumLeft;
                }
                if (i < A.length - M + 1) {
                    sumRight += A[i + M - 1];
                    sumRight -= A[i - 1];
                    rightCache[i] = sumRight;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < A.length - L + 1; i++) {
            for (int j = 0; j + M - 1 < i; j++) {
                max = Math.max(max, leftCache[i] + rightCache[j]);
            }
            for (int j = i + L; j < A.length - M + 1; j++) {
                max = Math.max(max, leftCache[i] + rightCache[j]);
            }
        }
        return max;
    }
}
