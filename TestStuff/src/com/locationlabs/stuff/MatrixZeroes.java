package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 6/17/19.
 */
public class MatrixZeroes {
   private static void setZeroes(int[][] matrix) {
      if (matrix == null || matrix.length == 0) {
         return;
      }

      int rows = matrix.length, columns = matrix[0].length;
      boolean firstRow = false, firstCol = false;

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            if (matrix[i][j] == 0) {
               if (i == 0) {
                  firstRow = true;
               }

               if (j == 0) {
                  firstCol = true;
               }
               matrix[i][0] = 0;
               matrix[0][j] = 0;
            }
         }
      }

      for (int i = 1 ; i < rows; i++) {
         for (int j = 1; j < columns; j++) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
               matrix[i][j] = 0;
            }
         }
      }

      if (firstRow) {
         for (int i = 0; i < columns; i++) {
            matrix[0][i] = 0;
         }
      }

      if (firstCol) {
         for (int i = 0; i < rows; i++) {
            matrix[i][0] = 0;
         }
      }

      for (int i = 0; i < rows; i++) {
         System.out.println(Arrays.toString(matrix[i]));
      }
   }

   public static void main(String[] args) {
      /*setZeroes(new int[][]{{1,1,1}, {1,0,1}, {1,1,1}});*/
      setZeroes(new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}});
   }
}
