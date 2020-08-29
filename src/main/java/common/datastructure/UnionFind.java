package common.datastructure;

/**
 * @author liuzhengyang
 */
public class UnionFind {
    private int[] parent;
    private int[] size;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public boolean union(int x, int y) {
        int parentX = getParent(x);
        int parentY = getParent(y);
        if (parentX == parentY) {
            return false;
        }
        int sizeX = size[parentX];
        int sizeY = size[parentY];
        if (sizeX < sizeY) {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        } else {
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        }
        return true;
    }

    public int getParent(int i) {
        while (parent[i] != i) {
            parent[i] = getParent(parent[i]);
        }
        return parent[i];
    }
}
