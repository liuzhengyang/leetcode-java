package bfs.jumpgame;

/**
 * @author liuzhengyang
 */
public class JumpGame {
    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int count = 0;
        int left = 0;
        int right = 0;
        while (true) {
            int newRangeRight = right;
            for (int i = left; i <= right; i++) {
                newRangeRight = Math.max(newRangeRight, i + nums[i]);
            }
            left = right + 1;
            right = newRangeRight;
            count++;
            if (right >= nums.length - 1) {
                break;
            }
        }
        return count;
    }
}
