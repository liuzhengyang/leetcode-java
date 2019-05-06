package dynamicprogramming.wordbreak2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        // "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        //["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
        Solution solution = new Solution();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("aa");
        list.add("aaa");
//        list.add("aaaa");
//        list.add("aaaaaa");
//        list.add("aaaaaaa");
//        list.add("aaaaaaaa");
//        list.add("aaaaaaaaa");
//        list.add("aaaaaaaaaa");
        System.out.println(solution.wordBreak("aaa", list));
//        System.out.println(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", list));
    }

    private Map<Integer, List<List<String>>> resultCache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyList();
        }


        List<List<String>> result = splitAt(s, 0, wordDict);
        List<String> joinResult = new ArrayList<>();
        for (List<String> each : result) {
            joinResult.add(String.join(" ", each));
        }
        return joinResult;
    }

    private List<List<String>> splitAt(String s, int index, List<String> wordDict) {
        if (index == s.length()) {
            return Collections.emptyList();
        }
        if (resultCache.get(index) != null) {
            return resultCache.get(index);
        }
        List<List<String>> subResults = new ArrayList<>();
        String substring = s.substring(index);
        for (String w : wordDict) {
            if (substring.startsWith(w)) {
                if (index + w.length() == s.length()) {
                    subResults.add(Collections.singletonList(w));
                } else {
                    List<List<String>> subSplitResults = splitAt(s, index + w.length(), wordDict);
                    List<List<String>> thisResult = new LinkedList<>();
                    for (List<String> subSplitResult : subSplitResults) {
                        List<String> r = new LinkedList<>();
                        r.add(w);
                        r.addAll(subSplitResult);
                        thisResult.add(r);
                    }
                    subResults.addAll(thisResult);
                }

            }
        }
        resultCache.put(index, subResults);
        return subResults;
    }

}
