package weekly.contest.week203;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Problem1 {
    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        System.out.println(problem1.mostVisited(4, new int[] {1, 3, 1, 2}));
        System.out.println(problem1.mostVisited(2, new int[] {2, 1, 2, 1, 2, 1, 2, 1, 2}));
        System.out.println(problem1.mostVisited(7, new int[] {1, 3, 5, 7}));
    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] counter = new int[n + 1];
        int currentPos = rounds[0];
        for (int i = 1; i < rounds.length; i++) {
            int end = rounds[i];
            while (true) {
                boolean breakCircle = currentPos == end;
                counter[currentPos]++;
                currentPos++;
                if (currentPos > n) {
                    currentPos %= n;
                }
                if (breakCircle) {
                    break;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < counter.length; i++) {
            max = Math.max(max, counter[i]);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == max) {
                result.add(i);
            }
        }
        return result;
    }
}
