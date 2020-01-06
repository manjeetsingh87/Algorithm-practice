package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 4/8/19.
 */
public class SpiralMatrix {

   private static List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> result = new ArrayList<>();

      if (matrix.length == 0) {
         return result;
      }

      int rowStart = 0;
      int rowEnd = matrix.length - 1;
      int colStart = 0;
      int colEnd = matrix[0].length - 1;

      while(rowStart <= rowEnd && colStart <= colEnd) {
         // Go right
         for (int j = colStart; j <= colEnd; j++) {
            result.add(matrix[rowStart][j]);
         }

         rowStart++;

         //Go down
         for (int j = rowStart; j <= rowEnd; j++) {
            result.add(matrix[j][colEnd]);
         }

         colEnd--;

         if (rowStart <= rowEnd) {
            // Go left
            for (int j = colEnd; j >= colStart; j--) {
               result.add(matrix[rowEnd][j]);
            }
         }

         rowEnd--;

         if (colStart <= colEnd) {
            // Go up
            for (int j = rowEnd; j >= rowStart; j--) {
               result.add(matrix[j][colStart]);
            }
         }

         colStart++;
      }

      return result;
   }

   public static void main(String[] args) {
      int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
      System.out.println(spiralOrder(matrix));

      int[][] matrix2 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
      System.out.println(spiralOrder(matrix2));
   }

}
