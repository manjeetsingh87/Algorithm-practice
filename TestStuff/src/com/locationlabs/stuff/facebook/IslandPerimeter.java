package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class IslandPerimeter {
   private static int islandPerimeter(int[][] grid) {
      if (grid == null || grid.length == 0) {
         return 0;
      }

      int result = 0;
      int rows = grid.length, columns = grid[0].length;
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            if (grid[i][j] == 1) {
               result += 4;

               if (i > 0 && grid[i - 1][j] == 1) {
                  result--;
               }

               if (i < rows - 1 && grid[i + 1][j] == 1) {
                  result--;
               }

               if (j > 0 && grid[i][j - 1] == 1) {
                  result--;
               }

               if (j < columns - 1 && grid[i][j + 1] == 1) {
                  result--;
               }
            }
         }
      }
      return result;
   }

   public static void main(String[] args) {
      final int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
      System.out.println(islandPerimeter(grid));
   }
}
