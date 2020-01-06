package com.locationlabs.stuff.dropbox;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 7/21/19.
 */
public class MeetingRooms {
   private static boolean canAttendMeetings(int[][] intervals) {
      if (intervals == null || intervals.length == 0) {
         return true;
      }

      int len = intervals.length;
      final int[] starts = new int[len];
      final int[] ends = new int[len];

      for (int i = 0; i < len; i++) {
         starts[i] = intervals[i][0];
         ends[i] = intervals[i][1];
      }

      Arrays.sort(starts);
      Arrays.sort(ends);

      for (int i = 0; i < len - 1; i++) {
         if (ends[i] > starts[i + 1]) {
            return false;
         }
      }
      return true;
   }

   private static int minMeetingRooms(int[][] intervals) {
      if (intervals == null || intervals.length == 0) {
         return 0;
      }

      int len = intervals.length;
      final int[] starts = new int[len];
      final int[] ends = new int[len];

      for (int i = 0; i < len; i++) {
         starts[i] = intervals[i][0];
         ends[i] = intervals[i][1];
      }

      Arrays.sort(starts);
      Arrays.sort(ends);

      int rooms = 0, endIdx = 0;
      for (int i = 0; i < len - 1; i++) {
         if (starts[i] < ends[endIdx]) {
            rooms++;
         } else {
            endIdx++;
         }
      }

      return rooms;
   }

   public static void main(String[] args) {
      System.out.println(canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
      System.out.println(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
      System.out.println("---------------------------\n");
      System.out.println(canAttendMeetings(new int[][]{{7, 10}, {2, 4}}));
      System.out.println(minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
   }
}
