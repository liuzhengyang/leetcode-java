package p7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Main {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int sign = x / Math.abs(x);
        x = Math.abs(x);
        List<Integer> numbers = new ArrayList<>();
        int origin = x;
        while (origin > 0) {
            numbers.add(origin % 10);
            origin /= 10;
        }
        System.out.println(numbers);
        long result = 0;
        long multiply = 1;
        for (int i = numbers.size() - 1; i >= 0; i--) {
            result += numbers.get(i) * multiply;
            if (numbers.get(i) > 0 && multiply > Integer.MAX_VALUE) {
                return 0;
            }
            multiply *= 10;
        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) (result * sign);
    }
}
