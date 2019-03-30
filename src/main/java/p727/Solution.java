package p727;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = new Solution().removeDuplicates(arr);
        System.out.println(i);
        System.out.println(Arrays.toString(arr));
    }
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int putIndex = 0, scanIndex = 0;
        int lastNum = nums[0];
        while (true) {
            scanIndex ++;
            if (scanIndex >= nums.length) {
                break;
            }
            if (nums[scanIndex] > lastNum) {
                nums[++putIndex] = nums[scanIndex];
                lastNum = nums[scanIndex];
            }
        }
        return putIndex + 1;
    }
}
