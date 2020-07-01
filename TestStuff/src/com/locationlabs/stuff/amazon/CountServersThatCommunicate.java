package com.locationlabs.stuff.amazon;

/**
 * Created by manjeet.singh on 5/8/20.
 */
public class CountServersThatCommunicate {
   private static int countServers(int[][] grid) {
      if (grid == null || grid.length == 0) {
         return 0;
      }

      // m is num of rows and n is num of columns in grid of size m * n
      int m = grid.length, n = grid[0].length;

      int[] rows = new int[m];
      int[] columns = new int[n];

      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
               rows[i]++;
               columns[j]++;
            }
         }
      }

      int totalServers = 0;
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1 && (rows[i] > 1 || columns[j] > 1)) {
               totalServers++;
            }
         }
      }

      return totalServers;
   }

   public static void main(String[] args) {
      System.out.println(countServers(new int[][]{{1, 0}, {0, 1}}));
      System.out.println(countServers(new int[][]{{1, 0}, {1, 1}}));
      System.out.println(countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}));
   }
}
