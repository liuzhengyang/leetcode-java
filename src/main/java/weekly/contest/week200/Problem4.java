package weekly.contest.week200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Problem4 {
    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        System.out.println(problem4.maxSum(new int[] {2, 4, 5, 8, 10}, new int[] {4, 6, 8, 9}));
        System.out.println(problem4.maxSum(new int[] {1,3,5,7,9}, new int[] {3,5,100}));
        System.out.println(problem4.maxSum(new int[] {1,2,3,4,5}, new int[] {6,7,8,9,10}));
        System.out.println(problem4.maxSum(new int[] {1,4,5,8,9,11,19}, new int[] {2,3,4,11,12}));
    }

    private static final int MOD = 1000_000_007;

    public int maxSum(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] fromArray = length1 < length2 ? nums1 : nums2;
        int[] toArray = length1 < length2 ? nums2 : nums1;
        List<Integer> sameValue = new ArrayList<>();
        int toArrayIndex = 0;
        for (int i = 0; i < fromArray.length; i++) {
            int find = fromArray[i];
            while (toArrayIndex < toArray.length) {
                if (toArray[toArrayIndex] < find) {
                    toArrayIndex++;
                } else if (toArray[toArrayIndex] == find) {
                    sameValue.add(find);
                    toArrayIndex++;
                    break;
                } else {
                    break;
                }
            }
        }
        if (sameValue.isEmpty()) {
            // 处理为空的情况
            // TODO
            long sum1 = 0;
            for (int n : nums1) {
                sum1 += n;
            }
            long sum2 = 0;
            for (int n : nums2) {
                sum2 += n;
            }
            return (int) (Math.max(sum1, sum2) % MOD);
        }
        List<Long> sum1 = new ArrayList<>();
        List<Long> sum2 = new ArrayList<>();
        long currentSum = 0;
        int sameValueIndex = 0;
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            if (sameValueIndex < sameValue.size()) {
                if (n == sameValue.get(sameValueIndex)) {
                    currentSum += nums1[i];
                    sum1.add(currentSum);
                    sameValueIndex++;
                    currentSum = 0;
                } else {
                    currentSum += nums1[i];
                }
            } else {
                currentSum += nums1[i];
                if (i == nums1.length - 1) {
                    sum1.add(currentSum);
                }
            }
        }
        currentSum = 0;
        sameValueIndex = 0;
        for (int i = 0; i < nums2.length; i++) {
            int n = nums2[i];
            if (sameValueIndex < sameValue.size()) {
                if (n == sameValue.get(sameValueIndex)) {
                    currentSum += nums2[i];
                    sum2.add(currentSum);
                    sameValueIndex++;
                    currentSum = 0;
                } else {
                    currentSum += nums2[i];
                }
            } else {
                currentSum += nums2[i];
                if (i == nums2.length - 1) {
                    sum2.add(currentSum);
                }
            }
        }
        long maxSum = 0;
        for (int i = 0; i < sameValue.size(); i++) {
            maxSum += Math.max(sum1.get(i), sum2.get(i));

        }
        long left1 = sum1.size() > sameValue.size() ? sum1.get(sum1.size() - 1) : 0;
        long left2 = sum2.size() > sameValue.size() ? sum2.get(sum2.size() - 1) : 0;
        maxSum += Math.max(left1, left2);
        return (int) (maxSum % MOD);
    }
}
