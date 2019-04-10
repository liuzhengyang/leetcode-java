package containerwithmostwater;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        return maxArea(height, height.length);
    }

    private int maxArea(int[]height, int size) {
        if (size == 2) {
            return Math.min(height[0], height[1]) * (2 - 1);
        }
        int currentMax = 0;
        for (int i = 0; i < size - 1; i++) {
            int sum = (size -1 - i) * Math.min(height[i], height[size - 1]);
            if (sum > currentMax) {
                currentMax = sum;
            }
        }
        return Math.max(maxArea(height, size - 1), currentMax);
    }


}
