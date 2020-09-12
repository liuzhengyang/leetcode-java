package weekly.final2020;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Problem3 {
    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.minimumOperations("ryr"));
        System.out.println(problem3.minimumOperations("yyyyyr"));
        System.out.println(problem3.minimumOperations("yrrry"));
        System.out.println(problem3.minimumOperations("yyy"));
        System.out.println(problem3.minimumOperations("rrryyyrryyyrr"));
    }

    public int minimumOperations2(String leaves) {
        if (leaves == null || leaves.length() == 0) {
            return 0;
        }
        int yellowCount = 0;
        char[] chars = leaves.toCharArray();
        for (char c : chars) {
            if (c == 'y') {
                yellowCount ++;
            }
        }
        if (yellowCount == 0) {
            return 0;
        }
        int maxYellowCountInThisRange = 0;
        int lastYellowCount = 0;
        for (int i = 1; i < chars.length - yellowCount; i++) {
            if (i == 1) {
                for (int j = 0; j < yellowCount; j++) {
                    if (chars[i + j] == 'y') {
                        lastYellowCount ++;
                    }
                }
            } else {
                if (chars[i - 1] == 'y') {
                    lastYellowCount --;
                }
                if (chars[i] == 'y') {
                    lastYellowCount ++;
                }
            }
            maxYellowCountInThisRange = Math.max(maxYellowCountInThisRange, lastYellowCount);
        }
        return yellowCount - maxYellowCountInThisRange;
    }

    public int minimumOperations(String leaves) {
        if (leaves == null || leaves.length() < 3) {
            return 0;
        }
        char[] chars = leaves.toCharArray();
        int[][][] cache = new int[2][2][chars.length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                cache[i][j] = new int[chars.length];
                Arrays.fill(cache[i][j], -1);
            }
        }
        return f(chars, 0, false, false, cache);
    }


    private int f(char[] chars, int i, boolean prevIsYellow, boolean hasYellowBefore, int[][][] cache) {
        if (cache[prevIsYellow ? 1 : 0][hasYellowBefore? 1 : 0][i] > -1) {
            return cache[prevIsYellow ? 1 : 0][hasYellowBefore? 1 : 0][i];
        }
        if (i == chars.length - 1) {
            if (prevIsYellow) {
                return chars[i] == 'y' ? 1 : 0;
            } else {
                if (hasYellowBefore) {
                    return chars[i] == 'y' ? 1 : 0;
                } else {
                    return 1 + (chars[i] == 'y' ? 1 : 0);
                }
            }
        }
        if (i == 0) {
            return (chars[i] == 'y' ? 1 : 0) + f(chars, i + 1, false, false, cache);
        }
        if (prevIsYellow) {
            // red
            int first = (chars[i] == 'y' ? 1 : 0) + f(chars, i + 1, false, true, cache);
            // yellow
            int yellow = (chars[i] == 'y' ? 0 : 1) + f(chars, i + 1, true, true, cache);
            int result = Math.min(first, yellow);
            cache[1][0][i] = result;
            cache[1][1][i] = result;
            return result;
        } else {
            if (hasYellowBefore) {
                int result = (chars[i] == 'y' ? 1 : 0) + f(chars, i + 1, false, true, cache);
                cache[0][1][i] = result;
                return result;
            } else {
                int red = (chars[i] == 'y' ? 1 : 0) + f(chars, i + 1, false, false, cache);
                int yellow = (chars[i] == 'y' ? 0 : 1) + f(chars, i + 1, true, true, cache);
                int result = Math.min(red, yellow);
                cache[0][0][i] = result;
                return result;
            }
        }
    }
}
