package array.thirdmaximumnumber;

import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.thirdMax(new int[]{3, 2, 1}));
        System.out.println(solution.thirdMax(new int[]{1, 2}));
        System.out.println(solution.thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(solution.thirdMax(new int[]{1, 1, 2}));
    }

    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSize = 3;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            if (treeSet.size() < maxSize) {
                treeSet.add(num);
            } else {
                Integer first = treeSet.first();
                if (first < num) {
                    treeSet.add(num);
                }
                if (treeSet.size() > maxSize) {
                    treeSet.pollFirst();
                }
            }
        }
        return treeSet.size() < maxSize ? treeSet.last() : treeSet.first();
    }
}
