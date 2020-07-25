package basic;

/**
 * @author liuzhengyang
 */
public class CountOdds {
    public static void main(String[] args) {

    }

    public int countOdds(int low, int high) {
        boolean firstIsOdd = low % 2 == 1;
        boolean secondIsOdd = high % 2 == 1;
        if (firstIsOdd) {
            if (secondIsOdd) {
                return (high - low + 1) / 2 + 1;
            } else {
                return (high - low + 1) / 2 + 1;
            }
        } else {
            if (secondIsOdd) {
                return (high - low) / 2 + 1;
            } else {
                return (high - low) / 2;
            }
        }
    }
}
