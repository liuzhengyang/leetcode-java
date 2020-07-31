package bfs.pathwithmaximumprobability;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 首先根据edges和prob构建图，以及对应的边的概率prob
 * 从start开始遍历图，用一个Map<Integer, Double>记录所有已经遍历过的位置和对应的概率prob，如果遇到已经遍历过的节点并且当前的
 * 路径的概率比之前大则替换，如果没有遇到过放到map中，否则说明没有可遍历的了，结束。
 * @author liuzhengyang
 */
public class PathWithMaximumProbability {
    public static void main(String[] args) {
        PathWithMaximumProbability pathWithMaximumProbability = new PathWithMaximumProbability();
        System.out.println(pathWithMaximumProbability.maxProbability(3, new int[][]{{0,1}, {1,2}, {0,2}}, new double[]{0.5,0.5,0.2}, 0, 2));
        System.out.println(pathWithMaximumProbability.maxProbability(3, new int[][]{{0,1}, {1,2}, {0,2}}, new double[]{0.5,0.5,0.3}, 0, 2));
        System.out.println(pathWithMaximumProbability.maxProbability(3, new int[][]{{0,1}}, new double[]{0.5}, 0, 2));
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        if (edges == null || edges.length == 0 || n <= 0) {
            return 0;
        }
        Map<Integer, Map<Integer, Double>> edgesWithProb = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int first = edge[0];
            int second = edge[1];
            double prob = succProb[i];
            Map<Integer, Double> firstEdges = edgesWithProb.computeIfAbsent(first, k -> new HashMap<>());
            firstEdges.put(second, prob);
            Map<Integer, Double> secondEdges = edgesWithProb.computeIfAbsent(second, k -> new HashMap<>());
            secondEdges.put(first, prob);
        }
        Map<Integer, Double> knownPointWithProb = new ConcurrentHashMap<>();
        knownPointWithProb.put(start, 1D);
        while (true) {
            AtomicBoolean changed = new AtomicBoolean(false);
            knownPointWithProb.forEach((currentPoint, currentProb) -> {
                Map<Integer, Double> edgesAndProb = edgesWithProb.get(currentPoint);
                if (edgesAndProb != null) {
                    edgesAndProb.forEach((edge, prob) -> {
                        Double knownProb = knownPointWithProb.get(edge);
                        if (knownProb == null || knownProb < currentProb * prob) {
                            changed.set(true);
                            knownPointWithProb.put(edge, currentProb * prob);
                        }
                    });
                }
            });
            if (!changed.get()) {
                break;
            }
        }
        return knownPointWithProb.getOrDefault(end, 0D);
    }
}
