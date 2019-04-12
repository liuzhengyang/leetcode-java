package numberofisland;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author liuzhengyang
 */
public class Solution {

    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        char[][] grid = new char[][]
//                {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'},
                {{'1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '1'}, {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0'}, {'1', '0', '1', '1', '1', '0', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1'}, {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {'0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1'}, {'1', '0', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '0'}, {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}};
        //
//        };
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid));
    }

//    private static final int VISITED = 2;
//    private static final int NOT_VISITED = 0;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // init
        ArrayDeque<Position> oneQueue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] - '1' == 0) {
                    oneQueue.offer(new Position(i, j));
                }
            }
        }
        // bfs
        int count = 0;
        while (!oneQueue.isEmpty()) {
            Position position = oneQueue.pollFirst();
            if (grid[position.row][position.col] == '1') {
                bfs(grid, position.row, position.col);
                count++;
            }
        }

        return count;
    }

    private static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static void bfs(char[][] number, int row, int col) {
        if (number[row][col] == '2') {
            return;
        }
        Queue<Position> queue = new ArrayDeque<>();
        number[row][col] = '2';
        queue.offer(new Position(row, col));
        while (!queue.isEmpty()) {
            Position node = queue.remove();
            List<Position> allAdjacent = getAllAdjacent(number, node.row, node.col);
            for (Position pos : allAdjacent) {
                if (number[pos.row][pos.col] == '1') {
                    number[pos.row][pos.col] = '2';
                    queue.offer(new Position(pos.row, pos.col));
                }
            }
        }
    }

    private static List<Position> getAllAdjacent(char[][] number, int row, int col) {
        List<Position> positions = new ArrayList<>();
        if (row > 0) {
            positions.add(new Position(row - 1, col));
        }
        if (row + 1 < number.length) {
            positions.add(new Position(row + 1, col));
        }
        if (col > 0) {
            positions.add(new Position(row, col - 1));
        }
        if (col + 1 < number[row].length) {
            positions.add(new Position(row, col + 1));
        }
        return positions;
    }
}
