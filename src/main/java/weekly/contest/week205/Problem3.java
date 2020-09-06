package weekly.contest.week205;

/**
 * @author liuzhengyang
 */
public class Problem3 {
    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.minCost("aabaa", new int[]{1,2,3,4,1}));
    }

    public int minCost(String s, int[] cost) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int total = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                endIndex ++;
                if (i == chars.length - 1) {
                    if (startIndex < endIndex) {
                        int maxCost = cost[startIndex];
                        int thisTotalCost = 0;
                        for (int j = startIndex; j <= endIndex; j++) {
                            thisTotalCost += cost[j];
                            maxCost = Math.max(maxCost, cost[j]);
                        }
                        thisTotalCost -= maxCost;
                        total += thisTotalCost;
                    }
                }
            } else {
                if (startIndex < endIndex) {
                    int maxCost = cost[startIndex];
                    int thisTotalCost = 0;
                    for (int j = startIndex; j <= endIndex; j++) {
                        thisTotalCost += cost[j];
                        maxCost = Math.max(maxCost, cost[j]);
                    }
                    thisTotalCost -= maxCost;
                    total += thisTotalCost;
                }
                startIndex = i;
                endIndex = i;
            }
        }
        return total;
    }
}
