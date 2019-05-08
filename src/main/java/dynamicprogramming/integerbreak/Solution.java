package dynamicprogramming.integerbreak;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerBreak(2));
        System.out.println(solution.integerBreak(10));
    }

    private int[] cache;

    public int integerBreak(int n) {
        cache = new int[n + 1];
        return doIntegerBreak(n);
    }

    private int doIntegerBreak(int n) {
        if (n == 1) {
            return 1;
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * (Math.max(n - i, doIntegerBreak(n - i))));
        }
        cache[n] = max;
        return max;
    }
}
