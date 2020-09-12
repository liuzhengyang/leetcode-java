package weekly.final2020;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Problem2 {
    public static void main(String[] args) {

    }

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        if (staple == null || drinks == null) {
            return 0;
        }
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int r = drinks.length - 1;
        int sum = 0;
        for (int i = 0; i < staple.length && staple[i] < x; i++) {
            int first = staple[i];
            while (r >= 0 && first + drinks[r] > x) {
                r--;
            }
            if (r >= 0) {
                sum += r + 1;
                sum %= 1000000007;
            } else {
                break;
            }
        }
        return sum;
    }
}
