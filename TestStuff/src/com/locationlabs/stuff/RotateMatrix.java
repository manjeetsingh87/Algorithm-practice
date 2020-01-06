package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/21/19.
 */
public class RotateMatrix {

   private static void rotate90(int[][] matrix) {
      if (matrix == null || matrix.length == 0) {
         return;
      }

      int rows = matrix.length;
      int col = matrix[0].length;

      // transpose the matrix
      for (int i = 0; i < rows; i++) {
         for (int j = i; j < col; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = tmp;
         }
      }

      for (int i = 0; i < matrix.length; i++) {
         System.out.println(Arrays.toString(matrix[i]));
      }
      System.out.println("\n----------------------\n");

      // reverse each row
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < rows/2; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[i][rows - j - 1];
            matrix[i][rows - j - 1] = tmp;
         }
      }

      for (int i = 0; i < matrix.length; i++) {
         System.out.println(Arrays.toString(matrix[i]));
      }
      System.out.println("\n----------------------\n");
   }

   private static void rotateMinus90(int[][] matrix) {
      if (matrix == null || matrix.length == 0) {
         return;
      }

      int rows = matrix.length;
      int col = matrix[0].length;

      // reverse each row
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < rows/2; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[i][rows - j - 1];
            matrix[i][rows - j - 1] = tmp;
         }
      }

      // transpose the matrix
      for (int i = 0; i < rows; i++) {
         for (int j = i; j < col; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = tmp;
         }
      }

      for (int i = 0; i < matrix.length; i++) {
         System.out.println(Arrays.toString(matrix[i]));
      }

      System.out.println("\n----------------------\n");
   }

   private static void rotate180(int[][] matrix) {
      if (matrix == null || matrix.length == 0) {
         return;
      }

      int rows = matrix.length;

      //rotate matrix by 180 degrees
      for (int i = 0; i < rows/2; i++) {
         for (int j = 0; j < rows; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[rows - i - 1][rows - j - 1];
            matrix[rows - i - 1][rows - j - 1] = tmp;
         }
      }

      for (int i = 0; i < rows; i++) {
         System.out.println(Arrays.toString(matrix[i]));
      }
   }

   public static void main(String[] args) {
      rotate90(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
      /*rotateMinus90(new int[][]{{1,2}, {4,5}});
      rotate180(new int[][]{{1,2}, {4,5}});*/
   }
}
