package bfs.jumpgame2;

/**
 * @author liuzhengyang
 */
public class JumpGame2 {
    public static void main(String[] args) {
        JumpGame2 jumpGame2 = new JumpGame2();
        System.out.println(jumpGame2.canJump(new int[] {2, 3, 1, 1, 4}));
        System.out.println(jumpGame2.canJump(new int[] {3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int left = 0;
        int right = 0;
        while (true) {
            int newRangeRight = right;
            for (int i = left; i <= right; i++) {
                int target = i + nums[i];
                if (target > newRangeRight) {
                    newRangeRight = target;
                }
            }
            if (newRangeRight == right) {
                return false;
            }
            left = right;
            right = newRangeRight;
            if (right >= nums.length - 1) {
                return true;
            }
        }
    }

}
