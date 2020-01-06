package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/20/19.
 */
public class MinimumPathSum {
   private static int minPathSum(int[][] grid) {
      if (grid == null || grid.length == 0) {
         return 0;
      }

      int rows = grid.length, columns = grid[0].length;

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            if (i == 0 && j == 0){
               continue;
            } else if (i == 0 && j != 0) {
               grid[i][j] += grid[i][j-1];
            } else if (i != 0 && j == 0) {
               grid[i][j] += grid[i - 1][j];
            } else {
               grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
         }
      }


      return grid[rows-1][columns-1];
   }

   public static void main(String[] args) {
      System.out.println(minPathSum(new int[][]{{1,3,1}, {1,5,1}, {4,2,1}}));
   }
}
