package twopointer;

/**
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
