package weekly.contest.biweek34;

/**
 * https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
 * @author liuzhengyang
 */
public class Problem3 {
    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}));
        System.out.println(problem3.findLengthOfShortestSubarray(new int[]{5,4,3,2,1}));
        System.out.println(problem3.findLengthOfShortestSubarray(new int[]{1,2,3}));
        System.out.println(problem3.findLengthOfShortestSubarray(new int[]{1}));
        System.out.println(problem3.findLengthOfShortestSubarray(new int[]{3,2,1}));
        System.out.println(problem3.findLengthOfShortestSubarray(new int[]{10,13,17,21,15,15,9,17,22,22,13}));
    }

    private int findLengthOfShortest(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        int l = 0;
        int r = array.length - 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[i - 1]) {
                l = i;
            } else {
                break;
            }
        }
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] <= array[i + 1]) {
                r = i;
            } else {
                break;
            }
        }
        int maxLength = Math.max(l + 1, array.length - r);
        int j = r;
        if (maxLength == array.length) {
            return 0;
        }
        for (int i = 0; i <= l; i++) {
            while (j < array.length && array[j] < array[i]) {
                j ++;
                if (j == array.length) {
                    break;
                }
            }
            maxLength = Math.max(maxLength, i + 1 + (array.length - j));
        }
        return array.length - maxLength;
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        if (true) {
            return findLengthOfShortest(arr);
        }
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        int leftPointer = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                leftPointer = i;
            } else {
                break;
            }
        }
        if (leftPointer == arr.length - 1) {
            return 0;
        }
        int rightCount = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                rightCount = arr.length - i;
            } else {
                break;
            }
        }
        int max = Math.max(leftPointer + 1, rightCount);
        if (arr[0] <= arr[arr.length - 1]) {
            for (int i = arr.length - 1; i >= arr.length - rightCount; i--) {
                if (arr[i] >= arr[leftPointer]) {
                    max = Math.max(max, leftPointer + 1 + arr.length - i);
                } else {
                    while (arr[leftPointer] > arr[i]) {
                        leftPointer--;
                        if (leftPointer < 0) {
                            break;
                        }
                    }
                    max = Math.max(max, leftPointer + 1 + arr.length - i);
                    if (leftPointer < 0) {
                        break;
                    }
                }
            }
        }
        return arr.length - max;
    }
}
