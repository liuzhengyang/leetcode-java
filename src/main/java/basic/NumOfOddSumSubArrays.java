package basic;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class NumOfOddSumSubArrays {
    public static void main(String[] args) {
        NumOfOddSumSubArrays numOfOddSumSubArrays = new NumOfOddSumSubArrays();
        System.out.println(numOfOddSumSubArrays.numOfSubarrays(new int[] {1, 3, 5}));
        System.out.println(numOfOddSumSubArrays.numOfSubarrays(new int[] {2, 4, 6}));
        System.out.println(numOfOddSumSubArrays.numOfSubarrays(new int[] {1, 2, 3, 4, 5, 6, 7}));
        System.out.println(numOfOddSumSubArrays.numOfSubarrays(new int[] {100, 100, 99, 99}));
        System.out.println(numOfOddSumSubArrays.numOfSubarrays(new int[] {7}));
        System.out.println(numOfOddSumSubArrays.numOfSubarrays(new int[] {5, 4, 4, 5, 1, 3}));
    }

    private static final int MOD = 1000_000_000 + 7;

    public int numOfSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        long[] cacheOdd = new long[arr.length];
        long[] cacheEvent = new long[arr.length];
        Arrays.fill(cacheEvent, -1);
        Arrays.fill(cacheOdd, -1);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += oddFun(arr, i, cacheOdd, cacheEvent);
            if (sum > MOD) {
                sum = sum % MOD;
            }
        }
        return sum;
    }

    // 从Index开始和为奇数的子数组的数量
    private long oddFun(int[] array, int index, long[] cacheOdd, long[] cacheEvent) {
        if (index == array.length - 1) {
            long result = array[index] % 2 == 1 ? 1 : 0;
            cacheOdd[index] = result;
            return result;
        }
        if (cacheOdd[index] >= 0) {
            return cacheOdd[index];
        }
        boolean isOdd = array[index] % 2 == 1;
        if (isOdd) {
            long result = 1 + (eventFun(array, index + 1, cacheOdd, cacheEvent));
            if (result > MOD) {
                result = result % MOD;
            }
            cacheOdd[index] = result;
            return result;
        } else {
            long result = oddFun(array, index + 1, cacheOdd, cacheEvent);
            if (result > MOD) {
                result = result % MOD;
            }
            cacheOdd[index] = result;
            return result;
        }
    }

    // 从Index开始和为奇数的子数组的数量
    private long eventFun(int[] array, int index, long[] cacheOdd, long[] cacheEvent) {
        if (index == array.length - 1) {
            long result = array[index] % 2 == 1 ? 0 : 1;
            cacheEvent[index] = result;
            return result;
        }
        boolean isOdd = array[index] % 2 == 1;
        if (isOdd) {
            long result = oddFun(array, index + 1, cacheOdd, cacheEvent);
            cacheEvent[index] = result;
            return result;
        } else {
            long result = 1 + eventFun(array, index + 1, cacheOdd, cacheEvent);
            cacheEvent[index] = result;
            return result;
        }
    }
}
