package common.datastructure;

/**
 * @author liuzhengyang
 */
public class UnionFind {
    private int[] parent;
    private int[] size;
    private int componentCount = 0;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        componentCount = n;
    }

    public boolean findAndUnion(int x, int y) {
        int parentX = getParent(x);
        int parentY = getParent(y);
        if (parentX == parentY) {
            return false;
        }
        union(x, y);
        return true;
    }

    public void union(int x, int y) {
        int parentX = getParent(x);
        int parentY = getParent(y);
        if (parentX == parentY) {
            return;
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
        componentCount--;
    }

    public int getParent(int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = getParent(parent[i]);
        return parent[i];
    }

    public boolean isConnected(int x, int y) {
        return getParent(x) == getParent(y);
    }

    public int count() {
        return componentCount;
    }
}
