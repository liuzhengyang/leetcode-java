package firstuniquechar;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("leetcode"));
        System.out.println(new Solution().firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        int[] charTable = new int[26];
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            // not seen
            if (charTable[index] == 0) {
                charTable[index] = i + 1;
            } else if (charTable[index] > 0) {
                // repeated
                charTable[index] = -1;
            }
        }
        int minOfNonRepeated = -1;
        for (int i : charTable) {
            if (i > 0 && (minOfNonRepeated == -1 || minOfNonRepeated > i)) {
                minOfNonRepeated = i;
            }
        }
        return minOfNonRepeated > 0 ? minOfNonRepeated - 1 : - 1;
    }
}
