package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 6/24/19.
 */
public class RangeSumQuery2DImmutable {
   private int[][] dp;

   public RangeSumQuery2DImmutable(int[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
         return;
      }

      int rows = matrix.length;
      int cols = matrix[0].length;
      dp = new int[rows+1][cols+1];
      for (int r = 0; r < rows; r++) {
         for (int c = 0; c < cols; c++) {
            dp[r+1][c+1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
         }
      }
   }

   public int sumRegion(int row1, int col1, int row2, int col2) {
      return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
   }

   public static void main(String[] args) {
      int[][] matrix = new int[][]{
              {3, 0, 1, 4, 2},
              {5, 6, 3, 2, 1},
              {1, 2, 0, 1, 5},
              {4, 1, 0, 1, 7},
              {1, 0, 3, 0, 5}};

      RangeSumQuery2DImmutable rangeSumQuery = new RangeSumQuery2DImmutable(matrix);

      for (int i = 0; i < rangeSumQuery.dp.length; i++) {
         System.out.print(Arrays.toString(rangeSumQuery.dp[i]));
         System.out.print("\n");
      }

      System.out.println(rangeSumQuery.sumRegion(2, 1, 4, 3));
      System.out.println(rangeSumQuery.sumRegion(1, 1, 2, 2));
      System.out.println(rangeSumQuery.sumRegion(1, 2, 2, 4));
   }
}
