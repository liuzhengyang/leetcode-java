package binarysearch;

public class FixedPoint {
    public static void main(String[] args) {
        FixedPoint fixedPoint = new FixedPoint();
        System.out.println(fixedPoint.fixedPoint(new int[]{-10,-5,0,3,7}));
        System.out.println(fixedPoint.fixedPoint(new int[]{0,2,5,8,17}));
        System.out.println(fixedPoint.fixedPoint(new int[]{-10,-5,3,4,7,9}));
        System.out.println(fixedPoint.fixedPoint(new int[]{-840167367,-627664644,-231820501,450402558,586187125}));
    }

    public int fixedPoint(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        return binaryFind(A, 0, A.length - 1);
    }

    private int binaryFind(int[] A, int from, int end) {
        if (from > end) {
            return -1;
        }
        if (from == end) {
            return A[from] == from ? from : -1;
        }
        int mid = from + (end - from)/2;
        if (mid == A[mid]) {
            return mid;
        } else if (A[mid] > mid) {
            return binaryFind(A, from, mid - 1);
        } else {
            return binaryFind(A, mid + 1, end);
        }
    }
}
