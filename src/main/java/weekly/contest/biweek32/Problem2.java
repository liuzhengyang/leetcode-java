package weekly.contest.biweek32;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Problem2 {
    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(problem2.canConvertString("input", "ouput", 9));
        System.out.println(problem2.canConvertString("abc", "bcd", 10));
        System.out.println(problem2.canConvertString("aab", "bbb", 27));
    }

    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] diffTable = new int[26];
        char[] fromCharArray = s.toCharArray();
        char[] toCharArray = t.toCharArray();
        for (int i = 0; i < fromCharArray.length; i++) {
            int diff = toCharArray[i] - fromCharArray[i];
            if (diff < 0) {
                diff += 26;
            }
            diffTable[diff] += 1;
        }
        System.out.println(Arrays.toString(diffTable));
        for (int i = 1; i < diffTable.length; i++) {
            if (diffTable[i] > 0) {
                if ((diffTable[i] - 1) * 26 + i > k) {
                    return false;
                }
            }
        }
        return true;
    }
}
