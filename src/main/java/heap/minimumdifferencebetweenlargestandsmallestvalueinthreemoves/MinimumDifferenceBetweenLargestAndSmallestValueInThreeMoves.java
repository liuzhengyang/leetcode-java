package heap.minimumdifferencebetweenlargestandsmallestvalueinthreemoves;

import java.util.PriorityQueue;

/**
 * 第4大和第1小、第3大和第2小、第2大和第三小、第1大和第4小
 *
 * 方法1，整体排序
 * 方法2，保存两个heap，一个保存目前最大的4个，一个保存目前最小的4个
 *
 * @author liuzhengyang
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public static void main(String[] args) {
        MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves m =
                new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();
        System.out.println(m.minDifference(new int[] {5, 3, 2, 4}));
        System.out.println(m.minDifference(new int[] {1, 5, 0, 10, 14}));
        System.out.println(m.minDifference(new int[] {6, 6, 0, 1, 1, 4, 6}));
        System.out.println(m.minDifference(new int[] {1, 5, 6, 14, 15}));
    }

    private static final int MOVE = 3;
    private static final int HEAP_SIZE = MOVE + 1;

    public int minDifference(int[] nums) {
        if (nums == null || nums.length <= HEAP_SIZE) {
            return 0;
        }
        PriorityQueue<Integer> largestQueue = new PriorityQueue<>(Integer::compare);
        PriorityQueue<Integer> smallestQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int num : nums) {
            largestQueue.offer(num);
            if (largestQueue.size() > HEAP_SIZE) {
                largestQueue.poll();
            }
            smallestQueue.offer(num);
            if (smallestQueue.size() > HEAP_SIZE) {
                smallestQueue.poll();
            }
        }
        int[] largestNums = new int[HEAP_SIZE];
        int[] smallestNums = new int[HEAP_SIZE];
        for (int i = 0; i < HEAP_SIZE; i++) {
            largestNums[HEAP_SIZE - i - 1] = largestQueue.poll();
            smallestNums[HEAP_SIZE - i - 1] = smallestQueue.poll();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= MOVE; i++) {
            min = Math.min(min, largestNums[i] - smallestNums[HEAP_SIZE - i - 1]);
        }
        return min;
    }
}
