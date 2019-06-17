package dfs.loudandrich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2 {

    public static void main(String[] args) {
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiert = new int[]{3, 2, 5, 4, 6, 1, 7, 0};
        System.out.println(Arrays.toString(new Solution2().loudAndRich(richer, quiert)));
    }

    private Map<Integer, Set<Integer>> poorerCache = new HashMap<>();

    private Map<Integer, List<int[]>> richerByIndex = new HashMap<>();

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] result = new int[quiet.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        for (int[] pair : richer) {
            int first = pair[0];
            richerByIndex.computeIfAbsent(first, k -> new ArrayList<>()).add(pair);
        }
        for (int i = 0; i < quiet.length; i++) {
            Set<Integer> poorer = findPoorer(richerByIndex, i);
            for (int poorIndex : poorer) {
                result[poorIndex] = quiet[i] < quiet[result[poorIndex]] ? i : result[poorIndex];
            }
        }
        return result;
    }

    private Set<Integer> findPoorer(Map<Integer, List<int[]>> richerByIndex, int i) {
        Set<Integer> cache = poorerCache.get(i);
        if (cache != null) {
            return cache;
        }
        Set<Integer> result = new HashSet<>();
        List<int[]> richer = richerByIndex.get(i);
        if (richer != null) {
            for (int[] rich : richer) {
                result.addAll(findPoorer(richerByIndex, rich[1]));
            }
        }
        result.add(i);
        poorerCache.put(i, result);
        return result;
    }

}
