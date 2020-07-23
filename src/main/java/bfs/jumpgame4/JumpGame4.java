package bfs.jumpgame4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 本质上是一个无权重的单源最短路径问题，可以用bfs来解决。
 * 使用通用的bfs写法超时，对内存使用进行一些优化。
 *
 * 另外这里简单用dfs+dp的方式是行不通的，因为有环的问题
 *
 * @author liuzhengyang
 */
public class JumpGame4 {
    public static void main(String[] args) {
        JumpGame4 jumpGame4 = new JumpGame4();
        System.out.println(jumpGame4.minJumps(new int[] {100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
        System.out.println(jumpGame4.minJumps(new int[] {7}));
        System.out.println(jumpGame4.minJumps(new int[] {7, 6, 9, 6, 9, 6, 9, 7}));
        System.out.println(jumpGame4.minJumps(
                new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
                        7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 11}));
    }

    public int minJumps(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        // 计算value到所有index的映射
        Map<Integer, List<Integer>> valueToIndexListMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            valueToIndexListMap.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }
        int[] shortedPath = new int[arr.length];
        Arrays.fill(shortedPath, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        shortedPath[0] = 0;
        Set<Integer> visitedSameValue = new HashSet<>();
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (index + 1 < arr.length && shortedPath[index + 1] == -1) {
                shortedPath[index + 1] = shortedPath[index] + 1;
                if (index + 1 == arr.length - 1) {
                    return shortedPath[index + 1];
                }
                queue.add(index + 1);
            }
            if (index - 1 >= 0 && shortedPath[index - 1] == -1) {
                shortedPath[index - 1] = shortedPath[index] + 1;
                queue.add(index - 1);
            }
            if (!visitedSameValue.contains(arr[index])) {
                List<Integer> sameValueIndexes = valueToIndexListMap.get(arr[index]);
                visitedSameValue.add(arr[index]);
                if (sameValueIndexes != null) {
                    for (int sameValueIndex : sameValueIndexes) {
                        if (shortedPath[sameValueIndex] == -1) {
                            shortedPath[sameValueIndex] = shortedPath[index] + 1;
                            if (sameValueIndex == arr.length - 1) {
                                return shortedPath[sameValueIndex];
                            }
                            queue.add(sameValueIndex);
                        }
                    }
                }
            }
        }
        return 0;
    }

}
