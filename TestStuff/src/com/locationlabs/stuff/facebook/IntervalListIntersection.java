package com.locationlabs.stuff.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manjeet.singh on 8/7/19.
 */
public class IntervalListIntersection {
   private static int[][] intervalIntersection(int[][] A, int[][] B) {
      if ((A == null && B == null) || (A.length == 0 && B.length == 0)) {
         return new int[0][0];
      }

      final List<int[]> intervals = new ArrayList<>();
      int i = 0, j = 0;
      while (i < A.length && j < B.length) {
         if (A[i][1] < B[j][0]) {
            i++;
         } else if (A[i][0] > B[j][1]) {
            j++;
         } else {
            int low = Math.max(A[i][0], B[j][0]);
            int high = Math.min(A[i][1], B[j][1]);
            intervals.add(new int[]{low, high});
            if (A[i][1] < B[j][1]) {
               i++;
            } else {
               j++;
            }
         }
      }

      final int[][] result = new int[intervals.size()][];
      int k = 0;
      for (int[] interval : intervals) {
         result[k++] = interval;
      }
      return result;
   }

   public static void main(String[] args) {
      int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
      int[][] B = {{1, 5}, {8, 11}, {15, 24}, {25, 26}};

      int[][] result = intervalIntersection(A, B);
      for (int i = 0; i < result.length; i++) {
         System.out.println(Arrays.toString(result[i]));
      }
   }
}
