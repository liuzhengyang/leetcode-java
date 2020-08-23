package weekly.contest.biweeek33;

import java.util.Map;

/**
 * @author liuzhengyang
 */
public class Problem3 {
    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.minOperations(new int[]{1,5}));
        System.out.println(problem3.minOperations(new int[]{2,2}));
        System.out.println(problem3.minOperations(new int[]{4,2,5}));
        System.out.println(problem3.minOperations(new int[]{3,2,2,4}));
        System.out.println(problem3.minOperations(new int[]{2,4,8,16}));
    }

    public int minOperations(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int operation = 0;
        int maxDivideCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] result = fn(nums[i]);
            operation += result[0];
            maxDivideCount = Math.max(maxDivideCount, result[1]);
        }
        return operation + maxDivideCount;
    }

    // index 0 +1次数, index 1 /2次数
    private int[] fn(int n) {
        int addCount = 0;
        int divideCount = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
                divideCount ++;
            } else {
                n -= 1;
                addCount++;
            }
        }
        return new int[]{addCount, divideCount};
    }
}
