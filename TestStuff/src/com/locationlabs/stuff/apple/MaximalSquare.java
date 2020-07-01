package com.locationlabs.stuff.apple;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/27/20.
 */
public class MaximalSquare {
   private static int maximalSquare(int[][] matrix) {
      if (matrix == null || matrix.length == 0) {
         return 0;
      }

      final int rows = matrix.length;
      final int columns = matrix[0].length;

      int[][] dp = new int[rows + 1][columns + 1];
      int result = 0;

      for (int i = 1; i <= rows; i++) {
         for (int j = 1; j <= columns; j++) {
            if (matrix[i - 1][j - 1] == 1) {
               dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
               result = Math.max(result, dp[i][j]);
            }
         }
      }

      for (int [] row : dp) {
         System.out.println(Arrays.toString(row));
      }

      return result * result;
   }

   public static void main(String[] args) {
      System.out.println(maximalSquare(new int[][]{{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}}));
   }
}
