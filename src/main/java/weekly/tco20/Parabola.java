package weekly.tco20;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Parabola {
    public static void main(String[] args) {
    }

    public int[] estimate(int[] Y) {
        int length = Y.length;
        int bestA = 0,bestB = 0,bestC = 0;
        long minDiff = Long.MAX_VALUE;
        for (int a = 1; a <= 50; a++) {
            for (int b = -50; b <= 50; b++) {
                int[] sums = new int[length];
                for (int i = 0; i < length; i++) {
                    sums[i] = Y[i] - (i * i * a + i * b);
                }
                Arrays.sort(sums);
                int choiceOfC = length % 2 == 1 ? sums[length / 2] : sums[length / 2 - 1];
                long minDiffThisLoop = 0;
                for (int i = 0; i < length; i++) {
                    minDiffThisLoop += Math.abs(choiceOfC - sums[i]);
                }
                if (minDiffThisLoop < minDiff) {
                    bestA = a;
                    bestB = b;
                    bestC = choiceOfC;
                    minDiff = minDiffThisLoop;
                }
            }
        }
        return new int[]{bestA,bestB, bestC};
    }
}
