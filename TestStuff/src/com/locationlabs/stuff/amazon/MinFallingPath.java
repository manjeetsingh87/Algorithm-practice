package com.locationlabs.stuff.amazon;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/17/20.
 */
public class MinFallingPath {
   private static int minFallingPathSum(int[][] A) {
      if (A == null || A.length == 0 || A[0].length == 0) {
         return 0;
      }

      final int rows = A.length;
      final int columns = A[0].length;

      final int[][] dp = new int[rows][columns];

      // copy first row of A to dp[0] row
      System.arraycopy(A[0], 0, dp[0], 0, columns);

      for (int i = 1; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            if(j == 0){
               dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
            }else if(j == columns - 1){
               dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }else{
               dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]);
            }
            dp[i][j] += A[i][j];
         }
      }

      for (int i = 0; i < rows; i++) {
         System.out.print(Arrays.toString(dp[i]));
      }

      System.out.println("\n");

      return Arrays.stream(dp[rows - 1]).min().getAsInt();
   }

   public static void main(String[] args) {
      System.out.println(minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
   }
}
