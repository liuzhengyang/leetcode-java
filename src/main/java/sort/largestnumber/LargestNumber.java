package sort.largestnumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhengyang
 * 2020/7/8
 */
public class LargestNumber {

    public static void main(String[] args) {
        String result = new LargestNumber().largestNumber(new int[]{9, 0, 1});
        System.out.println(result);
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<Integer> sortedNumbers = new ArrayList<>();
        for (int num : nums) {
            sortedNumbers.add(num);
        }
        sortedNumbers.sort(this::doCompare);
        if (sortedNumbers.get(0) == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (int num : sortedNumbers) {
            result.append(num);
        }
        return result.toString();
    }

    private int doCompare(int a, int b) {
        return - Long.compare(a * minPowerOf10LargerThan(b) + b, b * minPowerOf10LargerThan(a) + a);
    }

    private long minPowerOf10LargerThan(int num) {
        long l = 10;
        while (l <= num) {
            l *= 10;
        }
        return l;
    }
}
