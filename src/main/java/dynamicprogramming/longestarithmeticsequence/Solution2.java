package dynamicprogramming.longestarithmeticsequence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhengyang
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
        System.out.println(solution.longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
    }

    /**
     * index(数组的第几个元素)到最长等差数组结果的映射
     * 等差数组结果是指当前位置开始所有长度等差数组的最大长度
     */
    private Map<Integer, Integer>[] indexToLongestMap;

    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        indexToLongestMap = new Map[A.length];
        int max = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (i == A.length - 1) {
                indexToLongestMap[i] = new HashMap<>();
            } else {
                Map<Integer, Integer> diffToLongestMap = new HashMap<>();
                for (int j = i + 1; j < A.length; j++) {
                    int diff = A[i] - A[j];
                    int thisMax = diffToLongestMap.getOrDefault(diff, 0);
                    thisMax = Math.max(thisMax, indexToLongestMap[j].getOrDefault(diff, 0) + 1);
                    diffToLongestMap.put(diff, thisMax);
                    max = Math.max(thisMax, max);
                }
                indexToLongestMap[i] = diffToLongestMap;
            }
        }
        return max + 1;
    }

}
