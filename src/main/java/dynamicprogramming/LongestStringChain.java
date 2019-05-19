package dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liuzhengyang
 */
public class LongestStringChain {
    public static void main(String[] args) {
        LongestStringChain longestStringChain = new LongestStringChain();
        System.out.println(longestStringChain.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }

    int[] result;

    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        result = new int[words.length];
        Arrays.fill(result, -1);
        Map<Integer, Set<Integer>> lengthToIndexMap = new LinkedHashMap<>();
        Map<Integer, Set<Integer>> indexToAppendIndexMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            lengthToIndexMap.computeIfAbsent(words[i].length(), l -> new HashSet<>()).add(i);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : lengthToIndexMap.entrySet()) {
            Integer key = entry.getKey();
            Set<Integer> indexes = entry.getValue();
            Set<Integer> nextIndexes = lengthToIndexMap.get(key + 1);
            if (nextIndexes == null || nextIndexes.isEmpty()) {
                continue;
            }
            for (int index : indexes) {
                for (int nextIndex : nextIndexes) {
                    if (canAppendTo(words[index], words[nextIndex])) {
                        indexToAppendIndexMap.computeIfAbsent(index, i -> new HashSet<>()).add(nextIndex);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            max = Math.max(max, findMaxLength(words, i, indexToAppendIndexMap));
        }
        return max + 1;
    }

    private int findMaxLength(String[] words, int i,
            Map<Integer, Set<Integer>> indexToAppendIndexMap) {
        if (i == words.length) {
            return 0;
        }
        if (result[i] > -1) {
            return result[i];
        }
        Set<Integer> nexts = indexToAppendIndexMap.get(i);
        if (nexts == null || nexts.isEmpty()) {
            return 0;
        }
        int thisResult = 0;
        for (int index : nexts) {
            thisResult = Math.max(thisResult, findMaxLength(words, index, indexToAppendIndexMap));
        }
        thisResult += 1;
        result[i] = thisResult;
        return thisResult;
    }

    private boolean canAppendTo(String first, String second) {
        if (first.length() + 1 == second.length()) {
            boolean different = false;
            int i = 0;
            int j = 0;
            for (i = 0; i < first.length(); i++) {
                if (first.charAt(i) == second.charAt(j)) {
                    j++;
                    continue;
                } else {
                    if (!different) {
                        different = true;
                        if (second.charAt(++j) == first.charAt(i)) {
                            j++;
                            continue;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
