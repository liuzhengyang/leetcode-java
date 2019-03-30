package p578;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(new Solution().containsDuplicate(arr));
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}
