package dynamicprogramming.maximumwidthramp;

import java.util.Map;
import java.util.TreeMap;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        System.out.println(solution.maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }

    public int maxWidthRamp(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int max = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (!treeMap.containsKey(A[i])) {
                treeMap.put(A[i], i);
            }
            Map.Entry<Integer, Integer> ceilingEntry = treeMap.ceilingEntry(A[i]);
            if (ceilingEntry != null) {
                max = Math.max(max, ceilingEntry.getValue() - i);
            }
        }
        return max;
    }
}
