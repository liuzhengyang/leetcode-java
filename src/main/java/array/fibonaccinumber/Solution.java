package array.fibonaccinumber;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(1));
        System.out.println(solution.fib(0));
        System.out.println(solution.fib(5));
        System.out.println(solution.fib(4));
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(2));
    }

    public int fib(int N) {
        int fn_1 = 0;
        int fn = 1;
        int i = 0;
        while (i ++ < N) {
            int newFn = fn + fn_1;
            fn_1 = fn;
            fn = newFn;
        }
        return fn_1;
    }
}
