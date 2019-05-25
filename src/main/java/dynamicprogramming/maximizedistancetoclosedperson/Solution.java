package dynamicprogramming.maximizedistancetoclosedperson;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(solution.maxDistToClosest(new int[]{1, 0, 0, 0}));
    }

    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) {
            return 0;
        }
        int[] cache = new int[seats.length];
        Arrays.fill(cache, Integer.MAX_VALUE);
        int max = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                flip(seats, cache, i);
                cache[i] = 0;
            }
        }
        for (int i = 0; i < seats.length; i++) {
            if (cache[i] > max) {
                max = cache[i];
            }
        }
        return max;
    }

    private void flip(int[] seats, int cache[], int index) {
        for (int i = index + 1; i < seats.length; i++) {
            if (seats[i] == 0) {
                cache[i] = Math.min(cache[i], i - index);
            } else {
                break;
            }
        }
        for (int i = index - 1; i >= 0; i--) {
            if (seats[i] == 0) {
                cache[i] = Math.min(cache[i], index - i);
            } else {
                break;
            }
        }
    }
}
