package weekly.contest.biweek32;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Problem4 {
    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        System.out.println(problem4.longestAwesome("3242415"));
        System.out.println(problem4.longestAwesome("12345678"));
        System.out.println(problem4.longestAwesome("213123"));
        System.out.println(problem4.longestAwesome("00"));
    }

    /**
     * dp
     * @param s
     * @return
     */
    public int longestAwesome(String s) {
        char[] chars = s.toCharArray();
        // 奇数数量最多只有一个
        int[][] charCountMap = new int[chars.length][];

        for (int i = chars.length - 1; i >= 0; i--) {
            int val = chars[i] - '0';
            if (i < chars.length - 1) {
                int[] charCount = Arrays.copyOf(charCountMap[i + 1], 10);
                charCount[val] += 1;
                charCountMap[i] = charCount;
            } else {
                int[] charCount = new int[10];
                charCount[val] += 1;
                charCountMap[i] = charCount;
            }
        }

        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                int[] countI = charCountMap[i];
                int oddCount = 0;
                if (j + 1 >= chars.length) {
                    for (int k = 0; k < countI.length; k++) {
                        if ((countI[k] & 1) == 1) {
                            oddCount ++;
                        }
                    }
                } else {
                    int[] countJ = charCountMap[j + 1];
                    for (int k = 0; k < countI.length; k++) {
                        if (((countI[k] - countJ[k]) & 1) == 1) {
                            oddCount ++;
                        }
                    }
                }

                if (oddCount <= 1) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }
}
