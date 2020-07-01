package com.locationlabs.stuff.apple;

/**
 * Created by manjeet.singh on 6/9/20.
 */
public class NumberOfClosedIslands {
   private static int closedIsland(int[][] grid) {
      if (grid == null || grid.length == 0) {
         return 0;
      }

      final int rows = grid.length, columns = grid[0].length;
      int numOfIslands = 0;

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            if (grid[i][j] == 0 && isClosedIsland(grid, rows, columns, i, j)) {
               numOfIslands++;
            }
         }
      }

      return numOfIslands;
   }

   private static boolean isClosedIsland(int[][] grid, int rows, int columns, int row, int col) {
      if (row < 0 || row >= rows || col < 0 || col >= columns) {
         return false;
      }

      if (grid[row][col] == 1) {
         return true;
      }

      grid[row][col] = 1;
      final boolean left = isClosedIsland(grid, rows, columns, row - 1, col);
      final boolean right = isClosedIsland(grid, rows, columns, row + 1, col);
      final boolean top = isClosedIsland(grid, rows, columns, row, col - 1);
      final boolean bottom = isClosedIsland(grid, rows, columns, row, col + 1);

      return left && right && top && bottom;
   }

   public static void main(String[] args) {
      final int[][] grid = {{1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,1},
                            {1,0,1,1,1,0,1},
                            {1,0,1,0,1,0,1},
                            {1,0,1,1,1,0,1},
                            {1,0,0,0,0,0,1},
                            {1,1,1,1,1,1,1}};
      System.out.println(closedIsland(grid));
   }
}
