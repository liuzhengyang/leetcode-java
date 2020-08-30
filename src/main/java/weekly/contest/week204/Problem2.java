package weekly.contest.week204;

/**
 * https://leetcode-cn.com/contest/weekly-contest-204/problems/maximum-length-of-subarray-with-positive-product/
 * @author liuzhengyang
 */
public class Problem2 {
    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(problem2.getMaxLen(new int[]{0,1,-2,-3,-4}));
    }

    public int getMaxLen(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int negativeCount = 0;
            int firstNegativeIndex = -1;
            int lastNegativeIndex = -1;
            int lastJIndex = 0;
            for (int j = i; j < nums.length && nums[j] != 0; j++) {
                if (nums[j] < 0) {
                    negativeCount ++;
                    if (firstNegativeIndex == -1) {
                        firstNegativeIndex = j;
                    }
                    lastNegativeIndex = j;
                }
                lastJIndex = j;
            }
            if (negativeCount % 2 == 0) {
                max = Math.max(max, lastJIndex - i + 1);
            } else {
                max = Math.max(max, lastNegativeIndex - 1 - i + 1);
                max = Math.max(max, lastJIndex - (firstNegativeIndex + 1) + 1);
            }
            i = lastJIndex + 1;
        }
        return max;
    }
}
