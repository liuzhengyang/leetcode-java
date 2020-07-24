package twopointer;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * 左右两个指针从最左和最右分别开始。如果a[left] > a[right]，这时，无论left向右如何移动，值都不可能比a[left]之前的值大了，因为
 * 面积的计算是最小值和两个位置之间的宽度，宽度一定变小，且最小值只会更下不会变大，因此只有移动right--才可能比之前的最大值更大。
 * 以此类推，每次向中间移动较小的那个索引指针。
 *
 * @author liuzhengyang
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) {
                right --;
            } else {
                left ++;
            }
        }
        return maxArea;
    }
}
