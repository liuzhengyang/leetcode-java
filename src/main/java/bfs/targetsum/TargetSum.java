package bfs.targetsum;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/target-sum/
 * 题目的关键点在于数组为非负数，数组大小的和有上界。
 * 思路对于每个数组元素的加减，想象成bfs的遍历，之前的所有可能结果的加和为待遍历的结果集，bfs遍历一遍之后得到一组新的结果。
 * 由于可能有重复的结果，这里也记录每层结果的数量。最终遍历完成之后，和为S的数量即为要求得的值。
 *
 * @author liuzhengyang
 */
public class TargetSum {
    public static void main(String[] args) {

    }

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null) {
            return 0;
        }
        int maxValue = Arrays.stream(nums).sum();
        if (S < -maxValue || S > maxValue) {
            return 0;
        }
        int[] array = new int[2 * maxValue + 1];
        int[] nextArray = new int[2 * maxValue + 1];
        array[nums[0] + maxValue] += 1;
        array[-nums[0] + maxValue] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] != 0) {
                    int positiveAdd = j + nums[i];
                    nextArray[positiveAdd] += array[j];
                    int negativeAdd = j - nums[i];
                    nextArray[negativeAdd] += array[j];
                }
            }
            array = nextArray;
            nextArray = new int[2 * maxValue + 1];
        }
        return array[S + maxValue];
    }
}
