package basic;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuzhengyang
 */
public class NumSplits {
    public static void main(String[] args) {
        NumSplits numSplits = new NumSplits();
        System.out.println(numSplits.numSplits("aacaba"));
        System.out.println(numSplits.numSplits("abcd"));
        System.out.println(numSplits.numSplits("aaaaa"));
        System.out.println(numSplits.numSplits("acbadbaada"));
    }
    public int numSplits(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        Set<Integer> totalChars = new HashSet<>();
        int[] charCount = new int[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            int charValue = c - 'a';
            if (charCount[charValue] == 0) {
                totalChars.add(charValue);
            }
            charCount[charValue] += 1;
        }
        int[] leftCharCount = new int[26];
        int totalDistinctChars = totalChars.size();
        int index = 0;
        int leftCount = 0;
        int rightCount = totalDistinctChars;
        int totalCount = 0;
        while (index < charArray.length) {
            int charValue = charArray[index] - 'a';
            leftCharCount[charValue] += 1;
            charCount[charValue] -= 1;
            if (leftCharCount[charValue] == 1) {
                leftCount++;
            }
            if (charCount[charValue] == 0) {
                rightCount--;
            }
            if (leftCount == rightCount) {
                totalCount++;
            }
            index++;
        }
        return totalCount;
    }
}
