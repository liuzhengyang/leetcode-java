package basic.multiplystrings;

import java.math.BigInteger;

/**
 * @author liuzhengyang
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        final MultiplyStrings multiplyStrings = new MultiplyStrings();
        final String multiply = multiplyStrings.multiply("123", "456");
        System.out.println(multiply);
        System.out.println(multiplyStrings.multiply("2", "3"));
        System.out.println(multiplyStrings.multiply("2", "0"));
        System.out.println(multiplyStrings.multiply("0", "0"));
        System.out.println(multiplyStrings.multiply("19110101001110101010", "1234124124"));
        System.out.println(multiplyStrings.multiply("19110101001110101015", "1234124124"));
        BigInteger bigInteger = new BigInteger("23584236657546526436517765240");
        System.out.println(
                bigInteger.equals(new BigInteger("19110101001110101010").multiply(new BigInteger("1234124124"))));
    }
    // nums no leading 0, all digits
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        final int length1 = num1.length();
        final int length2 = num2.length();
        int[] digits1 = new int[length1];
        int[] digits2 = new int[length2];
        final char[] chars1 = num1.toCharArray();
        final char[] chars2 = num2.toCharArray();
        for (int i = 0; i < length1; i++) {
            digits1[length1 - 1 - i] = chars1[i] - '0';
        }
        for (int i = 0; i < length2; i++) {
            digits2[length2 - 1 - i] = chars2[i] - '0';
        }
        int[] multiply = new int[1 + length1 + length2];

        for (int i = 0; i < length2; i++) {
            int[] added = new int[length1 + 1];
            int append = 0;
            for (int j = 0; j < length1; j++) {
                int thisSum = digits2[i] * digits1[j] + append;
                added[j] = thisSum % 10;
                append = thisSum / 10;
            }
            if (append > 0) {
                added[length1] = append;
            }
            add(multiply, added, i);
        }
        StringBuilder sb = new StringBuilder();

        boolean start = false;
        for (int i = multiply.length - 1; i >= 0; i--) {
            if (multiply[i] > 0 || start) {
                sb.append(multiply[i]);
                if (!start) {
                    start = true;
                }
            }
        }
        return sb.toString();
    }

    private void add(int[] sum, int[] input, int startIndex) {
        int append = 0;
        for (int i = 0; i < input.length; i++) {
            int thisSum = sum[startIndex + i] + input[i] + append;
            append = thisSum / 10;
            sum[startIndex + i] = thisSum % 10;
        }
        if (append > 0) {
            sum[input.length + startIndex] += append;
        }
    }
}
