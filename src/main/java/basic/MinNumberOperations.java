package basic;

/**
 * // TODO 已超时，算法优化
 * @author liuzhengyang
 */
public class MinNumberOperations {
    public static void main(String[] args) {
        MinNumberOperations minNumberOperations = new MinNumberOperations();
//        System.out.println(minNumberOperations.minNumberOperations(new int[] {1, 2, 3, 2, 1}));
//        System.out.println(minNumberOperations.minNumberOperations(new int[] {3, 1, 1, 2}));
        System.out.println(minNumberOperations.minNumberOperations(new int[] {3, 1, 5, 4, 2}));
//        System.out.println(minNumberOperations.minNumberOperations(new int[] {1, 1, 1, 1}));
    }

    public int minNumberOperations(int[] target) {
        if (target == null || target.length == 0) {
            return 0;
        }
        return fun(target, 0, target.length - 1);
    }

    private int fun(int[] target, int i, int j) {
        if (i == j) {
            int result = target[i];
            target[i] = 0;
            return result;
        }
        int minValue = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            minValue = Math.min(target[k], minValue);
        }
        for (int k = i; k <= j; k++) {
            target[k] -= minValue;
        }
        int result = minValue;
        // 第一个不为0的index
        Integer left = null;
        // 最后一个不为0的index
        for (int k = i; k <= j; k++) {
            if (target[k] == 0) {
                if (left == null) {
                    continue;
                } else {
                    result += fun(target, left, k - 1);
                    left = null;
                }
            } else {
                if (left == null) {
                    left = k;
                } else {
                    if (k == j) {
                        result += fun(target, left, j);
                    }
                    continue;
                }
            }

            if (k == j && left != null) {
                result += fun(target, left, j);
            }
        }
        return result;
    }
}
