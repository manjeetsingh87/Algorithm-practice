package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 9/24/19.
 */
public class ImageSmoother {
   private static int[][] imageSmoother(int[][] M) {
      if (M == null || M.length == 0) {
         return null;
      }

      int rows = M.length;
      int cols = M[0].length;
      int[][] result = new int[rows][cols];

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            result[i][j] = smooth(M, i, j, rows, cols);
         }
      }

      return result;
   }

   private static int smooth(int[][] grid, int row, int col, int rows, int cols) {
      int sum = 0, count  = 0;

      for (int i = -1; i <= 1; i++) {
         for (int j = -1; j <= 1; j++) {
            if (row + i < 0 || row + i >= rows || col + j < 0 || col + j >= cols) {
               continue;
            }
            count++;
            sum += grid[row + i][col + j];
         }
      }

      return sum / count;
   }

   public static void main(String[] args) {
      int[][] result = imageSmoother(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
      for (int[] res : result) {
         System.out.println(Arrays.toString(res));
      }
   }
}
