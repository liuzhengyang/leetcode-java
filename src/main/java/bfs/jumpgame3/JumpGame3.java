package bfs.jumpgame3;

import java.util.ArrayList;
import java.util.List;

/**
 * 图遍历，bfs
 *
 * @author liuzhengyang
 * 2020/7/10
 */
public class JumpGame3 {
    public static void main(String[] args) {
        System.out.println(new JumpGame3().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println(new JumpGame3().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
        System.out.println(new JumpGame3().canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }

    public boolean canReach(int[] arr, int start) {
        if (arr == null || start < 0 || start >= arr.length) {
            return false;
        }
        boolean[] visited = new boolean[arr.length];
        List<Integer> prev = new ArrayList<>();
        List<Integer> next = new ArrayList<>();
        prev.add(start);
        while (!prev.isEmpty()) {
            for (int index : prev) {
                visited[index] = true;
                if (arr[index] == 0) {
                    return true;
                }
                int targetIndexByAdd = index + arr[index];
                if (0 <= targetIndexByAdd && targetIndexByAdd < arr.length && !visited[targetIndexByAdd]) {
                    next.add(targetIndexByAdd);
                }
                int targetIndexBySubtract = index - arr[index];
                if (0 <= targetIndexBySubtract && targetIndexBySubtract < arr.length && !visited[targetIndexBySubtract]) {
                    next.add(targetIndexBySubtract);
                }
            }
            prev = next;
            next = new ArrayList<>();
        }
        return false;
    }
}
