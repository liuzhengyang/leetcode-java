package findfirstandlastpositionofelementofsortedarray;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1, 2, 3}, 2)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        int min = searchMin(nums, 0, nums.length - 1, target);
        int max = searchMax(nums, 0, nums.length - 1, target);
        return new int[]{min, max};
    }

    private int searchMax(int[] nums, int from, int end, int target) {
        if (from > end) {
            return -1;
        }
        if (from == end) {
            return nums[from] == target ? from : -1;
        }
        int mid = from + end >>> 1;
        if (nums[mid] <= target) {
            return nums[mid] == target ? Math.max(mid, searchMax(nums, mid + 1, end, target)) :
                    searchMax(nums, mid + 1, end, target);
        } else {
            return searchMax(nums, from, mid - 1, target);
        }
    }

    private int searchMin(int[] nums, int from, int end, int target) {
        if (from > end) {
            return -1;
        }
        if (from == end) {
            return nums[from] == target ? from : -1;
        }
        int mid = from + end >>> 1;

        if (nums[mid] == target) {
            int pos = searchMin(nums, from, mid - 1, target);
            return pos >= 0 ? pos : mid;
        }
        if (nums[mid] > target) {
            return searchMin(nums, from, mid - 1, target);
        } else {
            return searchMin(nums, mid + 1, end, target);
        }
    }

}
