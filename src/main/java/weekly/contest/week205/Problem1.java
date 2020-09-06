package weekly.contest.week205;

/**
 * @author liuzhengyang
 */
public class Problem1 {
    public static void main(String[] args) {

    }

    public String modifyString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            if (chars[0] == '?') {
                return new String(new char[]{'a'});
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                if (i > 0 && i < s.length() - 1) {
                    char c = (char) (findOneOtherChar(chars[i - 1] - 'a', chars[i + 1] - 'a') + 'a');
                    chars[i] = c;
                } else if (i == 0) {
                    chars[i] = (char) (findOneOtherChar(chars[i + 1] - 'a') + 'a');
                } else {
                    chars[i] = (char) (findOneOtherChar(chars[i - 1] - 'a') + 'a');
                }
            }
        }
        return new String(chars);
    }

    private int findOneOtherChar(int c1, int c2) {
        for (int i = 0; i < 26; i++) {
            if (c1 != i && c2 != i) {
                return i;
            }
        }
        return 0;
    }

    private int findOneOtherChar(int c) {
        for (int i = 0; i < 26; i++) {
            if (c != i) {
                return i;
            }
        }
        return 0;
    }
}
