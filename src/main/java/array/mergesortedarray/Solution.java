package array.mergesortedarray;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

        // [1,2,3,0,0,0]
        //3
        //[2,5,6]
        //3
        int[] array1 = {1, 2, 3, 0, 0, 0};
        new Solution().merge(array1, 3, new int[]{2,5,6}, 3);
        System.out.println(Arrays.toString(array1));


    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (index1 < 0) {
                nums1[i] = nums2[index2--];
                continue;
            }
            if (index2 < 0){
                nums1[i] = nums1[index1--];
                continue;
            }
            if (nums1[index1] > nums2[index2]) {
                nums1[i] = nums1[index1--];
            } else {
                nums1[i] = nums2[index2--];
            }
        }
    }
}
