package dynamicprogramming.countingbits;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countBits(10)));
    }

    private int[] cache;

    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        cache = new int[num + 1];
        for (int i = num; i >= 1; i--) {
            if (cache[i] == 0) {
                count(i);
            }
        }

        return cache;
    }

    private int count(int n) {
        if (n == 0) {
            return 0;
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        boolean odd = (n & 0x01) == 1;
        int result = odd ? count(n >> 1) + 1 : count(n >> 1);
        cache[n] = result;
        return result;
    }
}
