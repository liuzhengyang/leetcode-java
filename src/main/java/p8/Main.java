package p8;

/**
 * @author liuzhengyang
 */
public class Main {
    public int myAtoi(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        str = str.trim();
        int result = 0;
        int productBy = 1;
        int sign = 1;
        char[] chars = str.toCharArray();
        int startIndex = 0;
        if (str.isEmpty()) {
            return 0;
        }
        if (chars[0] == '+') {
            sign = 1;
            startIndex = 1;
        } else if (chars[0] == '-') {
            sign = -1;
            startIndex = 1;
        }
        for (int i = chars.length - 1; i >= startIndex ; i--) {
            if (chars[i] - '0' > 9 || chars[i] - '0' < 0) {
                return result;
            }
            result += productBy * (chars[i] - '0');
            productBy *= 10;
        }
        return result * sign;
    }
}
