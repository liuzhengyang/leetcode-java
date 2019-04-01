package singlenumber2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(~2);
        System.out.println(~-1);
        System.out.println(~-2);
        System.out.println(new Solution().singleNumber(new int[]{2,2,3,2}));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-3));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, -1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
