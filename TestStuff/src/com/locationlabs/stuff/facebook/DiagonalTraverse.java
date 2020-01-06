package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/9/19.
 */
public class DiagonalTraverse {
   private static int[] findDiagonalOrder(int[][] matrix) {
      if (matrix == null || matrix.length == 0) {
         return new int[0];
      }

      int rows = matrix.length, columns = matrix[0].length;
      int[] result = new int[rows * columns];

      int row = 0, col = 0, index = 0;
      boolean goUp = true;

      for (int i = 0; i < rows + columns; i++) {
         if (goUp) {
            while (row >= 0 && col < columns) {
               result[index++] = matrix[row--][col++];
            }

            if (col == columns) {
               col = columns - 1;
            }
            row = i + 1 - col;

            goUp = !goUp;
         } else {
            while (row < rows && col >= 0) {
               result[index++] = matrix[row++][col--];
            }

            if (row == rows) {
               row = row - 1;
            }
            col = i + 1 - row;

            goUp = !goUp;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
      System.out.println(Arrays.toString(findDiagonalOrder(matrix)));
   }
}
