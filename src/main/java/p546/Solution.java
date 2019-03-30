package p546;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3, 3}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null && index != i) {
                return i > index ? new int[]{index, i} : new int[]{i, index};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
