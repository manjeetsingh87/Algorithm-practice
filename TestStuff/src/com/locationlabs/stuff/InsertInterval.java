package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.util.Pair;

/**
 * Created by manjeet.singh on 7/13/19.
 */
public class InsertInterval {
   private static int[][] insert(int[][] intervals, int[] newInterval) {
      if ((intervals == null || intervals.length == 0) && (newInterval == null || newInterval.length == 0)) {
         return new int[0][0];
      }

      if ((intervals == null || intervals.length == 0)) {
         return new int[][]{{newInterval[0], newInterval[1]}};
      }

      if (newInterval == null || newInterval.length == 0) {
         return intervals;
      }

      List<int[]> result = new ArrayList<>();
      for (int i = 0; i < intervals.length; i++) {
         int[] interval = intervals[i];
         if (newInterval == null || interval[1] < newInterval[0]) {
            result.add(interval);
         } else if (interval[0] > newInterval[1]) {
            result.add(newInterval);
            result.add(interval);
            newInterval = null;
         } else {
            newInterval[0] = Math.min(newInterval[0], interval[0]);
            newInterval[1] = Math.max(newInterval[1], interval[1]);
         }
      }

      if (newInterval != null) {
         result.add(newInterval);
      }

      int[][] mergedIntervals = new int[result.size()][2];
      int i = 0;
      for (int[] interval : result) {
         mergedIntervals[i++] = new int[]{interval[0], interval[1]};
      }
      return mergedIntervals;
   }

   public static void main(String[] args) {
      int[][] intervals = new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};

      int[][] result = insert(intervals, new int[]{4, 8});
      for (int[] res : result) {
         System.out.print(Arrays.toString(res));
      }
      System.out.println("----------------\n");
      result = insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
      for (int[] res : result) {
         System.out.print(Arrays.toString(res));
      }
   }
}
