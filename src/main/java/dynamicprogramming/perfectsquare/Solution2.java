package dynamicprogramming.perfectsquare;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liuzhengyang
 */
public class Solution2 {
    public static void main(String[] args) {
        int num = new Solution().numSquares(12);
        System.out.println(num);
    }

    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        return bfs(n);
    }

    private int bfs(int n) {
        List<Integer> allSquares = new ArrayList<>();
        for (int i = 0; i * i <= n; i++) {
            allSquares.add(i);
        }

        Set<Integer> previous = new HashSet<>();
        Set<Integer> next = new HashSet<>();
        previous.add(n);
        int count = 0;
        while (!previous.isEmpty()) {
            count ++;
            for (Integer i : previous) {
                for (int j : allSquares) {
                    if (j * j == i) {
                        return count;
                    }
                    if (j * j > i) {
                        break;
                    }
                    next.add(i - allSquares.get(j) * allSquares.get(j));
                }
            }
            previous = next;
            next = new HashSet<>();
        }

        return count;
    }
}
