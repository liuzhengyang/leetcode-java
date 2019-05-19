package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author liuzhengyang
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        int i = new LastStoneWeight().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        System.out.println(i);
        System.out.println(new LastStoneWeight().lastStoneWeight(new int[]{2, 2}));
    }

    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        for (int stone : stones) {
            heap.add(stone);
        }
        while (heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();
            if (first != second) {
                heap.add(Math.abs(first - second));
            }
        }
        return heap.size() >= 1 ? heap.poll() : 0;
    }
}
