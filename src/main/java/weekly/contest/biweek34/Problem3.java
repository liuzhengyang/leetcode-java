package weekly.contest.biweek34;

/**
 * @author liuzhengyang
 */
public class Problem3 {
    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}));
        System.out.println(problem3.findLengthOfShortestSubarray(new int[]{5,4,3,2,1}));
        System.out.println(problem3.findLengthOfShortestSubarray(new int[]{1,2,3}));
        System.out.println(problem3.findLengthOfShortestSubarray(new int[]{1}));
        System.out.println(problem3.findLengthOfShortestSubarray(new int[]{10,13,17,21,15,15,9,17,22,22,13}));
    }

    public int findLengthOfShortestSubarray(int[] arr) {
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
