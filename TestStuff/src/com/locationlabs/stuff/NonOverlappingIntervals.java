package com.locationlabs.stuff;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by manjeet.singh on 9/24/19.
 */
public class NonOverlappingIntervals {
   private static int eraseOverlapIntervals(int[][] intervals) {
      if (intervals == null || intervals.length <= 1) {
         return 0;
      }

      Arrays.sort(intervals, (interval1, interval2) -> interval1[1] - interval2[1]);
      int count = 0;
      int currEnd = intervals[0][1];

      for (int i = 1; i < intervals.length; i++) {
         if (intervals[i][0] >= currEnd) {
            currEnd = intervals[i][1];
            count++;
         }
      }

      return intervals.length - 1 - count;
   }

   public static void main(String[] args) {
      System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
      System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
      System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
   }
}
