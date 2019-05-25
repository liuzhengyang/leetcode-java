package array.maxincreasetokeepcityskyline;

public class Solution {
    public static void main(String[] args) {

    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        int[] maxInRow = new int[height];
        int[] maxInColumn = new int[width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maxInColumn[j] = Math.max(maxInColumn[j], grid[i][j]);
                maxInRow[i] = Math.max(maxInRow[i], grid[i][j]);
            }
        }
        int sum = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sum += (Math.min(maxInRow[i], maxInColumn[j]) - grid[i][j]);
            }
        }
        return sum;
    }
}
