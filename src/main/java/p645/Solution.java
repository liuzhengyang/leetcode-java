package p645;

/**
 * @author liuzhengyang
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int[] indicies = new int[nums.length];
        for (int num : nums) {
            indicies[num-1] ++;
        }
        for (int i = 0; i < indicies.length; i++) {
            if (result[0] > 0 && result[1] > 0) {
                break;
            }
            if (indicies[i] > 1) {
                result[0] = i + 1;
            }
            if (indicies[i] == 0) {
                result[1] = i + 1;
            }
        }
        return result;
    }
}
