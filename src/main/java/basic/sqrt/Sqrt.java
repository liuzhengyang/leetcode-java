package basic.sqrt;

/**
 * 求sqrt
 * 从1开始线上遍历，找到第一个满足n * n > x的n，则n - 1为要找的值
 * 可能的优化方案： 记录n到n * n的映射，二分查找
 * 构建RangeMap, [n * n, (n + 1) * (n + 1)) -> n的映射，然后通过二分定位到对应的n
 * map数量为46340，总量可用，适合于多次调用的场景
 * @author liuzhengyang
 * 2020/7/11
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        System.out.println(new Sqrt().mySqrt(2147395600));
        System.out.println(new Sqrt().mySqrtVersion2(2147395600));
        Sqrt sqrt = new Sqrt();
        for (int i = 0; i < 100 * 10000; i++) {
            int result1 = sqrt.mySqrt(i);
            int result2 = sqrt.mySqrtVersion2(i);
            if (result1 != result2) {
                throw new IllegalStateException("not equals " + i);
            }
        }
    }

    private static Range[] allRanges = initializeRanges();

    static Range[] initializeRanges() {
        Range[] ranges = new Range[46340 + 1];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = new Range(i * i, (i + 1) * (i + 1), i);
        }
        return ranges;
    }

    private static class Range {
        private int start; // inclusive
        private int end; // exclusive
        private int value; // sqrt

        public Range(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        long target = x;
        for (int i = 1; i < x; i++) {
            long multi = ((long) i) * i;
            if (multi > target) {
                return i - 1;
            }
        }
        return 0;
    }

    // 方法2，二分找到到对应的range
    public int mySqrtVersion2(int x) {
        int start = 0;
        int end = allRanges.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (allRanges[mid].start <= x && allRanges[mid].end > x) {
                return allRanges[mid].value;
            } else if (allRanges[mid].start > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

}
