package maximumsubarray;

/**
 * @author liuzhengyang
 */
public class Solution1 {
    // -2,1,-3,4,-1,2,1,-5,4
    public static void main(String[] args) {
        System.out.println(new Solution1().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findMaxSubArray(nums, 0, nums.length - 1);
    }

    private int findMaxSubArray(int[] nums, int from, int to) {
        if (from > to) {
            return 0;
        }
        if (from == to) {
            return nums[from];
        }
        int mid = (to - from) / 2 + from;

        int maxAcrossMidRight = nums[mid + 1];
        int sumRight = 0;
        for (int i = mid + 1; i <= to; i++) {
            sumRight += nums[i];
            if (maxAcrossMidRight < sumRight) {
                maxAcrossMidRight = sumRight;
            }
        }
        int maxAcrossMidLeft = nums[mid];
        int sumLeft = 0;
        for (int i = mid; i >= from; i--) {
            sumLeft += nums[i];
            if (maxAcrossMidLeft < sumLeft) {
                maxAcrossMidLeft = sumLeft;
            }
        }
        int maxInLeft = findMaxSubArray(nums, from, mid);
        int maxInRight = findMaxSubArray(nums, mid + 1, to);
        return maxOf3(maxInLeft, maxInRight, maxAcrossMidLeft + maxAcrossMidRight);
    }


    private int maxOf3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

}
