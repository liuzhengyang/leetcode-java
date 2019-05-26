package array.grumpybookstoreowner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        if (customers == null || customers.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
        }
        int maxSum = sum;
        for (int i = 0; i + X < customers.length; i++) {
            if (grumpy[i + X] == 1) {
                sum += customers[i + X];
            }
            if (grumpy[i] == 1) {
                sum -= customers[i];
            }
            maxSum = Math.max(maxSum, sum);
        }
        int maxSatifiedSum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                maxSatifiedSum += customers[i];
            }
        }
        return maxSatifiedSum + maxSum;
    }
}
