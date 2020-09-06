package weekly.contest.week205;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author liuzhengyang
 */
public class Problem2 {
    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
//        System.out.println(problem2.numTriplets(new int[]{1,1}, new int[]{1,1,1}));
        System.out.println(problem2.numTriplets(new int[]{100000,100000}, new int[]{100000,100000,100000}));
    }

    public int numTriplets(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Map<Long, Set<Integer>> numToIndexList1 = new HashMap<>();
        Map<Long, Set<Integer>> numToIndexList2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            numToIndexList1.computeIfAbsent((long) nums1[i], k -> new HashSet<>())
                    .add(i);
        }
        for (int i = 0; i < nums2.length; i++) {
            numToIndexList2.computeIfAbsent((long) nums2[i], k -> new HashSet<>())
                    .add(i);
        }

        long[] squareNum1 = new long[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            squareNum1[i] = ((long)nums1[i]) * nums1[i];
        }
        int sum = 0;
        for (int i = 0; i < squareNum1.length; i++) {
            long square = squareNum1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (square >= nums2[j]) {
                    long target = square / nums2[j];
                    if (target * nums2[j] == square) {
                        Set<Integer> targetIndexSet = numToIndexList2.getOrDefault(target, Collections.emptySet());
                        if (targetIndexSet.contains(j)) {
                            sum += targetIndexSet.size() - 1;
                        } else {
                            sum += targetIndexSet.size();
                        }
                    }
                } else {
                    break;
                }
            }
        }
        long[] squareNum2 = new long[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            squareNum2[i] = ((long)nums2[i]) * nums2[i];
        }
        for (int i = 0; i < squareNum2.length; i++) {
            long square = squareNum2[i];
            for (int j = 0; j < nums1.length; j++) {
                if (square >= nums1[j]) {
                    long target = square / nums1[j];
                    if (target * nums1[j] == square) {
                        Set<Integer> targetIndexSet = numToIndexList1.getOrDefault(target, Collections.emptySet());
                        if (targetIndexSet.contains(j)) {
                            sum += targetIndexSet.size() - 1;
                        } else {
                            sum += targetIndexSet.size();
                        }
                    }
                } else {
                    break;
                }
            }
        }

        return sum / 2;
    }
}
