package array.firstmissingpositive;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * 最小的missing正整数肯定不大于数组长度，因为限制了额外空间，使用数组作为计数。
 * 先扫描一遍，如果<=0或>array.length，则设置对应的值为0
 * 再dfs扫描每个点，如果点为正数，则寻找array[i] - 1目标值，直到等于自己或=0，修改对应的值为i + 1
 * 为了防止循环依赖，在开始遍历时，修改当前值为length + 1
 * dfs全部遍历完，从数组头部开始遍历，如果哪个值为0或length+1，则说明missing，否则为length + 1
 *
 * @author liuzhengyang
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {1, 2, 0}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {2, 1}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {3, 4, -1, 1}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {7, 8, 9, 11, 12}));
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
        for (int i = 0; i < arrayLength; i++) {
            if (nums[i] > 0) {
                dfsVisit(nums, i);
            }
        }
        for (int i = 0; i < arrayLength; i++) {
            if (nums[i] == 0 || nums[i] == arrayLength + 1) {
                return i + 1;
            }
        }
        return arrayLength + 1;
    }

    private void dfsVisit(int[] nums, int index) {
        if (index < 0 || index >= nums.length) {
            return;
        }
        if (nums[index] == 0) {
            nums[index] = index + 1;
            return;
        }
        if (nums[index] == index + 1) {
            return;
        }
        int targetIndex = nums[index];
        if (targetIndex == nums.length + 1) {
            nums[index] = index + 1;
            return;
        } else {
            // mark visiting
            nums[index] = nums.length + 1;
            dfsVisit(nums, targetIndex - 1);
            nums[targetIndex - 1] = targetIndex;
        }
    }
}
