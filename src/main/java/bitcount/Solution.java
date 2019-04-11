package bitcount;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(1));
        System.out.println(solution.hammingWeight(3));
        System.out.println(solution.hammingWeight(-3));
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 0x1) == 1) {
                count ++;
            }
            n >>>= 1;
        }
        return count;
    }
}
