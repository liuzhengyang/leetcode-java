package p5;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * @author liuzhengyang
 */
public class Solution {
    public String longestPalindrome(String s) {
        return new String(longestParlidromeArray(s.toCharArray()));
    }

    public char[] longestParlidromeArray(char[] input) {
        if (input.length == 0 || input.length == 1) {
            return input;
        }
        char[] sub = longestParlidromeArray(Arrays.copyOf(input, input.length - 1));
        char lastChar = input[input.length - 1];
        int maxLength = 0;
        for (int i = 0; i < input.length - 1; i++) {
            boolean success = true;
            for (int j = i, k = input.length - 1; j < k; j++, k --) {
                if (input[j] != input[k]) {
                    success = false;
                    break;
                }
            }
            if (success) {
                maxLength = input.length - i;
                break;
            }
        }
        if (sub.length >= maxLength) {
            return sub;
        } else {
            return Arrays.copyOfRange(input, input.length - maxLength, input.length);
        }
    }

}
