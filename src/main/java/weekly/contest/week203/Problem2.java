package weekly.contest.week203;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/contest/weekly-contest-203/problems/maximum-number-of-coins-you-can-get/
 * @author liuzhengyang
 */
public class Problem2 {
    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(problem2.maxCoins(new int[]{2,4,1,2,7,8}));
    }

    public int maxCoins(int[] piles) {
        if (piles == null || piles.length == 0) {
            return 0;
        }
        Arrays.sort(piles);
        int left = 0;
        int right = piles.length - 1;
        int result = 0;
        while (left < right) {
            left ++;
            right --;
            result += piles[right];
            right --;
        }
        return result;
    }
}
