package dynamicprogramming.deleteandearn;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    private int[] cache;

    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        cache = new int[nums.length];
        return 0;
    }

    private int deleteAt(int[] nums, int i) {
        if (i == nums.length) {
            return 0;
        }
        return 0;
    }
}
