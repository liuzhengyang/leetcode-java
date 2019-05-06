package dynamicprogramming.wordbreak;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        System.out.println(solution.wordBreak("catsandog", list));
    }

    // 2: can break; 1: can not break
    private int[] resultCache;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null && s.isEmpty()) {
            return false;
        }
        resultCache = new int[s.length()];
        return wordBreak(s, 0, wordDict);
    }


    private boolean wordBreak(String s, int index, List<String> wordDict) {
        if (index == s.length()) {
            return true;
        }
        if (resultCache[index] == 2) {
            return true;
        }
        if (resultCache[index] == 1) {
            return false;
        }
        boolean thisResult = false;
        for (int i = 0; i < wordDict.size(); i++) {
            if (s.substring(index).startsWith(wordDict.get(i))) {
                boolean subBreak = wordBreak(s, index + wordDict.get(i).length(), wordDict);
                thisResult |= subBreak;
            }
        }

        resultCache[index] = thisResult ? 2 : 1;
        return thisResult;
    }
}
