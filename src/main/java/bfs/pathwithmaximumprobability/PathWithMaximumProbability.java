package bfs.pathwithmaximumprobability;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 首先根据edges和prob构建图，以及对应的边的概率prob
 * 从start开始遍历图，用一个Map<Integer, Double>记录所有已经遍历过的位置和对应的概率prob，如果遇到已经遍历过的节点并且当前的
 * 路径的概率比之前大则替换，如果没有遇到过放到map中，否则说明没有可遍历的了，结束。
 *
 * 优化版本，使用Queue代替Map，queue中取出的元素如果带来了更大概率的边或新边，则加入到队列中
 * @author liuzhengyang
 */
public class PathWithMaximumProbability {
    public static void main(String[] args) {
        PathWithMaximumProbability pathWithMaximumProbability = new PathWithMaximumProbability();
        System.out.println(pathWithMaximumProbability.maxProbability(3, new int[][]{{0,1}, {1,2}, {0,2}}, new double[]{0.5,0.5,0.2}, 0, 2));
        System.out.println(pathWithMaximumProbability.maxProbability(3, new int[][]{{0,1}, {1,2}, {0,2}}, new double[]{0.5,0.5,0.3}, 0, 2));
        System.out.println(pathWithMaximumProbability.maxProbability(3, new int[][]{{0,1}}, new double[]{0.5}, 0, 2));
    }

    private static class EdgeAndProb {
        private final int edge;
        private final double prob;

        public EdgeAndProb(int edge, double prob) {
            this.edge = edge;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        if (edges == null || edges.length == 0 || n <= 0) {
            return 0;
        }
        Map<Integer, Map<Integer, Double>> edgesWithProbMap = buildGraph(edges, succProb);
        double[] probs = new double[n];
        Queue<EdgeAndProb> queue = new LinkedList<>();
        queue.add(new EdgeAndProb(start, 1));
        while (!queue.isEmpty()) {
            EdgeAndProb edgeAndProb = queue.poll();
            int currentEdge = edgeAndProb.edge;
            double currentProb = edgeAndProb.prob;
            Map<Integer, Double> edgesWithProb = edgesWithProbMap.get(currentEdge);
            if (edgesWithProb != null) {
                edgesWithProb.forEach((edge, prob) -> {
                    if (prob * currentProb > probs[edge]) {
                        probs[edge] = prob * currentProb;
                        queue.offer(new EdgeAndProb(edge, probs[edge]));
                    }
                });
            }
        }
        return probs[end];
    }

    private Map<Integer, Map<Integer, Double>> buildGraph(int[][] edges, double[] succProb) {
        Map<Integer, Map<Integer, Double>> edgesWithProbMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int first = edge[0];
            int second = edge[1];
            double prob = succProb[i];
            edgesWithProbMap.computeIfAbsent(first, k -> new HashMap<>()).put(second, prob);
            edgesWithProbMap.computeIfAbsent(second, k -> new HashMap<>()).put(first, prob);
        }
        return edgesWithProbMap;
    }
}
