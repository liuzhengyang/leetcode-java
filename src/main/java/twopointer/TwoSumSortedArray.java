package twopointer;

/**
 * 有序数组，要能联想到左右双指针，指针的移动能够带来一些偏向，即移动位置能够控制变大变小
 * @author liuzhengyang
 */
public class TwoSumSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex) {
            int sum = numbers[leftIndex] + numbers[rightIndex];
            if (sum < target) {
                leftIndex ++;
            } else if (sum > target) {
                rightIndex --;
            } else {
                return new int[]{leftIndex + 1, rightIndex + 1};
            }
        }
        return null;
    }
}
