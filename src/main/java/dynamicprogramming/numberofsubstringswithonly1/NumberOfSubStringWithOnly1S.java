package dynamicprogramming.numberofsubstringswithonly1;

/**
 * 递归加cache
 * f(n+1)=n+1+f(n)
 * f(1)=1
 * f(n)=n + (n-1) + (n-2) + ... + 1
 * @author liuzhengyang
 * 2020/7/30
 */
public class NumberOfSubStringWithOnly1S {
    private static final int MOD = 1000_000_000 + 7;

    public static void main(String[] args) {
        NumberOfSubStringWithOnly1S numberOfSubStringWithOnly1S = new NumberOfSubStringWithOnly1S();
        System.out.println(numberOfSubStringWithOnly1S.numSub("0110111"));
        System.out.println(numberOfSubStringWithOnly1S.numSub("101"));
        System.out.println(numberOfSubStringWithOnly1S.numSub("111111"));
        System.out.println(numberOfSubStringWithOnly1S.numSub("000"));
    }

    public int numSub(String s) {
        char[] chars = s.toCharArray();
        int[] cache = new int[chars.length + 1];
        int sum = 0;
        int currentCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                currentCount ++;
            }
            if (chars[i] == '0' || i == chars.length - 1) {
                if (currentCount > 0) {
                    sum += fun(currentCount, cache);
                    currentCount = 0;
                    sum %= MOD;
                }
            }
        }
        return sum;
    }

    private int fun(int count, int[] cache) {
        if (count == 1) {
            return 1;
        }
        if (cache[count] > 0) {
            return cache[count];
        }
        int result = count + fun(count - 1, cache);
        if (result > MOD) {
            result = result % MOD;
        }
        cache[count] = result;
        return result;
    }
}
