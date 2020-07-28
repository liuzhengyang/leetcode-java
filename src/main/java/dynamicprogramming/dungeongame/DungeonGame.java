package dynamicprogramming.dungeongame;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class DungeonGame {
    public static void main(String[] args) {

    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 1;
        }
        int[][] cache = new int[dungeon.length][];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = new int[dungeon[i].length];
        }
        return dp(dungeon, 0, 0, cache);
    }

    private int dp(int[][] dungeon, int row, int col, int[][] cache) {
        if (cache[row][col] > 0) {
            return cache[row][col];
        }
        if (row == cache.length - 1 && col == cache[0].length - 1) {
            int result = Math.max(1, 1 - dungeon[row][col]);
            cache[row][col] = result;
            return result;
        } else if (row == cache.length - 1) {
            int right = dp(dungeon, row, col + 1, cache);
            int result = Math.max(1, right - dungeon[row][col]);
            cache[row][col] = result;
            return result;
        } else if (col == cache[0].length - 1) {
            int down = dp(dungeon, row + 1, col, cache);
            int result = Math.max(1, down - dungeon[row][col]);
            cache[row][col] = result;
            return result;
        } else {
            int right = dp(dungeon, row, col + 1, cache);
            int down = dp(dungeon, row + 1, col, cache);
            int min = Math.min(right - dungeon[row][col], down - dungeon[row][col]);
            int result = Math.max(1, min);
            cache[row][col] = result;
            return result;
        }
    }
}
