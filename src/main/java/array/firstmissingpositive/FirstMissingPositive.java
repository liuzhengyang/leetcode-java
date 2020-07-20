package array.firstmissingpositive;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * 最小的missing正整数肯定不大于数组长度，因为限制了额外空间，使用数组作为计数。
 * 先扫描一遍，如果<=0或>array.length，则设置对应的值为0
 * 再dfs扫描每个点，如果点为正数，则寻找array[i] - 1目标值，直到等于自己活大于length或<=0，修改对应的值为-1
 * dfs全部遍历完，从数组头部开始遍历，如果哪个值为0，则说明missing，否则为length + 1
 *
 * @author liuzhengyang
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
//        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {1, 2, 0}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {2, 1}));
//        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {3, 4, -1, 1}));
//        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {7, 8, 9, 11, 12}));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int arrayLength = nums.length;
        for (int i = 0; i < arrayLength; i++) {
            if (nums[i] <= 0 || nums[i] > arrayLength) {
                nums[i] = 0;
            }
        }
        boolean[] visited = new boolean[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            if (nums[i] > 0) {
                dfsVisit(nums, i, visited);
            }
        }
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < arrayLength; i++) {
            if (nums[i] == 0) {
                return i + 1;
            }
        }
        return arrayLength + 1;
    }

    private void dfsVisit(int[] nums, int index, boolean[] visited) {
        if (index < 0 || index >= nums.length) {
            return;
        }
        if (nums[index] == 0) {
            visited[index] = true;
            nums[index] = index + 1;
            return;
        }
        if (nums[index] == index + 1) {
            visited[index] = true;
            return;
        }
        int targetIndex = nums[index] - 1;
        if (targetIndex >= 0 && targetIndex < nums.length) {
            dfsVisit(nums, targetIndex, visited);
        }
        if (nums[index] > 0 && nums[index] <= nums.length) {
            nums[index] = -1;
        }
    }
}
