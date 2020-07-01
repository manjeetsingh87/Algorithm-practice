package com.locationlabs.stuff.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manjeet.singh on 5/13/20.
 */
public class MeetingScheduler {
   private static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
      if (slots1 == null || slots1.length == 0 || slots2 == null || slots2.length == 0 || duration <= 0) {
         return new ArrayList<>();
      }

      Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
      Arrays.sort(slots2, (a, b) -> a[0] - b[0]);

      final int len1 = slots1.length, len2 = slots2.length;
      int i = 0, j = 0;
      while (i < len1 && j < len2) {
         // Find intersect between slots1[i] and slots2[j]
         final int intersectStart = Math.max(slots1[i][0], slots2[j][0]);
         final int intersectEnd = Math.min(slots1[i][1], slots2[j][1]);

         if (intersectStart + duration <= intersectEnd) {
            return Arrays.asList(intersectStart, intersectStart + duration);
         }

         if (slots1[i][1] < slots2[j][1]) {
            i++;
         } else {
            j++;
         }
      }

      return new ArrayList<>();
   }

   public static void main(String[] args) {
      System.out.println(minAvailableDuration(
         new int[][]{{10, 50}, {60, 120}, {140, 210}}, new int[][]{{0, 15}, {60, 70}}, 8));

      System.out.println(minAvailableDuration(
              new int[][]{{10, 50}, {60, 120}, {140, 210}}, new int[][]{{0, 15}, {60, 70}}, 12));
   }
}
