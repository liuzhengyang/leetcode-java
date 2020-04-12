package array.moving;

import java.util.Arrays;

/**
 * 维护两个index,一个一直指向从左开始第一个0的位置，一个一直向右指向不为0的位置，不断交换这两个index的值
 *
 * @author liuzhengyang
 * Make something people want.
 * 2020/4/12
 */
public class MovingZeros {
    public static void main(String[] args) {
        int[] array = new int[] {0, 1, 0, 3, 12};
        MovingZeros movingZeros = new MovingZeros();
        movingZeros.moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int firstZeroIndex = 0;
        int lastNonZero = 0;
        int length = nums.length;
        while (lastNonZero < length) {
            if (nums[firstZeroIndex] != 0) {
                if (nums[lastNonZero] != 0) {
                    firstZeroIndex ++;
                    lastNonZero ++;
                } else {
                    firstZeroIndex ++;
                }
            } else {
                while (lastNonZero < length && nums[lastNonZero] == 0) {
                    lastNonZero++;
                }
                if (lastNonZero >= length) {
                    break;
                }
                nums[firstZeroIndex] = nums[lastNonZero];
                nums[lastNonZero] = 0;
                firstZeroIndex ++;
                lastNonZero ++;
            }
        }
    }
}
