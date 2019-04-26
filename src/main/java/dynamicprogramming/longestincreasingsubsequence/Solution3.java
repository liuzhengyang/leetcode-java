package dynamicprogramming.longestincreasingsubsequence;

/**
 * @author liuzhengyang
 */
public class Solution3 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution3().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println("Cost " + (System.currentTimeMillis() - start));
    }

    private int[] cache;

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        cache = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                cache[i] = 1;
                continue;
            }
            int thisMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    thisMax = Math.max(thisMax, cache[j]);
                }
            }
            cache[i] = thisMax + 1;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, cache[i]);
        }
        return max;
    }
}
