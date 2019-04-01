package singlenumber3;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().bitIndexOfFirstNonZero(4));
        System.out.println(new Solution().isBitOneAtIndex(3, 1));
        System.out.println(new Solution().isBitOneAtIndex(3, 0));
        System.out.println(new Solution().isBitOneAtIndex(4, 0));
        System.out.println(new Solution().isBitOneAtIndex(4, 1));
        System.out.println(new Solution().isBitOneAtIndex(4, 2));
        System.out.println(Arrays.toString(new Solution().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int firstNum = 0;
        int secondNum = 0;
        int firstNonZero = bitIndexOfFirstNonZero(xor);
        for (int num : nums) {
            if (isBitOneAtIndex(num, firstNonZero)) {
                firstNum ^= num;
            } else {
                secondNum ^= num;
            }
        }

        return new int[]{firstNum, secondNum};
    }

    private int bitIndexOfFirstNonZero(int num) {
        int index = 0;
        while(num % 2 ==0) {
            num /= 2;
            index ++;
        }
        return index;
    }

    private boolean isBitOneAtIndex(int num, int index) {
        int i = num >>> index;
        return i % 2 != 0;
    }
}
