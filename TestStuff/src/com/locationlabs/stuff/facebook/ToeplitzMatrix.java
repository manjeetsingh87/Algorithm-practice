package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 5/21/20.
 */
public class ToeplitzMatrix {
   private static boolean isToeplitzMatrix(int[][] matrix) {
      if (matrix == null || matrix.length == 0) {
         return true;
      }

      for (int i = 0; i < matrix.length - 1; i++) {
         for (int j = 0; j < matrix[0].length - 1; j++) {
            if (matrix[i][j] != matrix[i + 1][j + 1]) {
               return false;
            }
         }
      }

      return true;
   }

   public static void main(String[] args) {
      System.out.println(isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
      System.out.println(isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
   }
}
