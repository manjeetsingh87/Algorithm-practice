package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 7/13/19.
 */
public class BestMeetingPoint {
   private static int minTotalDistance(int[][] grid) {
      if (grid == null || grid.length == 0) {
         return 0;
      }

      return 0;
   }

   public static void main(String[] args) {
      int[][] grid = new int[][] {
              {1, 0, 0, 0, 1},
              {0, 0, 0, 0, 0},
              {0 ,0, 1, 0, 0}
      };
      System.out.println(minTotalDistance(grid));
   }
}
