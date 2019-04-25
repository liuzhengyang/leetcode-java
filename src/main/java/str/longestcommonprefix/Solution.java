package str.longestcommonprefix;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        int i;
        for (i = 0; i < str.length(); i++) {
            boolean matached = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != str.charAt(i)) {
                    matached = false;
                    break;
                }
            }
            if (!matached) {
                break;
            }
        }
        return str.substring(0, i);
    }
}
