package sort.heightchcker;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

    }

    public int heightChecker(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] copyArray = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copyArray);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copyArray[i]) {
                count ++;
            }
        }
        return count;
    }
}
