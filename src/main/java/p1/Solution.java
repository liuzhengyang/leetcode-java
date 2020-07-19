package p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 几种解法
 * 1. 暴力破解 两层循环
 * 2. 先进行排序，然后固定第一个值时，二分搜索查找第二个
 * 3. 保存值到index列表的映射，匹配查找优化到O(1)
 *
 * @author liuzhengyang
 */
public class Solution {
    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, List<Integer>> numToIndexListMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = numToIndexListMap.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            numToIndexListMap.put(nums[i], list);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> integers = numToIndexListMap.get(target - num);
            if (integers != null) {
                if (target - num == num) {
                    if (integers.size() == 2) {
                        return new int[] {integers.get(0), integers.get(1)};
                    }
                    continue;
                }
                return new int[] {i, integers.get(0)};
            }
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndexListMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer supplementIndex = numToIndexListMap.get(target - nums[i]);
            if (supplementIndex != null) {
                if (supplementIndex != i) {
                    return new int[] {supplementIndex, i};
                }
            }
            numToIndexListMap.put(nums[i], i);
        }
        return null;
    }


    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int[] ret = new Solution().twoSum(nums, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }

}
