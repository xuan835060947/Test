package com.xuan.gsonapt.testapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxiaoxuan1 on 17/4/20.
 */

public class LeetCode57 {

    @Test
    public void test() {
        List<Interval> result = new ArrayList<>();
        result.add(new Interval(1, 3));
        result.add(new Interval(6, 9));

        result = insert(result,new Interval(2,5));
        for (Interval interval : result) {
            PrintUtil.print("" + interval.start + "  " + interval.end);
        }

        result.clear();
        result.add(new Interval(1,2));
        result.add(new Interval(3,5));
        result.add(new Interval(6,7));
        result.add(new Interval(8,10));
        result.add(new Interval(12,16));
        result = insert(result,new Interval(4,9));
        for (Interval interval : result) {
            PrintUtil.print("" + interval.start + "  " + interval.end);
        }

        result.clear();
        result.add(new Interval(10,12));
        result = insert(result,new Interval(4,9));
        for (Interval interval : result) {
            PrintUtil.print("" + interval.start + "  " + interval.end);
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>(intervals.size());
        boolean hadDeal = false;
        for (Interval interval : intervals) {
            if (hadDeal) {
                result.add(interval);
                continue;
            }
            if (newInterval.start <= interval.end) {
                if (newInterval.start < interval.start) {
                    if (newInterval.end < interval.start) {
                        result.add(newInterval);
                        result.add(interval);
                        hadDeal = true;
                    } else {
                        newInterval.end = Math.max(newInterval.end, interval.end);
                    }
                } else {
                    newInterval.start = Math.min(newInterval.start,interval.start);
                    newInterval.end = Math.max(newInterval.end, interval.end);
                }
            } else {
                result.add(interval);
            }
        }
        if(!hadDeal){
            result.add(newInterval);
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
