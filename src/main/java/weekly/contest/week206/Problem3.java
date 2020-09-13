package weekly.contest.week206;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

import common.datastructure.UnionFind;

/**
 * @author liuzhengyang
 */
public class Problem3 {
    public static void main(String[] args) {

    }

    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Edge edge = new Edge();
                edge.from = i;
                edge.to = j;
                int[] pointI = points[i];
                int[] pointJ = points[j];
                edge.weight = Math.abs(pointI[0] - pointJ[0]) + Math.abs(pointI[1] - pointJ[1]);
                pq.add(edge);
            }
        }
        int cost = 0;
        Queue<Edge> edgeQueue = new ArrayDeque<>();
        UnionFind uf = new UnionFind(points.length);
        while (!pq.isEmpty() && edgeQueue.size() < points.length - 1) {
            Edge edge = pq.poll();
            int from = edge.from;
            int to = edge.to;
            if (uf.isConnected(from, to)) {
                continue;
            }
            uf.findAndUnion(from, to);
            cost += edge.weight;
            edgeQueue.offer(edge);
        }
        return cost;
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }
}
