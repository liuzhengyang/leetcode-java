package array.maxconsecutiveones;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int maxConsecutiveOnes = solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 0, 1, 1, 1});
        System.out.println(maxConsecutiveOnes);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 0;
        int consecutive = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                consecutive ++;
                max = Math.max(max, consecutive);
            } else {
                consecutive = 0;
            }
        }
        return max;
    }
}
