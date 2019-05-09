package dynamicprogramming.minimumcostfortickets;

/**
 * @author liuzhengyang
 */
public class Solution {

    public static void main(String[] args) {

    }

    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || costs == null) {
            return 0;
        }
        cache = new int[days.length + 1];
        return minCost(0, days, costs);
    }

    private int[] cache;

    static int[] passDays = new int[]{1, 7, 30};

    private int minCost(int index, int[] days, int[] costs) {
        if (cache[index] > 0) {
            return cache[index];
        }
        if (index == days.length) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < passDays.length; i++) {
            int thisCost = costs[i] + minCost(getNextIndex(index, passDays[i], days), days, costs);
            min = Math.min(thisCost, min);
        }
        cache[index] = min;
        return min;
    }

    private int getNextIndex(int currentIndex, int daysAdded, int[] days) {
        int currentDay = days[currentIndex];
        for (int i = currentIndex; i < days.length; i++) {
            if (currentDay + daysAdded <= days[i]) {
                return i;
            }
        }
        return days.length;
    }
}
