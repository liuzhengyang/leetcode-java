package weekly.contest.biweek34;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-34/problems/count-all-possible-routes/
 * @author liuzhengyang
 */
public class Problem4 {
    public static void main(String[] args) {

    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        if (locations == null || locations.length == 0) {
            return 0;
        }
        int[][] fuelCountMap = new int[locations.length][];
        for (int i = 0; i < locations.length; i++) {
            fuelCountMap[i] = new int[fuel];
        }
        // bfs
        int[] fuelCount = fuelCountMap[start];
        fuelCount[fuel] = 1;
        List<Integer> prev = new ArrayList<>();
        prev.add(start);
        while (true) {
            boolean changed = false;
            if (changed) {
                break;
            }
            for (int location : prev) {

            }
        }
        return 0;
    }
}
