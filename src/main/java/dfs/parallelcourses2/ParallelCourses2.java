package dfs.parallelcourses2;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode.com/problems/parallel-courses-ii/
 *
 * @author liuzhengyang
 */
public class ParallelCourses2 {
    public static void main(String[] args) {
        ParallelCourses2 parallelCourses2 = new ParallelCourses2();
//        System.out.println(parallelCourses2.minNumberOfSemesters(4, new int[][]{{2,1},{3,1}, {1,4}}, 2));
//        System.out.println(parallelCourses2.minNumberOfSemesters(5, new int[][]{{2,1},{3,1}, {4,1}, {1,5}}, 2));
//        System.out.println(parallelCourses2.minNumberOfSemesters(11, new int[][]{}, 2));
//        System.out.println(parallelCourses2.minNumberOfSemesters(4, new int[][]{{2,1}, {2,4}}, 2));
//        System.out.println(parallelCourses2.minNumberOfSemesters(12, new int[][]{{1,2}, {1,3}, {7,5}, {7,6}, {4,8}, {8,9}, {9,10}, {10, 11}, {11,12}}, 2));
        System.out.println(parallelCourses2.minNumberOfSemesters(12, new int[][]{{11,10}, {6,3}, {2,5}, {9,2}, {4,12}, {8,7}, {9,5}, {6,2}, {7,2}, {7,4}, {9,3}, {11,1}, {4,3}}, 3));
    }

    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        if (n <= 0) {
            return 0;
        }
        Map<Integer, Set<Integer>> dependencyGraph = buildGraph(n, dependencies);
        Map<Integer, Set<Integer>> reverseDependencyGraph = buildReverseGraph(n, dependencies);
        Map<Integer, Set<Integer>> deepDependency = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            getDeepDependencies(i, dependencyGraph, deepDependency);
        }
        int[] deepCache = new int[n + 1];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            int deep = dfsDeepWithCache(i, reverseDependencyGraph, deepCache);
            priorityQueue.offer(new Node(deep, i));
        }
        int count = 0;
        while (!priorityQueue.isEmpty()) {
            PriorityQueue<Node> nextQueue = new PriorityQueue<>(priorityQueue);
            count ++;
            Set<Integer> thisBatch = new HashSet<>();
            while (thisBatch.size() < k) {
                Node peek = priorityQueue.peek();
                if (peek == null) {
                    break;
                }
                priorityQueue.poll();
                int index = peek.index;
                Set<Integer> thisDeepDependency = deepDependency.getOrDefault(index, Collections.emptySet());
                boolean canAddThisBatch = true;
                for (int prevIndex : thisBatch) {
                    if (thisDeepDependency.contains(prevIndex)) {
                        canAddThisBatch = false;
                        break;
                    }
                }
                if (canAddThisBatch) {
                    thisBatch.add(index);
                    nextQueue.remove(peek);
                }

            }
            priorityQueue = nextQueue;
        }
        return count;
    }

    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] dependencies) {
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for (int[] dependencyEntry : dependencies) {
            int first = dependencyEntry[0];
            int second = dependencyEntry[1];
            result.computeIfAbsent(second, index -> new HashSet<>()).add(first);
        }
        return result;
    }

    private Map<Integer, Set<Integer>> buildReverseGraph(int n, int[][] dependencies) {
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for (int[] dependencyEntry : dependencies) {
            int first = dependencyEntry[0];
            int second = dependencyEntry[1];
            result.computeIfAbsent(first, index -> new HashSet<>()).add(second);
        }
        return result;
    }

    private Set<Integer> getDeepDependencies(int index, Map<Integer, Set<Integer>> directDependencies,
            Map<Integer, Set<Integer>> deepDependencies) {
        Set<Integer> cache = deepDependencies.get(index);
        if (cache != null) {
            return cache;
        }
        Set<Integer> result = new HashSet<>();
        Set<Integer> directDependency = directDependencies.getOrDefault(index, Collections.emptySet());
        result.addAll(directDependency);
        for (int direct : directDependency) {
            result.addAll(getDeepDependencies(direct, directDependencies, deepDependencies));
        }
        deepDependencies.put(index, result);
        return result;
    }

    private int dfsDeepWithCache(int index, Map<Integer, Set<Integer>> dependencyGraph, int[] cache) {
        if (cache[index] > 0) {
            return cache[index];
        }
        int result = 1;
        Set<Integer> dependencies = dependencyGraph.getOrDefault(index, Collections.emptySet());
        for (int dependency : dependencies) {
            result = Math.max(result, 1 + dfsDeepWithCache(dependency, dependencyGraph, cache));
        }
        cache[index] = result;
        return result;
    }

    private static class Node implements Comparable<Node> {

        private final int deep;
        private final int index;

        public Node(int deep, int index) {
            this.deep = deep;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.deep, this.deep);
        }
    }
}
