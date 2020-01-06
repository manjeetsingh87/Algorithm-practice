package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/12/19.
 */
public class LongestIncreasingMatrixPath {
   private static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
   private static int longestIncreasingPath(int[][] matrix) {
      if (matrix == null || matrix.length == 0) {
         return 0;
      }

      int maxLen = 1;
      int rows = matrix.length, columns = matrix[0].length;
      int[][] cache = new int[rows][columns];

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            int len = dfs(matrix, i, j, rows, columns, cache);
            maxLen = Math.max(maxLen, len);
         }
      }

      for (int i = 0; i < cache.length; i++) {
         System.out.println(Arrays.toString(cache[i]));
      }
      return maxLen;
   }

   private static int dfs(int[][] matrix, int row, int col, int rows, int columns, int[][] cache) {
      if (cache[row][col] != 0) {
         return cache[row][col];
      }

      int max = 1;

      for (int[] dir : dirs) {
         int x = row + dir[0];
         int y = col + dir[1];

         if (x < 0 || x >= rows || y < 0 || y >= columns || matrix[x][y] <= matrix[row][col]) {
            continue;
         }

         int len = 1 + dfs(matrix, x, y, rows, columns, cache);
         max = Math.max(max, len);
      }

      cache[row][col] = max;
      return max;
   }

   public static void main(String[] args) {
      int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
      System.out.println(longestIncreasingPath(matrix));

      int[][] matrix2 = new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
      System.out.println(longestIncreasingPath(matrix2));
   }
}
