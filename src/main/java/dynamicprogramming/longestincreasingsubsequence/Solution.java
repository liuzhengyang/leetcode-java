package dynamicprogramming.longestincreasingsubsequence;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println("Cost " + (System.currentTimeMillis() - start));
    }

    private int[][] cache;

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        cache = new int[nums.length + 1][];
        for (int i = 0; i < nums.length + 1; i++) {
            cache[i] = new int[nums.length + 1];
            for (int j = 0; j < nums.length + 1; j++) {
                cache[i][j] = -1;
            }
        }

        return lengOfLISRecursive(nums, nums.length - 1, nums.length);
    }


    private int lengOfLISRecursive(int[] nums, int curretnIndex, int lastNumIndex) {
        if (cache[curretnIndex][lastNumIndex] > -1) {
            return cache[curretnIndex][lastNumIndex];
        }
        if (curretnIndex == 0) {
            if (lastNumIndex == nums.length) {
                cache[curretnIndex][lastNumIndex] = 1;
                return 1;
            } else {
                int result = nums[curretnIndex] < nums[lastNumIndex] ? 1 : 0;
                cache[curretnIndex][lastNumIndex] = result;
                return result;
            }
        } else {
            if (lastNumIndex == nums.length || nums[curretnIndex] < nums[lastNumIndex]) {
                int result = Math.max(lengOfLISRecursive(nums, curretnIndex - 1, curretnIndex) + 1,
                        lengOfLISRecursive(nums, curretnIndex - 1, lastNumIndex));
                cache[curretnIndex][lastNumIndex] = result;
                return result;
            } else {
                int result = lengOfLISRecursive(nums, curretnIndex - 1, lastNumIndex);
                cache[curretnIndex][lastNumIndex] = result;
                return result;
            }
        }
    }
}
