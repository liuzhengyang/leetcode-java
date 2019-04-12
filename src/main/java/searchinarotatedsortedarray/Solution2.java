package searchinarotatedsortedarray;

/**
 * @author liuzhengyang
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,0,1,2};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.search(arr, 2));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int from, int to, int target) {
        if (from > to) {
            return -1;
        }
        if (from == to) {
            return nums[from] == target ? from : -1;
        }
        int mid = from + to >>> 1;
        if (nums[mid] == target) {
            return mid;
        }
        if (target > nums[mid]) {
            if (nums[to] > nums[mid] && nums[to] >= target) {
                return binarySearch(nums, mid + 1, to, target);
            }

        }
        if (nums[to] > nums[mid]) {
            return target > nums[mid] && target <= nums[to] ? binarySearch(nums, mid + 1, to,
                    target) : binarySearch(nums, from, to - 1, target);
        } else {
            return target < nums[mid] && target >= nums[from] ? binarySearch(nums, from, mid - 1,
                    target) : binarySearch(nums, mid + 1, to, target);
        }
    }
}
