package basic.threeconsecutiveodds;

/**
 * https://leetcode.com/problems/three-consecutive-odds/
 * @author liuzhengyang
 */
public class ThreeConsecutiveOdds {
    public static void main(String[] args) {
        ThreeConsecutiveOdds threeConsecutiveOdds = new ThreeConsecutiveOdds();
        System.out.println(threeConsecutiveOdds.threeConsecutiveOdds(new int[]{2,6,4,1}));
        System.out.println(threeConsecutiveOdds.threeConsecutiveOdds(new int[]{1,2,34,3,5,7,23,12}));
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr == null) {
            return false;
        }
        if (arr.length < 3) {
            return false;
        }
        int consecutiveOddsCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & 1) == 1) {
                consecutiveOddsCount ++;
                if (consecutiveOddsCount == 3) {
                    return true;
                }
            } else {
                consecutiveOddsCount = 0;
            }
        }
        return false;
    }
}
