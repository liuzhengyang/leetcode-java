package besttimetobuyandsellstock;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(array));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        transformIncrement(prices);
        return maxSumOfSubArray(prices, 0 , prices.length - 1);
    }

    private void transformIncrement(int[] prices) {
        for (int i = prices.length - 1; i >= 0; i--) {
            prices[i] = i > 0 ? prices[i] - prices[i - 1] : 0;
        }
    }

    private int maxSumOfSubArray(int[] nums, int from, int to) {
        if (from > to) {
            return 0;
        }
        if (from == to) {
            return nums[from];
        }
        int mid = from + (to - from) / 2;
        int maxSum = 0;
        int sum = 0;
        for (int i = mid; i >= from; i--) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        int maxSumRight = 0;
        sum = 0;
        if (mid + 1 <= to) {
            for (int i = mid + 1; i <= to; i++) {
                sum += nums[i];
                if (maxSumRight < sum) {
                    maxSumRight = sum;
                }
            }
        }
        return maxOf3(maxSumOfSubArray(nums, from, mid), maxSumOfSubArray(nums, mid + 1, to),
                maxSum + maxSumRight);
    }

    private int maxOf3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
