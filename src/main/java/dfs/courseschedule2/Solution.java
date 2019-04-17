package dfs.courseschedule2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
//4, [[1,0],[2,0],[3,1],[3,2]]
        Solution solution = new Solution();
        int[][] pre = new int[4][];
        pre[0] = new int[]{1,0};
        pre[1] = new int[]{2,0};
        pre[2] = new int[]{3,1};
        pre[3] = new int[]{3,2};
        System.out.println(Arrays.toString(solution.findOrder(4, pre)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Vertex> vertexList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            vertexList.add(new Vertex(i));
        }
        for (int[] dependency : prerequisites) {
            int first = dependency[0];
            int second = dependency[1];
            vertexList.get(first).dependencies.add(vertexList.get(second));
        }
        List<Integer> path = new ArrayList<>();
        for (Vertex vertex : vertexList) {
            if (vertex.color == 0) {
                if (!dfs(path, vertex)) {
                    return new int[]{};
                }
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < path.size(); i++) {
            result[i] = path.get(i);
        }
        return result;
    }

    private boolean dfs(List<Integer> path, Vertex vertex) {
        if (vertex.color == 1) {
            return false;
        }
        vertex.color = 1;
        for (Vertex dep : vertex.dependencies) {
            if (dep.color != 2) {
                if (!dfs(path, dep)) {
                    return false;
                }
            }
        }
        vertex.color = 2;
        path.add(vertex.val);
        return true;
    }

    static class Vertex {
        int val;
        List<Vertex> dependencies;
        /**
         * 0 mean white, 1 means gray, 2 means black
         */
        int color;

        public Vertex(int val) {
            this.val = val;
            dependencies = new ArrayList<>();
        }
    }
}
