package dfs.floodfill;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        bfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void bfs(int[][] image, int row, int col, int oldColor, int newColor) {
        List<int[]> previous = new ArrayList<>();
        List<int[]> next = new ArrayList<>();
        previous.add(new int[]{row, col});
        while (!previous.isEmpty()) {
            for (int[] each : previous) {
                int rowOfEach = each[0];
                int colOfEach = each[1];
                image[rowOfEach][colOfEach] = newColor;

                if (rowOfEach > 0 && image[rowOfEach - 1][colOfEach] == oldColor) {
                    next.add(new int[]{rowOfEach - 1, colOfEach});
                }
                if (rowOfEach < image.length - 1 && image[rowOfEach + 1][colOfEach] == oldColor) {
                    next.add(new int[]{rowOfEach + 1, colOfEach});
                }
                if (colOfEach > 0 && image[rowOfEach][colOfEach - 1] == oldColor) {
                    next.add(new int[]{rowOfEach, colOfEach - 1});
                }
                if (colOfEach < image[rowOfEach].length - 1 && image[rowOfEach][colOfEach + 1] == oldColor) {
                    next.add(new int[]{rowOfEach, colOfEach + 1});
                }
            }
            previous = next;
            next = new ArrayList<>();
        }
    }
}
