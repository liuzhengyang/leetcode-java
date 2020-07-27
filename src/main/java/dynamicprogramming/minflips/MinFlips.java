package dynamicprogramming.minflips;

/**
 * @author liuzhengyang
 */
public class MinFlips {

    public static void main(String[] args) {
        MinFlips minFlips = new MinFlips();
        System.out.println(minFlips.minFlips("10111"));
        System.out.println(minFlips.minFlips("00000"));
        System.out.println(minFlips.minFlips("001011101"));
    }

    public int minFlips(String target) {
        if (target == null) {
            return 0;
        }
        char[] toCharArray = target.toCharArray();
        return doMinFlip(toCharArray, 0, true);
    }

    /**
     * targetZero 改比较等于0还是等于1
     */
    private int doMinFlip(char[] charArray, int index, boolean targetZero) {
        if (index == charArray.length) {
            return 0;
        }
        // 如果index的值为0，则跳过，使用index+1
        // 如果为1，则翻转，使用index+1
        if ((targetZero && charArray[index] == '0') || (!targetZero && charArray[index] == '1')) {
            return doMinFlip(charArray, index + 1, targetZero);
        } else {
            return 1 + doMinFlip(charArray, index + 1, !targetZero);
        }
    }
}
