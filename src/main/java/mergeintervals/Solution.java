package mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import common.datastructure.Interval;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        int[] merged = new int[intervals.size()];
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (merged[i] == 1) {
                continue;
            } else {
                merged[i] = 1;
                Interval interval = new Interval(intervals.get(i).start, intervals.get(i).end);
                for (int j = i + 1; j < intervals.size(); j++) {
                    if (merged[j] == 1) {
                        continue;
                    }
                    Interval thisInterval = intervals.get(j);
                    if (interval.end >= thisInterval.start) {
                        merged[j] = 1;
                        interval.end = Math.max(thisInterval.end, interval.end);
                    }
                }
                result.add(interval);
            }
        }
        return result;
    }
}
