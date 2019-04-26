package dynamicprogramming.longestincreasingsubsequence;

/**
 * @author liuzhengyang
 */
public class Solution2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution2().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println("Cost " + (System.currentTimeMillis() - start));
    }

    private int[] cache;

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        cache = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, longestIncreasingSubsequenceIncludingIndex(nums, i));
        }
        return max;
    }

    /**
     *
     * @param index
     * @return
     */
    private int longestIncreasingSubsequenceIncludingIndex(int[] nums, int index) {
        if (cache[index] > 0) {
            return cache[index];
        }
        if (index == 0) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < index; i++) {
            if (nums[i] < nums[index] && longestIncreasingSubsequenceIncludingIndex(nums, i) > max) {
                max = longestIncreasingSubsequenceIncludingIndex(nums, i);
            }
        }
        cache[index] = max + 1;
        return max + 1;
    }
}
