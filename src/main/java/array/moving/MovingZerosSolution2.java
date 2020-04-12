package array.moving;

import java.util.Arrays;

/**
 * @author liuzhengyang
 * Make something people want.
 * 2020/4/12
 */
public class MovingZerosSolution2 {
    public static void main(String[] args) {
        MovingZerosSolution2 movingZerosSolution2 = new MovingZerosSolution2();
        int[] array = new int[] {1, 0, 2, 0, 12};
        movingZerosSolution2.moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int insertPosition = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPosition++] = num;
            }
        }
        for (int i = insertPosition; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
