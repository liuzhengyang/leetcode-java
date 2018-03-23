package p645;

/**
 * @author liuzhengyang
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int expectedSum = (1 + nums.length) * nums.length / 2;
        int[] indicies = new int[nums.length];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (++indicies[num - 1] > 1) {
                result[0] = num;
            }
        }
        result[1] = expectedSum - sum + result[0];
        return result;
    }
}
