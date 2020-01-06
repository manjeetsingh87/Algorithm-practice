package com.locationlabs.stuff;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/16/19.
 */
public class NoOfIslands {

   private static int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0) {
         return 0;
      }

      int count = 0;

      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == '1') {
               findConnectedIslands(grid, i, j);
               count++;
            }
         }
      }

      return count;
   }

   private static void findConnectedIslands(char[][] grid, int rowStart, int colStart) {
      if (rowStart < 0 || rowStart >= grid.length || colStart < 0 ||
              colStart >= grid[0].length || grid[rowStart][colStart] != '1') {
         return;
      }

      grid[rowStart][colStart] = '0';
      findConnectedIslands(grid, rowStart+1, colStart);
      findConnectedIslands(grid, rowStart-1, colStart);
      findConnectedIslands(grid, rowStart, colStart+1);
      findConnectedIslands(grid, rowStart, colStart-1);
   }

   private int numDistinctIslands(int[][] grid) {
      if (grid == null || grid.length == 0) {
         return 0;
      }

      Set<String> set = new HashSet<>();
      for (int row = 0; row < grid.length; row++) {
         for (int col = 0; col < grid[0].length; col++) {
            if (grid[row][col] == 1) {
               StringBuilder sb = new StringBuilder();
               dfs(grid, row, col, "o", sb);
               set.add(sb.toString());
            }
         }
      }
      return set.size();
   }

   private void dfs(int[][] grid, int row, int col, String direction, StringBuilder sb) {
      if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
         return;
      }

      grid[row][col] = 0;
      sb.append(direction);
      dfs(grid, row - 1, col, "u", sb);
      dfs(grid, row + 1, col, "d", sb);
      dfs(grid, row, col - 1, "l", sb);
      dfs(grid, row, col + 1, "r", sb);
      sb.append("b");
   }

   public static void main(String[] args) {
      /*char[][] grid = new char[][]{
              {'1', '1', '1', '1', '0'},
              {'1', '1', '0', '1', '0'},
              {'1', '1', '0', '0', '0'},
              {'0', '0', '0', '0', '0'}
      };*/

//      System.out.println(numIslands(grid));

//      char[][] grid = new char[][]{{'0', '1', '0'}, {'1', '0', '1'}, {'0', '1', '0'}};
//      System.out.println(numIslands(grid));

      int[][] grid2 = new int[][]{{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
      System.out.println(new NoOfIslands().numDistinctIslands(grid2));
   }
}
