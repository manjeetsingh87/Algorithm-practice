package com.locationlabs.stuff.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by manjeet.singh on 5/13/20.
 */
public class MinTimeDifference {
   private static final int MINUTES_IN_DAY = 24 * 60;

   private static int findMinDifference(List<String> timePoints) {
      if (timePoints == null || timePoints.size() <= 1) {
         return 0;
      }

      final boolean[] minutesBucket = new boolean[MINUTES_IN_DAY];
      for (int i = 0; i < timePoints.size(); i++) {
         final String time = timePoints.get(i);
         final String[] arr = time.split(":");
         final int hour = Integer.parseInt(arr[0]);
         final int minutes = Integer.parseInt(arr[1]);
         if (hour < 0 || hour > 23 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException(String.format("Invalid data in input: %s", time));
         }

         // if two same time points exist, min diff will be 0 so no need to continue ahead
         if (minutesBucket[hour * 60 + minutes]) {
            return 0;
         }

         minutesBucket[hour * 60 + minutes] = true;
      }

      int min = Integer.MAX_VALUE;
      int biggestMinuteSoFar = -1;  // the biggest minute meet so far
      int smallestMinute = -1; // the smallest minute exists in timePoints

      for (int i = 0; i < minutesBucket.length; i++) {
         if (minutesBucket[i]) { // minute exists in time bucket
            if (biggestMinuteSoFar != -1) {
               min = Math.min(min, i - biggestMinuteSoFar);
            }

            biggestMinuteSoFar = i;

            if (smallestMinute == -1) {
               smallestMinute = i;
            }
         }
      }

      // Here biggestMinuteSoFar points to the biggest minute in timePoints
      // need to check if smallest is in clockwise fashion or anti-clockwise fashion
      return Math.min(
              min, Math.min(biggestMinuteSoFar - smallestMinute,
                            smallestMinute + MINUTES_IN_DAY - biggestMinuteSoFar));
   }

   private static int findMinDifferenceApproachII(List<String> timePoints) {
      if (timePoints == null || timePoints.size() <= 1) {
         return 0;
      }

      Collections.sort(timePoints);
      int min = MINUTES_IN_DAY;
      for (int i = 1; i < timePoints.size(); i++) {
         min = Math.min(min, diff(timePoints.get(i - 1).split(":"), timePoints.get(i).split(":")));
      }

      min = Math.min(min, MINUTES_IN_DAY - diff(timePoints.get(0).split(":"), timePoints.get(timePoints.size()-1).split(":")));
      return min;
   }

   private static int diff(String[] time1, String[] time2) {
      final int hour1 = Integer.parseInt(time1[0]);
      final int minutes1 = Integer.parseInt(time1[1]);
      final int hour2 = Integer.parseInt(time2[0]);
      final int minutes2 = Integer.parseInt(time2[1]);

      return (hour2 - hour1) * 60 + (minutes2 - minutes1);
   }

   public static void main(String[] args) {
      System.out.println(findMinDifference(Arrays.asList("23:59", "00:00")));
      System.out.println(findMinDifferenceApproachII(Arrays.asList("23:59", "00:00")));
      System.out.println(findMinDifferenceApproachII(Arrays.asList("00:00", "23:59", "00:00")));
      System.out.println(findMinDifference(Arrays.asList("23:50", "19:00", "22:10")));
      System.out.println(findMinDifferenceApproachII(Arrays.asList("23:50", "19:00", "22:10")));
   }
}
