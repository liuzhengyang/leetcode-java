package p728;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDivided(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSelfDivided(int num) {
        List<Integer> digits = getDigits(num);
        for (int digit : digits) {
            if (digit == 0 || num % digit != 0) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getDigits(int num) {
        List<Integer> result = new ArrayList<>();
        while (num > 0) {
             result.add(num % 10);
             num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().selfDividingNumbers(1, 22));
    }
}
