package dfs.courseschedule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            vertices.add(new Vertex(i));
        }
        for (int[] prerequisite : prerequisites) {
            int first = prerequisite[0];
            int second = prerequisite[1];
            vertices.get(second).adj.add(vertices.get(first));
        }
        for (Vertex vertex : vertices) {
            if (vertex.color == 0) {
                if (!dfs(vertex)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(Vertex vertex) {
        if (vertex.color == 1) {
            return false;
        }
        vertex.color = 1;
        for (Vertex each : vertex.adj) {
            if (!dfs(each)) {
                return false;
            }
        }
        vertex.color = 2;
        return true;
    }

    static class Vertex {
        int val;
        int color;
        List<Vertex> adj;

        public Vertex(int val) {
            this.val = val;
            adj = new ArrayList<>();
        }
    }
}
