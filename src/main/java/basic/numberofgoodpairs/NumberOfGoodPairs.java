package basic.numberofgoodpairs;

/**
 * @author liuzhengyang
 */
public class NumberOfGoodPairs {
    public static void main(String[] args) {
        NumberOfGoodPairs numberOfGoodPairs = new NumberOfGoodPairs();
        System.out.println(numberOfGoodPairs.numIdenticalPairs(new int[] {1, 2, 3, 1, 1, 3}));
        System.out.println(numberOfGoodPairs.numIdenticalPairs(new int[] {1, 1, 1, 1}));
        System.out.println(numberOfGoodPairs.numIdenticalPairs(new int[] {1, 2, 3}));
    }

    private static final int MAX_NUM = 100;

    public int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] counts = new int[MAX_NUM + 1];
        for (int num : nums) {
            counts[num] += 1;
        }
        int sum = 0;
        for (int count : counts) {
            sum += fun(count);
        }
        return sum;
    }

    private int fun(int count) {
        return count * (count - 1) / 2;
    }
}
