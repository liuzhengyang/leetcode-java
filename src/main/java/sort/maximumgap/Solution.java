package sort.maximumgap;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumGap(new int[]{3,6,9,1}));
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i + 1] - nums[i]);
        }
        return max;
    }
}
