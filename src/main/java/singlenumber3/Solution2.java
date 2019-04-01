package singlenumber3;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int diff = xor & -xor;
        int first = 0;
        int second = 0;
        for (int num : nums) {
            if ((num & diff) == 0) {
                first ^= num;
            } else {
                second ^= num;
            }
        }
        return new int[]{first, second};
    }
}
