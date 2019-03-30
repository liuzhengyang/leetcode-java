package p674;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersect(new int[]{3,1,1},
                new int[]{1, 2})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] shortArray;
        int[] longArray;
        if (nums1.length > nums2.length) {
            longArray = nums1;
            shortArray = nums2;
        } else {
            longArray = nums2;
            shortArray = nums1;
        }

        int[] result = new int[shortArray.length];
        int resultIndex = 0;
        int longIndex = 0;
        for (int i = 0; i < shortArray.length; i++) {
            for (int j = longIndex; j < longArray.length; j++) {
                if (longArray[j] == shortArray[i]) {
                    result[resultIndex ++] = shortArray[i];
                    longIndex = j + 1;
                    break;
                }
            }
        }
        int[] resultFinal = Arrays.copyOf(result, resultIndex);

        return resultFinal;
    }
}
