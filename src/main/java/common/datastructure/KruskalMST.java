package common.datastructure;

import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author liuzhengyang
 */
public class KruskalMST {
    public KruskalMST(Graph g) {
        Queue<Edge> queue = new ArrayDeque<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.addAll(g.edges);
        UnionFind uf = new UnionFind(g.vertexCount);
        while (!pq.isEmpty() && queue.size() < g.vertexCount - 1) {
            Edge poll = pq.poll();
            int from = poll.from;
            int to = poll.to;
            if (uf.isConnected(from, to)) {
                continue;
            }
            uf.findAndUnion(from, to);
            queue.add(poll);
        }
    }

    static class Graph {
        List<Edge> edges;
        int vertexCount;
    }

    static class Edge {
        int from;
        int to;
        int weight;
    }
}
