package weekly.contest.biweek34;

/**
 * @author liuzhengyang
 */
public class Problem2 {
    public static void main(String[] args) {

    }

    public int numWays(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int oneCount = 0;
        for (char aChar : chars) {
            if (aChar == '1') {
                oneCount ++;
            }
        }
        if (oneCount % 3 != 0) {
            return 0;
        }
        if (oneCount == 0) {
            long result = chars.length - 1;
            result *= result - 1;
            result /= 2;
            result %= 1000000007;
            return (int) result;
        }
        int newOneCount = 0;
        int firstZeroCount = 0;
        int secondZeroCount = 0;
        for (char c : chars) {
            if (c == '1') {
                newOneCount ++;
            } else {
                if (newOneCount == oneCount / 3) {
                    firstZeroCount ++;
                }
                if (newOneCount == 2 * oneCount / 3) {
                    secondZeroCount ++;
                }
            }
        }
        long result = (((long)(firstZeroCount + 1)) * (secondZeroCount + 1)) % 1000000007;
        return (int) result;
    }
}
