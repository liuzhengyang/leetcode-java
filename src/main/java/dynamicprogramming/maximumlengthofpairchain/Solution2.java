package dynamicprogramming.maximumlengthofpairchain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhengyang
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.findLongestChain(new int[][]{{3, 4}, {2, 3}, {1, 2}}));
        System.out.println(solution.findLongestChain(new int[][]{{-10,-8},{8,9},{-5,0},{6,10},
        {-6,-4},{1,7},{9,10},{-4,7}}));
    }

    private int[] cache;
    private Map<Integer, Integer> nextIndexMap = new HashMap<>();

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                int compare = Integer.compare(o1[0], o2[0]);
                if (compare == 0) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return compare;
            }
        });
        cache = new int[pairs.length + 1];
        Arrays.fill(cache, -1);
        buildNextMap(pairs);
        return doFind(pairs, 0);
    }

    private void buildNextMap(int[][] pairs) {
        for (int i = 0; i < pairs.length; i++) {
            for (int j = i + 1; j < pairs.length; j++) {
                if (pairs[j][0] > pairs[i][1]) {
                    nextIndexMap.put(i, j);
                    break;
                }
            }
        }
    }

    private int doFind(int[][] pairs, int currentIndex) {
        if (currentIndex == pairs.length) {
            return 0;
        }
        if (cache[currentIndex] != -1) {
            return cache[currentIndex];
        }
        int result = Integer.MIN_VALUE;
        result = Math.max(result, 1 + doFind(pairs, findNextIndex(pairs, currentIndex)));
        result = Math.max(result, doFind(pairs, currentIndex + 1));
        cache[currentIndex] = result;
        return result;
    }

    private int findNextIndex(int[][] pairs, int currentIndex) {
        return nextIndexMap.getOrDefault(currentIndex, pairs.length);
    }
}
