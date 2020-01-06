package com.locationlabs.stuff;

import static com.locationlabs.stuff.MeetingRoomsII.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by manjeet.singh on 3/27/19.
 */
public class MergeIntervals {

   private static List<Interval> merge(List<Interval> intervals) {

      if (intervals.isEmpty() || intervals.size() <= 1) {
         return intervals;
      }

      intervals.sort((obj1, obj2) -> Integer.compare(obj1.start, obj2.start));

      List<Interval> result = new LinkedList();
      final Interval first = intervals.get(0);

      for (Interval interval : intervals) {
         if (interval.start <= first.end) { // overlapping interval, merge it
            first.end = Math.max(first.end, interval.end);
         } else {
            result.add(new Interval(first.start, first.end));
            first.start = interval.start;
            first.end = interval.end;
         }
      }

      result.add(new Interval(first.start, first.end));

      return result;
   }

   private static List<Interval> mergeIntervals(List<Interval> intervals) {
      if (intervals.isEmpty() || intervals.size() <= 1) {
         return intervals;
      }

      int arrayLen = intervals.size();
      int[] startIntervals = new int[arrayLen];
      int[] endIntervals = new int[arrayLen];

      for (int i=0; i < arrayLen; i++) {
         Interval interval = intervals.get(i);
         startIntervals[i] = interval.start;
         endIntervals[i] = interval.end;
      }

      Arrays.sort(startIntervals);
      Arrays.sort(endIntervals);

      List<Interval> result = new ArrayList();

      for (int i=0, j=0; i<arrayLen; i++) {
         if (i == arrayLen-1 || startIntervals[i+1] > endIntervals[i]) {
            result.add(new Interval(startIntervals[j], endIntervals[i]));
            j = i+1;
         }
      }

      return result;
   }

   private static int[][] merge(int[][] intervals) {
      if (intervals == null || intervals.length == 0) {
         return intervals;
      }

      int len = intervals.length;
      int[] starts = new int[len];
      int[] ends = new int[len];

      for (int i = 0; i < len; i++) {
         starts[i] = intervals[i][0];
         ends[i] = intervals[i][1];
      }

      Arrays.sort(starts);
      Arrays.sort(ends);

      List<List<Integer>> result = new ArrayList<>();

      for (int i = 0, j = 0; i < len; i++) {
         if (i == len - 1 || starts[i+1] > ends[i]) {
            result.add(Arrays.asList(starts[j], ends[i]));
            j = i + 1;
         }
      }

      int[][] rsltArr = new int[result.size()][2];
      int i = 0;
      while (i < result.size()) {
         List<Integer> interval = result.get(i);
         rsltArr[i][0] = interval.get(0);
         rsltArr[i][1] = interval.get(1);
         i++;
      }

      return rsltArr;
   }

   public static void main(String[] args) {
//      List<Interval> intervals = new ArrayList();
//
//      intervals.add(new Interval(1,3));
//      intervals.add(new Interval(2,6));
//      intervals.add(new Interval(5,10));
//      intervals.add(new Interval(15,18));
//
//      System.out.println(merge(intervals));

      int[][] result = merge(new int[][]{{1,3}, {2,6}, {8, 10}, {15,18}});
      for (int[] res : result) {
         System.out.print(Arrays.toString(res));
      }
//
//      System.out.println("\n");
//      result = merge(new int[][]{{1,4}, {4,5}});
//      for (int[] res : result) {
//         System.out.print(Arrays.toString(res));
//      }
   }
}
