package array.partitionarrayintothreepartswithequalssum;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        System.out.println(solution.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        System.out.println(solution.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
    }

    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int sum = 0;
        for (int n : A) {
            sum += n;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int eachSum = sum / 3;
        int totalCount = 3;
        long currentSum = 0;
        int currentCount = 0;
        for (int i = 0; i < A.length; i++) {
            currentSum += A[i];
            if (currentSum == eachSum) {
                currentCount++;
                currentSum = 0;
            }
        }
        return currentCount == totalCount;
    }
}
