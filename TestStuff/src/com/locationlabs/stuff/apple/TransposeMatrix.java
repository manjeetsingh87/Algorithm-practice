package com.locationlabs.stuff.apple;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/25/20.
 */
public class TransposeMatrix {
   private static int[][] transpose(int[][] A) {
      if (A == null || A.length == 0) {
         return A;
      }

      final int rows = A.length, columns = A[0].length;
      final int[][] ans = new int[columns][rows];

      for (int r = 0; r < rows; r++) {
         for (int c = 0; c < columns; c++) {
            ans[c][r] = A[r][c];
         }
      }

      return ans;
   }

   public static void main(String[] args) {
      final int[][] result = transpose(new int[][]{{1, 2, 3}, {4, 5, 6}});
      for (int[] res : result) {
         System.out.println(Arrays.toString(res));
      }
   }
}
