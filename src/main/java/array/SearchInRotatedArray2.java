package array;

/**
 * @author liuzhengyang
 */
public class SearchInRotatedArray2 {
    public static void main(String[] args) {
        int[] array = new int[]{1,1,3,1};
        boolean search = new SearchInRotatedArray2().search(array, 3);
        System.out.println(search);
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        return doBinarySearch(nums, 0, nums.length - 1, target);
    }

    private boolean doBinarySearch(int[] nums, int from, int to, int target) {
        if (from > to) {
            return false;
        }
        if (from == to) {
            return nums[from] == target;
        }
        int mid = from + to >>> 1;
        int midVal = nums[mid];
        if (midVal == target) {
            return true;
        }
        if (midVal < target) {
            if (target < nums[to]) {
                return doBinarySearch(nums, mid + 1, to, target);
            } else {
                return doBinarySearch(nums, from, mid - 1, target) || doBinarySearch(nums, mid + 1, to, target);
            }
        } else {
            if (target >= nums[from]) {
                return doBinarySearch(nums, from, mid - 1, target);
            } else {
                return doBinarySearch(nums, mid + 1, to, target) || doBinarySearch(nums, from, mid - 1, target);
            }
        }
    }
}
