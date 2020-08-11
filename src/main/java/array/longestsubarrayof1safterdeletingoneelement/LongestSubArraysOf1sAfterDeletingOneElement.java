package array.longestsubarrayof1safterdeletingoneelement;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 * 实现思路
 * <p>
 * 思路1: 一个左右两边都是1的0删除后能得到一个更大连续的1
 * 遍历数组，如果一个数字是0，且前后都是1，则
 * 0011110011111011111
 * 0011110022222033333
 * countByValue
 * maxCount
 * if (a[i-1] > 0 && a[i+1] > 0) {
 * max = max(max, count(i-1) + count(i+1))
 * }
 * <p>
 * 思路2: 滑动窗口
 * 用left,right维护一个最多只有一个0的窗口范围，如果0的数量<=1，计算max, right++，否则left++，如果之前left位置是0，则zeroCount--
 *
 * @author liuzhengyang
 * 2020/7/30
 */
public class LongestSubArraysOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        LongestSubArraysOf1sAfterDeletingOneElement longestSubArraysOf1sAfterDeletingOneElement = new LongestSubArraysOf1sAfterDeletingOneElement();
        System.out.println(longestSubArraysOf1sAfterDeletingOneElement.longestSubarray(new int[]{0, 0, 0}));
        System.out.println(longestSubArraysOf1sAfterDeletingOneElement.longestSubarray(new int[]{1, 0, 0}));
        System.out.println(longestSubArraysOf1sAfterDeletingOneElement.longestSubarray(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0}));
        System.out.println(longestSubArraysOf1sAfterDeletingOneElement.longestSubarray(new int[]{1, 1, 1}));
        System.out.println(longestSubArraysOf1sAfterDeletingOneElement.longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(longestSubArraysOf1sAfterDeletingOneElement.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
    }

    public int longestSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        int zeroCount = nums[0] == 0 ? 1 : 0;
        while (left <= right && right < nums.length) {
            if (zeroCount <= 1) {
                max = Math.max(max, (right - left + 1));
                right++;
                if (right < nums.length && nums[right] == 0) {
                    zeroCount ++;
                }
            } else {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
        }
        return max - 1;
    }

    public int longestSubarrayVersion2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Map<Integer, Integer> countByGroup = new HashMap<>();
        int currentGroup = 0;
        boolean prevIsOne = false;
        int[] group = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prevIsOne) {
                    int count = countByGroup.get(currentGroup) + 1;
                    countByGroup.put(currentGroup, count);
                    max = Math.max(max, count);
                } else {
                    int count = 1;
                    countByGroup.put(++currentGroup, count);
                    max = Math.max(max, count);
                }
                group[i] = currentGroup;
            }
            prevIsOne = nums[i] == 1;
        }
        if (max == nums.length) {
            return max - 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i > 0 && i < nums.length - 1) {
                    if (nums[i - 1] == 1 && nums[i + 1] == 1) {
                        max = Math.max(max, countByGroup.get(group[i - 1]) + countByGroup.get(group[i + 1]));
                    }
                }
            }
        }
        return max;
    }
}
