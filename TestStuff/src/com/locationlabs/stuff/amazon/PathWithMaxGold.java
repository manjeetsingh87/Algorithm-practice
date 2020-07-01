package com.locationlabs.stuff.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/8/20.
 */
public class PathWithMaxGold {
   private static int maxGold = 0;

   private static int getMaximumGold(int[][] grid) {
      if (grid == null || grid.length == 0) {
         return 0;
      }

      final int rows = grid.length, columns = grid[0].length;


      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            if (grid[i][j] != 0)
            dfs(grid, rows, columns, i, j, 0);
         }
      }

      return maxGold;
   }

   private static void dfs(int[][] grid, int rows, int columns, int row, int col, int currGold) {
      if (row < 0 || row >= rows || col < 0 || col >= columns || grid[row][col] == 0) {
         maxGold = Math.max(maxGold, currGold);
         return;
      }

      final int cellVal = grid[row][col];
      grid[row][col] = 0;
      dfs(grid, rows, columns, row + 1, col, currGold + cellVal);
      dfs(grid, rows, columns, row - 1, col, currGold + cellVal);
      dfs(grid, rows, columns, row, col + 1, currGold + cellVal);
      dfs(grid, rows, columns, row, col - 1, currGold + cellVal);

      grid[row][col] = cellVal;
   }

   public static void main(String[] args) {
      System.out.println(getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));
   }
}
