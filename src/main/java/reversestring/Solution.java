package reversestring;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        String hello = "hello";
        char[] chars = hello.toCharArray();
        new Solution().reverseString(chars);
        System.out.println(chars);
    }

    public void reverseString(char[] s) {
        if (s == null || s.length < 1) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            swap(s, i, j);
            i ++;
            j --;
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
