package com.locationlabs.stuff.msft;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class WidestPathWithoutTrees {
   private static int widestPath(int[] X, int[] Y) {
      if (X == null || Y == null || X.length != Y.length) {
         return 0;
      }

      int widestPath = 0;
      Arrays.sort(X);

      for (int i = 1; i < X.length; i++) {
         widestPath = Math.max(widestPath, (X[i] - X[i - 1]));
      }

      return widestPath;
   }

   public static void main(String[] args) {
      System.out.println(widestPath(new int[]{5, 5, 5, 7, 7, 7}, new int[]{3, 4, 5, 1, 3, 7}));
      System.out.println(widestPath(new int[]{6, 10, 1, 4, 3}, new int[]{2, 5, 3, 1, 6}));
      System.out.println(widestPath(new int[]{4, 1, 5, 4}, new int[]{4, 5, 1, 3}));
   }
}
