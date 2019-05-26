package array.maxconsecutiveones;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int maxConsecutiveOnes = solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 0, 1, 1, 1});
        System.out.println(maxConsecutiveOnes);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 0;
        int consecutive = 0;
        boolean prevIsOne = false;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                if (prevIsOne) {
                } else {
                    prevIsOne = true;
                }
                consecutive ++;
                max = Math.max(consecutive, max);
            } else {
                prevIsOne = false;
                consecutive = 0;
            }
        }
        return max;
    }
}
