package basic.palindromenumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 首先，不能对数字反转和原来数字比较，因为有可能溢出。然后可以把负数都排除，负数前面有-，然后可以排除一些不为0且结尾为0的case
 * 方案1: 保存每个数字到List中，然后反转List和原来List相比是否相等
 * 方案2: 回文数的特点是数字从中间分隔两边镜像，也就是把数字右边反转过来和左边相等。方式为保存左边的数字，和右边的数字，每次循环左边数字left/10，右边数字
 * right = right * 10 + left % 10，直到右边数字大于或等于左边，如果相等或right/10=left(中间对称忽略)说明是回文数，否则不是
 * 方案3: 转成string，从string的首尾开始比较判断是否相等
 *
 * @author liuzhengyang
 * 2020/8/5
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(1));
        System.out.println(palindromeNumber.isPalindrome(121));
        System.out.println(palindromeNumber.isPalindrome(-121));
        System.out.println(palindromeNumber.isPalindrome(12231));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int left = x;
        int right = 0;
        while (left > right) {
            right = right * 10 + left % 10;
            left /= 10;
        }
        return left == right || left == right / 10;
    }

    public boolean isPalindromeVersion0(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> numbers = new ArrayList<>();
        while (x > 0) {
            numbers.add(x % 10);
            x /= 10;
        }
        List<Integer> reverseNumbers = new ArrayList<>(numbers);
        Collections.reverse(reverseNumbers);
        return reverseNumbers.equals(numbers);
    }

    public boolean isPalindromeVersion1(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        int length = str.length();
        int i = 0;
        int j = length - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
