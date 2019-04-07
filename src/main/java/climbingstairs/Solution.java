package climbingstairs;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int fn1 = 1;
        int fn2 = 2;
        for (int i = 0; i < n - 2; i++) {
            int tmp = fn2;
            fn2 = fn1 + fn2;
            fn1 = tmp;
        }
        return fn2;
    }
}
