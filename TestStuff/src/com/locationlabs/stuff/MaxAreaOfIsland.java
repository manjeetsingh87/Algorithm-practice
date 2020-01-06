package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 5/16/19.
 */
public class MaxAreaOfIsland {

   private static int maxAreaOfIsland(int[][] grid) {
      if (grid == null || grid.length == 0) {
         return 0;
      }

      int area = 0;
      for (int row = 0; row < grid.length; row++) {
         for (int col = 0; col < grid[0].length; col++) {
            if (grid[row][col] == 1) {
               int currentIslandArea = findConnectedIslands(grid, row, col);
               area = Math.max(area, currentIslandArea);
            }
         }
      }
      return area;
   }

   private static int findConnectedIslands(int[][] grid, int row, int col) {
      if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
         return 0;
      }

      grid[row][col] = 0;
      return 1 + findConnectedIslands(grid, row - 1, col)
               + findConnectedIslands(grid, row + 1, col)
               + findConnectedIslands(grid, row, col - 1)
               + findConnectedIslands(grid, row, col + 1);
   }

   public static void main(String[] args) {
      int[][] grid = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
      System.out.println(maxAreaOfIsland(grid));
   }
}
