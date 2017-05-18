package com.xuan.gsonapt.testapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by chenxiaoxuan1 on 17/4/20.
 */

public class LeetCode56 {

    @Test
    public void test() {
        List<Interval> result = new ArrayList<>();
        result.add(new Interval(1, 3));
        result.add(new Interval(9, 10));
        result.add(new Interval(8, 9));

        result = merge(result);
        for (Interval interval : result) {
            PrintUtil.print("" + interval.start + "  " + interval.end);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) {
            return null;
        }
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) {
            return result;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval lhs, Interval rhs) {
                return lhs.start - rhs.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        int size = intervals.size();
        for (int i = 0; i < size; i++) {
            Interval interval = intervals.get(i);
            if (interval.start > end) {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            } else {
                end = Math.max(interval.end, end);
            }
            if (i == size - 1) {
                result.add(new Interval(start, end));
            }
        }


        return result;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
