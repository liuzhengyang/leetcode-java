package p564;

/**
 * @author liuzhengyang
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new Solution().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new Solution().maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (prices.length == 1) {
            return 0;
        }
        int buyPoint = -1;
        int lastPoint = 0;
        int scanPoint = 1;
        int totalProfit = 0;
        while (true) {
            if (scanPoint >= prices.length) {
                break;
            }
            if (prices[scanPoint] > prices[lastPoint] && buyPoint < 0) {
                buyPoint = lastPoint;
            } else if (prices[scanPoint] < prices[lastPoint] && buyPoint > -1) {
                totalProfit += prices[lastPoint] - prices[buyPoint];
                buyPoint = -1;
            }
            lastPoint ++;
            scanPoint++;
        }
        if (buyPoint > -1) {
            totalProfit += prices[prices.length - 1] - prices[buyPoint];
        }
        return totalProfit;
    }
}
