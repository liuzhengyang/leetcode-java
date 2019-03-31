package besttimetobuyandsellstock;

/**
 * @author liuzhengyang
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] array = new int[]{7,1,5,3,6,4};
        System.out.println(new Solution2().maxProfit(array));
    }

    public int maxProfit(int[] prices) {
        int minPrice = -1;
        int maxProfit = 0;
        for (int price : prices) {
            if (minPrice == -1 || minPrice > price) {
                minPrice = price;
            }
            int profitSinceMinPrice = price - minPrice;
            if (profitSinceMinPrice > maxProfit) {
                maxProfit = profitSinceMinPrice;
            }
        }
        return maxProfit;
    }
}
