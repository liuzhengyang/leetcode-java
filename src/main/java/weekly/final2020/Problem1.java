package weekly.final2020;

/**
 * @author liuzhengyang
 */
public class Problem1 {
    public static void main(String[] args) {

    }

    public int calculate(String s) {
        int x = 1;
        int y = 0;
        if (s == null || s.length() == 0) {
            return x + y;
        }
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'A') {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }
        return x + y;
    }
}
