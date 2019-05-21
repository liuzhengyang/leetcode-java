package array.deletecolumntomakesorted;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        System.out.println(solution.minDeletionSize(new String[]{"a", "b"}));
        System.out.println(solution.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }

    public int minDeletionSize(String[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }

        List<char[]> charArrayList = new ArrayList<>();
        for (String s : A) {
            charArrayList.add(s.toCharArray());
        }
        int eachLength = charArrayList.get(0).length;
        int count = 0;
        for (int i = 0; i < eachLength; i++) {
            int maxIndex = -1;
            for (int j = 0; j < charArrayList.size(); j++) {
                if (maxIndex == -1) {
                    maxIndex = j;
                } else {
                    if (charArrayList.get(j)[i] >= charArrayList.get(maxIndex)[i]) {
                        maxIndex = j;
                    } else {
                        count ++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
