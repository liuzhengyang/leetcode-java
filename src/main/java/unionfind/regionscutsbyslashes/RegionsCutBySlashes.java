package unionfind.regionscutsbyslashes;

import common.datastructure.UnionFind;

/**
 * 每个region按照斜线分割的上下左右分为4块，分别编号。然后遍历每个region，首先把一个region内的4个块按照斜线分组放到并查集中
 * 然后如果右边有region，则把右模块和右边的左模块相连。如果下边有region，则把下模块和下边的上模块相连。最终并查集的连通块数量就是答案
 * https://leetcode-cn.com/problems/regions-cut-by-slashes/
 * @author liuzhengyang
 */
public class RegionsCutBySlashes {
    public static void main(String[] args) {
        RegionsCutBySlashes regionsCutBySlashes = new RegionsCutBySlashes();
        System.out.println(regionsCutBySlashes.regionsBySlashes(new String[]{"//", "/ "}));
        System.out.println(regionsCutBySlashes.regionsBySlashes(new String[]{"\\/", "/\\"}));
        System.out.println(regionsCutBySlashes.regionsBySlashes(new String[]{" /", "/ "}));
    }

    public int regionsBySlashes(String[] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int length = grid.length;
        UnionFind uf = new UnionFind(length * length * 4);
        char[][] chars = new char[length][length];
        boolean[][] visited = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            chars[i] = grid[i].toCharArray();
            visited[i] = new boolean[length];
        }
        visit(0, 0, uf, chars, length, visited);
        return uf.count();
    }

    private void visit(int x, int y, UnionFind uf, char[][] grid, int length, boolean[][] visited) {
        visited[x][y] = true;
        char c = grid[x][y];
        int gridIndex = 4 * (x + y * length);
        if (c == ' ') {
            uf.findAndUnion(gridIndex, gridIndex + 1);
            uf.findAndUnion(gridIndex + 1, gridIndex + 2);
            uf.findAndUnion(gridIndex + 2, gridIndex + 3);
        } else if (c == '/') {
            uf.findAndUnion(gridIndex, gridIndex + 2);
            uf.findAndUnion(gridIndex + 1, gridIndex + 3);
        } else {
            uf.findAndUnion(gridIndex, gridIndex + 3);
            uf.findAndUnion(gridIndex + 1, gridIndex + 2);
        }
        if (y + 1 < length) {
            int downIndex = 4 * (x + (y + 1) * length);
            uf.findAndUnion(gridIndex + 1, downIndex);
        }
        if (x + 1 < length) {
            int rightIndex = 4 * (x + 1 + y * length);
            uf.findAndUnion(gridIndex + 3, rightIndex + 2);
        }
        if (y + 1 < length && !visited[x][y + 1]) {
            visit(x, y + 1, uf, grid, length, visited);
        }
        if (x + 1 < length && !visited[x + 1][y]) {
            visit(x + 1, y, uf, grid, length, visited);
        }
    }
}
