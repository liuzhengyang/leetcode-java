package mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.datastructure.Interval;

/**
 * @author liuzhengyang
 */
public class Solution2 {
    public static void main(String[] args) {

    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        List<Interval> result = new ArrayList<>();
        Interval last = null;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (last == null || last.end < interval.start) {
                result.add(interval);
                last = interval;
            } else {
                last.end = Math.max(last.end, interval.end);
            }
        }
        return result;
    }
}
