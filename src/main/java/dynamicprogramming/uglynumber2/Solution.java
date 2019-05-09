package dynamicprogramming.uglynumber2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        System.out.println(solution.nthUglyNumber(1590));
        System.out.println("Cost " + (System.currentTimeMillis() - start));
    }

    static int[] divides = new int[]{5, 3, 2};
    static int maxNotUglyNumberSet = 5;
    static int notUglyNumber = 0;
    private static Set<Integer> knownUglySet = new HashSet<>();
    private static Set<Integer> notUglySet = new HashSet<>();
    private int knownUglyUpper;

    public int nthUglyNumber(int n) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (!isUglyNumber(++j)) {
                knownUglyUpper = j;
            }
        }
        return j;
    }

    private boolean isUglyNumber(int n) {
        if (n == 1) {
            return true;
        }

        if (n <= knownUglyUpper) {
            return knownUglySet.contains(n);
        }
        boolean isUgly = false;
        boolean cannotBeUgly = false;
        for (int i : notUglySet) {
            if (n % i == 0) {
                cannotBeUgly = true;
                break;
            }
        }
        if (!cannotBeUgly) {
            for (int i : divides) {
                if (n % i == 0) {
                    isUgly = isUglyNumber(n / i);
                    break;
                }
            }
        }

        if (isUgly) {
            knownUglySet.add(n);
        } else {
            if (notUglyNumber ++ < maxNotUglyNumberSet) {
                notUglySet.add(n);
            }
        }
        return isUgly;
    }
}
