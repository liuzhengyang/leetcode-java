package dfs.keysandrooms;

import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    private int[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.isEmpty()) {
            return true;
        }
        visited = new int[rooms.size()];
        dfs(0, rooms);

        boolean canVisiteAll = true;
        for (int visit : visited) {
            if (visit == 0) {
                canVisiteAll = false;
                break;
            }
        }

        return canVisiteAll;
    }

    private void dfs(int index, List<List<Integer>> rooms) {
        visited[index] = 1;
        for (Integer key : rooms.get(index)) {
            if (visited[key] == 0) {
                dfs(key, rooms);
            }
        }
        visited[index] = 2;
    }
}
