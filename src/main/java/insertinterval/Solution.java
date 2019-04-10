package insertinterval;

import java.util.ArrayList;
import java.util.List;

import common.datastructure.Interval;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /**
         * [[1,2],[3,5],[6,7],[8,10],[12,16]]
         * [4,8]
         */
        List<Interval> list = new ArrayList<>();
        list.add(makeInterval(1, 5));
//        list.add(makeInterval(3, 5));
//        list.add(makeInterval(6, 7));
//        list.add(makeInterval(8, 10));
//        list.add(makeInterval(12, 16));
        System.out.println(solution.getLastEndSmallerThan(list, 0, list.size() -1, 6));
        System.out.println(solution.getFirstStartLargerThan(list, 0, list.size() -1, 8));
        List<Interval> insert = solution.insert(list, new Interval(6, 8));
        System.out.println(insert);
    }

    private static Interval makeInterval(int first, int second) {
        return new Interval(first, second);
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty()) {
            List<Interval> result = new ArrayList<>();
            result.add(newInterval);
            return result;
        }
        // skip param checking

        int start = newInterval.start;
        int end = newInterval.end;

        int lastEndSmallerThan = getLastEndSmallerThan(intervals, 0, intervals.size() - 1, start);
        int firstStartLargerThan = getFirstStartLargerThan(intervals, 0, intervals.size() - 1, end);
        List<Interval> result = new ArrayList<>();
        if (lastEndSmallerThan == -1) {
            if (firstStartLargerThan == -1) {
                int newStart = Math.min(intervals.get(0).start, start);
                int newEnd = Math.max(intervals.get(intervals.size() - 1).end, end);
                result.add(new Interval(newStart, newEnd));
                return result;
            } else {
                int newStart = firstStartLargerThan == 0 ? start : Math.min(intervals.get(0).start, start);
                int newEnd = firstStartLargerThan == 0 ? end :
                        Math.max(intervals.get(firstStartLargerThan - 1).end, end);
                result.add(new Interval(newStart, newEnd));

                if (firstStartLargerThan < intervals.size()) {
                    result.addAll(intervals.subList(firstStartLargerThan, intervals.size()));
                }
                return result;
            }
        } else {
            if (firstStartLargerThan == -1) {
                Interval interval = intervals.get(Math.min(intervals.size() - 1,
                        lastEndSmallerThan + 1));
                Interval intervalLarge = intervals.get(Math.max(0,
                        intervals.size() - 1));
                int newStart = lastEndSmallerThan == intervals.size() -1 ? start :
                        Math.min(start, interval.start);
                int newEnd = lastEndSmallerThan == intervals.size() - 1 ? end :
                        Math.max(end, intervalLarge.end);
                result.addAll(intervals.subList(0, Math.min(lastEndSmallerThan + 1, intervals.size())));
                result.add(new Interval(newStart, newEnd));
                return result;
            } else {
                if (lastEndSmallerThan + 1 == firstStartLargerThan) {
                    result.addAll(intervals.subList(0, lastEndSmallerThan + 1));
                    result.add(new Interval(start, end));
                    result.addAll(intervals.subList(firstStartLargerThan, intervals.size()));
                    return result;
                } else {
                    Interval interval = intervals.get(Math.max(firstStartLargerThan - 1, 0));
                    result.addAll(intervals.subList(0, lastEndSmallerThan + 1));
                    int newStart = Math.min(start, intervals.get(lastEndSmallerThan + 1).start);
                    int newEnd = Math.max(end, interval.end);
                    result.add(new Interval(newStart, newEnd));
                    result.addAll(intervals.subList(firstStartLargerThan, intervals.size()));
                    return result;
                }
            }
        }
    }

    private int getFirstStartLargerThan(List<Interval> intervals, int from, int to, int target) {
        if (from > to) {
            return -1;
        }
        if (from == to) {
            if (isFirstStartLargeThan(intervals, from, target)) {
                return from;
            } else {
                return -1;
            }
        }
        int mid = from + (to - from) / 2;
        Interval midInterval = intervals.get(mid);
        if (isFirstStartLargeThan(intervals, mid, target)) {
            return mid;
        }
        if (midInterval.start > target) {
            return getFirstStartLargerThan(intervals, from, mid - 1, target);
        } else {
            return getFirstStartLargerThan(intervals, mid + 1, to, target);
        }
    }

    private boolean isFirstStartLargeThan(List<Interval> intervals, int pos, int target) {
        Interval interval = intervals.get(pos);
        if (interval.start > target) {
            if (pos == 0) {
                return true;
            } else {
                if (intervals.get(pos - 1).start <= target) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isLastEndSmallerThan(List<Interval> intervals, int pos, int target) {
        Interval interval = intervals.get(pos);
        if (interval.end < target) {
            if (pos == intervals.size() - 1) {
                return true;
            }
            if (intervals.get(pos + 1).end >= target) {
                return true;
            }
        }
        return false;
    }

    private int getLastEndSmallerThan(List<Interval> intervals, int from, int to, int target) {
        if (from > to) {
            return -1;
        }
        if (from == to) {
            if (isLastEndSmallerThan(intervals, from, target)) {
                return from;
            } else {
                return -1;
            }
        }
        int mid = from + (to - from) / 2;
        if (isLastEndSmallerThan(intervals, mid, target)) {
            return mid;
        }
        Interval midInterval = intervals.get(mid);
        if (midInterval.end < target) {
            return getLastEndSmallerThan(intervals, mid + 1, to, target);
        } else {
            return getLastEndSmallerThan(intervals, 0, mid - 1, target);
        }
    }
}
