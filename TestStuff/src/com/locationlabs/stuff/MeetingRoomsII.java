package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by manjeet.singh on 3/26/19.
 */
public class MeetingRoomsII {

   public static class Interval {
      int start;
      int end;
      Interval(int s, int e) { start = s; end = e; }

      @Override
      public String toString() {
         return String.format("[" + start + "," + end + "]");
      }
   }

   private static int minMeetingRooms(Interval[] intervals) {
      int[] start = new int[intervals.length];
      int[] end = new int[intervals.length];

      for (int i=0; i < intervals.length; i++) {
         start[i] = intervals[i].start;
         end[i] = intervals[i].end;
      }

      Arrays.sort(start);
      Arrays.sort(end);

      int rooms = 0, endIdx = 0;
      for (int i=0; i < start.length; i++) {
         if (start[i] < end[endIdx]) {
            rooms++;
         } else {
            endIdx++;
         }
      }
      return rooms;
   }

   private static boolean canAttendMeetings(int[][] intervals) {
      if (intervals == null || intervals.length == 0) {
         return true;
      }

      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      for (int i = 0; i < intervals.length - 1; i++) {
         if (intervals[i][1] > intervals[i+1][0]) {
            return false;
         }
      }
      return true;
   }

   public static void main(String[] args) {
      //System.out.println(minMeetingRooms(new Interval[]{new Interval(0,30), new Interval(5,10), new Interval(15,20)}));

      System.out.println(canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
      System.out.println(canAttendMeetings(new int[][]{{7, 10}, {2, 4}}));
      System.out.println(canAttendMeetings(new int[][]{}));
   }
}
