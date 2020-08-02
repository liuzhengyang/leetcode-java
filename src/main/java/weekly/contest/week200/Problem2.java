package weekly.contest.week200;

/**
 * @author liuzhengyang
 */
public class Problem2 {
    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(problem2.getWinner(new int[]{2,1,3,5,4,6,7}, 2));
        System.out.println(problem2.getWinner(new int[]{3,2,1}, 10));
        System.out.println(problem2.getWinner(new int[]{1,9,8,2,3,7,6,4,5}, 7));
        System.out.println(problem2.getWinner(new int[]{1,11,22,33,44,55,66,77,88,99}, 1000000000));
    }

    public int getWinner(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 1) {
            return 0;
        }
        if (k >= arr.length) {
            int max = arr[0];
            for (int num : arr) {
                max = Math.max(max, num);
            }
            return max;
        }
        int currentWinCount = 0;
        int currentWin = arr[0];
        int headIndex = 1;
        while (currentWinCount < k) {
            if (currentWin < arr[headIndex]) {
                currentWinCount = 1;
                int oldWin = currentWin;
                currentWin = arr[headIndex];
                arr[headIndex] = oldWin;
            } else {
                currentWinCount++;
            }
            headIndex++;
            if (headIndex >= arr.length) {
                headIndex = 1;
            }
        }
        return currentWin;
    }
}
