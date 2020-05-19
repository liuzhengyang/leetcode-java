package array.minimumincrementtomakearrayunique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author liuzhengyang
 * Make something people want.
 * 2020/5/18
 */
public class MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        int[] input = new int[]{1,1,2,3};
        int result = new MinimumIncrementToMakeArrayUnique().minIncrementForUnique(input);
        System.out.println(result);
    }

    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // 1. 排序
        Arrays.sort(A);
        // 2. 找到重复数据
        List<Integer> duplicated = new ArrayList<>();
        // 3. 构造合并的List<Range>
        List<Integer> nonDuplicateRange = new ArrayList<>();
        int lastVal = -1;
        int initialSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (lastVal == -1 || A[i] != lastVal) {
                nonDuplicateRange.add(A[i]);
            } else {
                duplicated.add(A[i]);
            }
            lastVal = A[i];
            initialSum += A[i];
        }
        if (duplicated.size() == 0) {
            return 0;
        }
        List<Range> rangeList = new LinkedList<>();
        Range lastRange = null;
        for (int i = 0; i < nonDuplicateRange.size(); i++) {
            if (i == 0) {
                Range range = new Range(nonDuplicateRange.get(i), nonDuplicateRange.get(i));
                rangeList.add(range);
                lastRange = range;
            } else {
                if (lastRange.getMax() + 1 == nonDuplicateRange.get(i)) {
                    lastRange.setMax(nonDuplicateRange.get(i));
                } else {
                    lastRange = new Range(nonDuplicateRange.get(i), nonDuplicateRange.get(i));
                    rangeList.add(lastRange);
                }
            }
        }
        System.out.println("Merged ranges " + rangeList);
        // 构造对应的TreeMap, key是range.max
        TreeMap<Integer, Range> rangeTreeMap = new TreeMap<>();
        for (Range range : rangeList) {
            rangeTreeMap.put(range.getMin(), range);
        }
        System.out.println("Merged ranges " + rangeTreeMap);
        // [1,3] [5,9]
        // 2,3
        for (Integer val : duplicated) {
            Map.Entry<Integer, Range> lastContainRange = rangeTreeMap.floorEntry(val);
            Map.Entry<Integer, Range> higherEntry = rangeTreeMap.higherEntry(val);
            if (lastContainRange == null) {
                // should not happen
                System.out.println("should not happen");
            } else {
                Range range = lastContainRange.getValue();
                range.setMax(range.getMax() + 1);
                if (higherEntry != null && range.getMax() + 1 == higherEntry.getValue().getMin()) {
                    // merge next
                    rangeTreeMap.remove(higherEntry.getKey());
                    range.setMax(higherEntry.getValue().getMax());
                }
            }
        }
        System.out.println("Final merged tree range " + rangeTreeMap);

        int finalSum = 0;
        for (Range range : rangeTreeMap.values()) {
            int max = range.getMax();
            int min = range.getMin();
            int thisSum = (max + min) * (max - min + 1) / 2;
            finalSum += thisSum;
        }

        return finalSum - initialSum;
    }

    static class Range {
        // include
        private int min;
        // include
        private int max;

        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Range{");
            sb.append("min=").append(min);
            sb.append(", max=").append(max);
            sb.append('}');
            return sb.toString();
        }
    }
}
