package unionfind.findredundantconnection;

/**
 * https://leetcode.com/problems/redundant-connection/
 * @author liuzhengyang
 * 2020/9/9
 */
public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return null;
        }
        int vertexCount = edges.length;
        UnionFind uf = new UnionFind(vertexCount);
        for (int[] edge : edges) {
            int first = edge[0] - 1;
            int second = edge[1] - 1;
            if (!uf.findAndUnion(first, second)) {
                return edge;
            }
        }
        return null;
    }

    private static class UnionFind {
        private int[] parent;
        private int[] size;
        private int componentCount;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.size[i] = i;
            }
            this.componentCount = n;
        }

        public int getParent(int i) {
            if (parent[i] != i) {
                parent[i] = getParent(parent[i]);
            }
            return parent[i];
        }

        public boolean findAndUnion(int x, int y) {
            int parentX = getParent(x);
            int parentY = getParent(y);
            if (parentX == parentY) {
                return false;
            }
            int sizeX = size[parentX];
            int sizeY = size[parentY];
            if (sizeX < sizeY) {
                parent[parentX] = parentY;
                size[parentY] += sizeX;
            } else {
                parent[parentY] = parentX;
                size[parentX] += sizeY;
            }
            componentCount --;
            return true;
        }
    }
}
