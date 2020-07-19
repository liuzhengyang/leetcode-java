package basic.numwaterbottles;

/**
 * @author liuzhengyang
 */
public class NumWaterBottles {
    public static void main(String[] args) {
        NumWaterBottles numWaterBottles = new NumWaterBottles();
        System.out.println(numWaterBottles.numWaterBottles(9, 3));
        System.out.println(numWaterBottles.numWaterBottles(15,4));
        System.out.println(numWaterBottles.numWaterBottles(5, 5));
        System.out.println(numWaterBottles.numWaterBottles(2, 3));
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int totalBottles = numBottles;
        int leftBottles = totalBottles;
        while (leftBottles >= numExchange) {
            int newLeftBottles = (leftBottles / numExchange) + (leftBottles % numExchange);
            totalBottles += leftBottles / numExchange;
            leftBottles = newLeftBottles;
        }
        return totalBottles;
    }
}
