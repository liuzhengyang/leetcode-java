package containerwithmostwater;

/**
 * @author liuzhengyang
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[j], height[i]);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
