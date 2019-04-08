package searchinarotatedsortedarray;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
//        int[] nums = new int[]{5, 6, 7, 0, 1, 2, 3, 4};
//        int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums = new int[]{1};
        System.out.println(new Solution().findBreakPoint(nums, 0, nums.length - 1));
        System.out.println(new Solution().search(nums, 11));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        if (nums[0] < nums[nums.length - 1]) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        int breakPoint = findBreakPoint(nums, 0, nums.length - 1);
        int index = binarySearch(nums, breakPoint, nums.length - 1 + breakPoint, target);
        return index < 0 ? index : index >= nums.length ? index - nums.length : index;
    }

    private int findBreakPoint(int[] nums, int from, int to) {
        if (from > to) {
            return -1;
        }
        int mid = from + (to - from) / 2;
        if (mid > 0 && nums[mid - 1] > nums[mid]) {
            return mid;
        }
        if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
            return mid + 1;
        }
        if (nums[from] > nums[mid]) {
            return findBreakPoint(nums, from, mid - 1);
        } else {
            return findBreakPoint(nums, mid + 1, to);
        }
    }

    private int binarySearch(int[] nums, int from, int to, int val) {
        if (from > to) {
            return -1;
        }
        int mid = from + (to - from) / 2;
        if (val == valueOf(nums, mid)) {
            return mid >= nums.length ? mid - nums.length : mid;
        } else if (val < valueOf(nums, mid)) {
            return binarySearch(nums, from, mid - 1, val);
        } else {
            return binarySearch(nums, mid + 1, to, val);
        }
    }

    private int valueOf(int[] nums, int index) {
        if (index >= nums.length) {
            index -= nums.length;
        }
        return nums[index];
    }
}
