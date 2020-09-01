package array.longestproductpositivesubarraylength;

/**
 * -1, -1, 1, -1, -2, -3, -4, 2, 3
 * @author liuzhengyang
 * 2020/9/1
 */
public class LongestMaxPositiveProductSubArrayLength {
    public static void main(String[] args) {
//        System.out.println(new LongestMaxPositiveProductSubArrayLength().getMaxLen(new int[]{0,1,-2,-3,-4}));
        System.out.println(new LongestMaxPositiveProductSubArrayLength().getMaxLen(new int[]{-16,0,-5,2,2,-13,11,8}));
    }

    public int getMaxLen(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int positiveCount = 0;
        int negativeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                positiveCount = 0;
                negativeCount = 0;
            } else {
                if (num > 0) {
                    positiveCount ++;
                    if (negativeCount > 0) {
                        negativeCount ++;
                    }
                    max = Math.max(max, positiveCount);
                } else {
                    int newPositiveCount = negativeCount > 0 ?  negativeCount + 1 : 0 ;
                    int newNegativeCount = positiveCount + 1;
                    negativeCount = newNegativeCount;
                    positiveCount = newPositiveCount;
                    max = Math.max(max, positiveCount);
                }
            }
            System.out.println(positiveCount + " " + negativeCount);
        }
        return max;
    }
}
