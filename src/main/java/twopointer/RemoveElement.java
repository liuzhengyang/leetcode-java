package twopointer;

/**
 * 双指针(two pointer)思路，左边指针指向下一个要设置的位置，右边指针指向下一个要遍历的位置每次+1，如果=val则不设置left，否则设置并增加left
 * @author liuzhengyang
 */
public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(new int[] {3, 2, 2, 3}, 3));
        System.out.println(removeElement.removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 标记下一个不等于val的值应该放到的位置
        int left = 0;
        // 标记下一个该遍历的位置
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
            right++;
        }
        return left;
    }
}
