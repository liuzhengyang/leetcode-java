package sort.maximumswap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumSwap(2736));
        System.out.println(solution.maximumSwap(9973));
        System.out.println(solution.maximumSwap(1));
        System.out.println(solution.maximumSwap(10));
    }

    public int maximumSwap(int num) {
        if (num == 0) {
            return 0;
        }
        List<Integer> digits = new ArrayList<>();
        int n = num;
        while (n != 0) {
            int i = n % 10;
            digits.add(i);
            n /= 10;
        }
        Collections.reverse(digits);
        ArrayList<Integer> bigDigits = new ArrayList<>(digits);
        bigDigits.sort((o1, o2) -> Integer.compare(o2, o1));
        int firstDiffIndex = -1;
        for (int i = 0; i < digits.size(); i++) {
            if (digits.get(i).intValue() != bigDigits.get(i).intValue()) {
                firstDiffIndex = i;
                break;
            }
        }
        if (firstDiffIndex == -1) {
            return num;
        } else {
            int firstDiffValue = bigDigits.get(firstDiffIndex);
            for (int i = digits.size() - 1; i >= 0; i--) {
                if (digits.get(i) == firstDiffValue) {
                    int temp = digits.get(firstDiffIndex);
                    digits.set(firstDiffIndex, firstDiffValue);
                    digits.set(i, temp);
                    break;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < digits.size(); i++) {
            result = result * 10 + digits.get(i);
        }
        return result;
    }
}
