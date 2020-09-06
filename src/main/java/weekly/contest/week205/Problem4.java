package weekly.contest.week205;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import common.datastructure.UnionFind;

/**
 * https://leetcode-cn.com/contest/weekly-contest-205/problems/remove-max-number-of-edges-to-keep-graph-fully
 * -traversable/
 *
 * @author liuzhengyang
 */
public class Problem4 {
    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        System.out.println(problem4.maxNumEdgesToRemove(4, new int[][]{{3,1,2}, {3,2,3}, {1,1,3}, {1,2,4}, {1,1,2}, {2,3,4}}));
        System.out.println(problem4.maxNumEdgesToRemove(4, new int[][]{{3,2,3}, {1,1,2}, {2,3,4}}));
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        if (n <= 0 || edges == null) {
            return -1;
        }
        UnionFind ufa = new UnionFind(n);
        UnionFind ufb = new UnionFind(n);
        int type3AddCount = 0;
        for (int[] edge : edges) {
            int type = edge[0];
            int first = edge[1] - 1;
            int second = edge[2] - 1;
            if (type == 3) {
                if (ufa.findAndUnion(first, second)) {
                    type3AddCount++;
                }
                ufb.findAndUnion(first, second);
            }
        }
        // Alice
        int addCountA = 0;
        for (int[] edge : edges) {
            int type = edge[0];
            int first = edge[1] - 1;
            int second = edge[2] - 1;
            if (type == 1) {
                if (ufa.findAndUnion(first, second)) {
                    addCountA++;
                }
            }
        }
        if (ufa.count() > 1) {
            return -1;
        }
        int addCountB = 0;
        for (int[] edge : edges) {
            int type = edge[0];
            int first = edge[1] - 1;
            int second = edge[2] - 1;
            if (type == 2) {
                if (ufb.findAndUnion(first, second)) {
                    addCountB++;
                }
            }
        }
        if (ufb.count() > 1) {
            return -1;
        }
        return edges.length - addCountA - addCountB - type3AddCount;
    }
}
