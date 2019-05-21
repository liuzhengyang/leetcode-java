package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liuzhengyang
 */
public class LastStoneWeight2 {

    public static void main(String[] args) {
        LastStoneWeight2 lastStoneWeight2 = new LastStoneWeight2();
        System.out.println(lastStoneWeight2.lastStoneWeightII(new int[]{2,7,4,1,8,1}));
    }

    public int lastStoneWeightII(int[] stones) {
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
            Integer first = heap.poll();
            Integer second = heap.poll();
            if (first > second) {
                heap.add(first - second);
            }
        }

        return heap.size() > 0 ? heap.poll() : 0;
    }
}
