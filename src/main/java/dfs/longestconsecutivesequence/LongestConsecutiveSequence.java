package dfs.longestconsecutivesequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 要求O(n)，首先构建出一个图，图中节点是各个数字，数字直接如果相邻，则进行连接。
 * 构建完图后，进行dfs遍历，找到最大的联通子图
 * @author liuzhengyang
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> graph = buildGraph(nums);
        Set<Integer> visited = new HashSet<>();
        int max = 0;
        Set<Integer> keys = graph.keySet();
        for (int key : keys) {
            if (!visited.contains(key)) {
                max = Math.max(max, dfsCountConsecutive(graph, key, visited));
            }
        }
        return max;
    }

    private int dfsCountConsecutive(Map<Integer, Integer> graph, int num, Set<Integer> visited) {
        visited.add(num);
        int count = 1;
        Integer value = graph.get(num);
        if (value == 0) {
            return count;
        }
        if (value == 1 && !visited.contains(num + 1)) {
            count += dfsCountConsecutive(graph, num + 1, visited);
        }
        if (value == 2 && !visited.contains(num - 1)) {
            count += dfsCountConsecutive(graph, num - 1, visited);
        }
        if (value == 3) {
            if (!visited.contains(num + 1)) {
                count += dfsCountConsecutive(graph, num + 1, visited);
            }
            if (!visited.contains(num - 1)) {
                count += dfsCountConsecutive(graph, num - 1, visited);
            }
        }
        return count;
    }

    private Map<Integer, Integer> buildGraph(int[] nums) {
        Map<Integer, Integer> graph = new HashMap<>();
        // value 0 exist, 1 upper exist 2 lowerExist 3 both exist
        for (int num : nums) {
            boolean upperExist = false;
            boolean lowerExist = false;
            int lower = num - 1;
            Integer lowerValue = graph.get(lower);
            if (lowerValue != null) {
                graph.put(lower, computeLowerNewValue(lowerValue));
                lowerExist = true;
            }
            int upper = num + 1;
            Integer upperValue = graph.get(upper);
            if (upperValue != null) {
                graph.put(upper, computeUpperNewValue(upperValue));
                upperExist = true;
            }
            int currentValue;
            if (lowerExist) {
                if (upperExist) {
                    currentValue = 3;
                } else {
                    currentValue = 2;
                }
            } else {
                if (upperExist) {
                    currentValue = 1;
                } else {
                    currentValue = 0;
                }
            }
            graph.put(num, currentValue);
        }
        return graph;
    }

    /**
     * 如果当前数字存在，计算当前数字-1对应的数字的值
     * @param oldValue
     * @return
     */
    private int computeLowerNewValue(int oldValue) {
        if (oldValue == 0) {
            return 1;
        }
        if (oldValue == 2) {
            return 3;
        }
        return oldValue;
    }

    private int computeUpperNewValue(int oldValue) {
        if (oldValue == 0) {
            return 2;
        }
        if (oldValue == 1) {
            return 3;
        }
        return oldValue;
    }

}
