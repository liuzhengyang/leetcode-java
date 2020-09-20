package weekly.contest.week207;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
 * @author liuzhengyang
 */
public class Problem2 {
    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(problem2.maxUniqueSplit("ababccc"));
        System.out.println(problem2.maxUniqueSplit("aba"));
        System.out.println(problem2.maxUniqueSplit("aa"));
    }

    public int maxUniqueSplit(String s) {
        return maxSplit(s, new HashSet<>(), 0, 0);
    }

    private int maxSplit(String s, Set<String> existChars, int lastIndex, int i) {
        if (i == s.length()) {
            return 0;
        }
        // split here
        int splitHere = 0;
        String substring = s.substring(lastIndex, i + 1);
        if (existChars.contains(substring)) {
            splitHere = -1;
        } else {
            splitHere = 1;
            Set<String> newExists = new HashSet<>();
            newExists.add(substring);
            newExists.addAll(existChars);
            int leftMaxSplit = maxSplit(s, newExists, i + 1, i + 1);
            if (leftMaxSplit == -1) {
                splitHere = -1;
            } else {
                splitHere += leftMaxSplit;
            }
        }
        int notSplitHere = maxSplit(s, existChars, lastIndex, i + 1);
        return Math.max(splitHere, notSplitHere);
    }
}
