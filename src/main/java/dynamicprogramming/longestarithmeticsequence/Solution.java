package dynamicprogramming.longestarithmeticsequence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestArithSeqLength(new int[]{9,4,7,2,10}));
        System.out.println(solution.longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }

    /**
     * index(数组的第几个元素)到最长等差数组结果的映射
     * 等差数组结果是指当前位置开始所有长度等差数组的最大长度
     */
    private Map<Integer, Map<Integer, Integer>> indexToResultMap;

    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        indexToResultMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            Map<Integer, Integer> lengthMap = doGetLongest(A, i);
            Collection<Integer> lengths = lengthMap.values();
            for (int length : lengths) {
                max = Math.max(max, length);
            }
        }
        return max + 1;
    }

    private Map<Integer, Integer> doGetLongest(int[] nums, int index) {
        if (index >= nums.length - 1) {
            Map<Integer, Integer> result = new HashMap<>();
            indexToResultMap.put(index, result);
            return result;
        }
        Map<Integer, Integer> cache = indexToResultMap.get(index);
        if (cache != null) {
            return cache;
        }
        Map<Integer, Integer> thisResult = new HashMap<>();

        for (int i = index + 1; i < nums.length; i++) {
            Map<Integer, Integer> next = doGetLongest(nums, i);
            int diff = nums[i] - nums[index];
            Integer thisValue = thisResult.getOrDefault(diff, 0);
            int thisMax = Math.max(thisValue, 1 + next.getOrDefault(diff, 0));
            thisResult.put(diff, thisMax);
        }

        indexToResultMap.put(index, thisResult);
        return thisResult;
    }
}
