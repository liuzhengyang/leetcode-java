package weekly.contest.week200;

/**
 * @author liuzhengyang
 */
public class Problem1 {
    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        System.out.println(problem1.countGoodTriplets(new int[]{3,0,1,1,9,7}, 7, 2, 3));
        System.out.println(problem1.countGoodTriplets(new int[]{1,1,2,2,3}, 0, 0, 1));
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b) {
                            if (Math.abs(arr[i] - arr[k]) <= c) {
                                count ++;
                            }
                        }
                    }
                }

            }
        }
        return count;
    }
}
