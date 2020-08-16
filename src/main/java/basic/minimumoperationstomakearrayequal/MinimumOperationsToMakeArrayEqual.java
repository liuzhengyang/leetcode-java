package basic.minimumoperationstomakearrayequal;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-array-equal/
 * 等差数列公式
 * @author liuzhengyang
 */
public class MinimumOperationsToMakeArrayEqual {
    public static void main(String[] args) {
        MinimumOperationsToMakeArrayEqual minimumOperationsToMakeArrayEqual = new MinimumOperationsToMakeArrayEqual();
        System.out.println(minimumOperationsToMakeArrayEqual.minOperations(3));
        System.out.println(minimumOperationsToMakeArrayEqual.minOperations(6));
    }

    public int minOperations(int n) {
        if ((n & 1) == 1) {
            return (n * n - 1) / 4;
        } else {
            return (n * n) / 4;
        }
    }
}
