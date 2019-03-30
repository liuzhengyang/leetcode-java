package p646;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        new Solution().rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        if (k > nums.length) {
            k %= nums.length;
        }
        rotatePart(nums, 0, nums.length - k - 1);
        rotatePart(nums, nums.length - k, nums.length - 1 );
        rotatePart(nums, 0, nums.length - 1);
    }

    private void rotatePart(int[] nums, int from, int to) {
        int i = from;
        int j = to;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i ++;
            j --;
        }
    }
}
