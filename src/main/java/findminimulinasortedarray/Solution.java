package findminimulinasortedarray;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE - 1 + Integer.MAX_VALUE - 1 >>> 1);
        System.out.println(Integer.MAX_VALUE);
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{4,5,6,7,0,1,2}));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int from, int to) {
        if (from > to) {
            return -1;
        }
        if (from == to) {
            return nums[from];
        }
        int mid = from + to >>> 1;
        if (nums[mid] < nums[to]) {
            if (mid > from) {
                return Math.min(nums[mid], findMin(nums, from, mid - 1));
            }
            return Math.min(nums[from], nums[mid]);
        } else {
            if (mid + 1 <= to) {
                return Math.min(nums[from], findMin(nums, mid + 1, to));
            }
            return Math.min(nums[from], nums[to]);
        }
    }
}
