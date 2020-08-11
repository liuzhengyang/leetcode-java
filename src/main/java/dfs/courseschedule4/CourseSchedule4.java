package dfs.courseschedule4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule-iv/description/
 * 查询比较多，构建一个所有节点的深度依赖（包含直接依赖和依赖的深度依赖），用深度依赖查询是否有依赖
 * 首先构建依赖图，然后dfs构建深度依赖图，最后返回查询结果
 *
 * @author liuzhengyang
 * 2020/8/11
 */
public class CourseSchedule4 {
    public static void main(String[] args) {
        CourseSchedule4 courseSchedule4 = new CourseSchedule4();
        System.out.println(courseSchedule4.checkIfPrerequisite(2, new int[][]{{1,0}}, new int[][]{{0,1}, {1,0}}));
        System.out.println(courseSchedule4.checkIfPrerequisite(2, new int[][]{}, new int[][]{{0,1}, {1,0}}));
        System.out.println(courseSchedule4.checkIfPrerequisite(3, new int[][]{{1,2},{1,0},{2,0}}, new int[][]{{1,0}, {1,2}}));
        System.out.println(courseSchedule4.checkIfPrerequisite(3, new int[][]{{1,0},{2,0}}, new int[][]{{0,1}, {2,0}}));
        System.out.println(courseSchedule4.checkIfPrerequisite(5, new int[][]{{0,1},{1,2},{2,3}, {3,4}}, new int[][]{{0,4}, {4,0},{0,3}, {3,0}}));
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        if (n <= 0 || queries == null) {
            return Collections.emptyList();
        }
        if (prerequisites == null) {
            prerequisites = new int[][]{};
        }
        // build graph
        Map<Integer, Set<Integer>> dependencyGraph = new HashMap<>();
        for (int[] dependency : prerequisites) {
            int first = dependency[0];
            int second = dependency[1];
            dependencyGraph.computeIfAbsent(second, key -> new HashSet<>()).add(first);
        }
        // dfs with cache
        Map<Integer, Set<Integer>> deepDependencies = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!deepDependencies.containsKey(i)) {
                findDeepDependencies(i, dependencyGraph, deepDependencies);
            }
        }
        List<Boolean> result = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            int first = query[0];
            int second = query[1];
            result.add(deepDependencies.getOrDefault(second, Collections.emptySet()).contains(first));
        }
        return result;
    }

    private Set<Integer> findDeepDependencies(int i, Map<Integer, Set<Integer>> dependencyGraph, Map<Integer, Set<Integer>> deepDependencies) {
        Set<Integer> dependencies = deepDependencies.get(i);
        if (dependencies != null) {
            return dependencies;
        }
        Set<Integer> directDependencies = dependencyGraph.getOrDefault(i, Collections.emptySet());
        Set<Integer> result = new HashSet<>(directDependencies);
        for (int dependency : directDependencies) {
            result.addAll(findDeepDependencies(dependency, dependencyGraph, deepDependencies));
        }
        deepDependencies.put(i, result);
        return result;
    }
}
