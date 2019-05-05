package dynamicprogramming.rangesumquery;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }
}

class NumArray {
    private long[] sumCache;
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        if (nums != null) {
            sumCache = new long[nums.length];
            long sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sumCache[i] = sum;
            }
        }

    }

    public int sumRange(int i, int j) {
        if (sumCache == null) {
            return 0;
        }
        return (int) (sumCache[j] - sumCache[i]) + nums[i];
    }
}
