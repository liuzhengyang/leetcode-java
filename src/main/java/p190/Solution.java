package p190;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return buildByBits(parseBits(n));
    }

    private int[] parseBits(int n) {
        int[] bits = new int[32];
        for (int i = 0; i < bits.length; i++) {
            bits[i] = Math.abs((n & (1 << i)) >> i);
        }
        return bits;
    }

    private int buildByBits(int[] n) {
        int result = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] == 1) {
                result |= 1 << (31 - i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(0b10000000000000000000000000000000));
        int[] bits = new Solution().parseBits(43261596);
        System.out.println(Arrays.toString(new Solution().parseBits(43261596)));
        System.out.println(new Solution().buildByBits(bits));
        System.out.println();
        System.out.println(-127 & 1);
        System.out.println(-127 & 2);
        System.out.println(-127 & 4);
        System.out.println(-127 & 8);
        System.out.println(-127 & 16);
        System.out.println(-127 & 32);
        System.out.println(-127 & 64);
        System.out.println(-127 & 128);
        String s = Integer.toBinaryString(127);
        System.out.println(s);
        System.out.println(Integer.toBinaryString(-127));
    }
}
