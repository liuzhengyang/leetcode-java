package dynamicprogramming.maxproductsubarray;

public class Solution {
    public static void main(String[] args) {

    }

    private Range[] cache;

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        cache = new Range[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            Range r = maxRangeAtIndex(nums, i);
            max = Math.max(r.max, max);
        }
        return max;
    }

    private Range maxRangeAtIndex(int[] nums, int index) {
        if (index == nums.length - 1) {
            return Range.of(nums[index], nums[index]);
        }
        if (cache[index] != null) {
            return cache[index];
        }
        Range result;
        Range notProductNextRange = Range.of(nums[index], nums[index]);
        Range nextRange = maxRangeAtIndex(nums, index + 1);
        int min = Math.min(nums[index] * nextRange.min, nums[index] * nextRange.max);
        int max = Math.max(nums[index] * nextRange.min, nums[index] * nextRange.max);
        result = Range.of(Math.min(notProductNextRange.min, min), Math.max(max, notProductNextRange.max));
        cache[index] = result;
        return result;
    }

    private static class Range {
        int min;
        int max;

        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public static Range of(int min, int max) {
            return new Range(min, max);
        }
    }
}
