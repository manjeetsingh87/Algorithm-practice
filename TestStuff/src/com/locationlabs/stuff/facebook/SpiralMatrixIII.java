package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/9/19.
 */
public class SpiralMatrixIII {
   private static int idx;
   private static int[][] result;
   private static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
      if (R == 0 && C == 0) {
         return new int[0][0];
      }

      result = new int[R * C][2];
      idx = 0;
      int r = r0, c = c0, len = 1;

      while (idx < R * C) {
         for (int i = 0; i < len; i++) {
            add(r, c++, R, C);
         }

         for (int i = 0; i < len; i++) {
            add(r++, c, R, C);
         }

         len++;

         for (int i = 0; i < len; i++) {
            add(r, c--, R, C);
         }

         for (int i = 0; i < len; i++) {
            add(r--, c, R, C);
         }

         len++;
      }

      return result;
   }

   private static void add(int row, int col, int R, int C) {
      if (row < 0 || row >= R || col < 0 || col >= C) {
         return;
      }

      result[idx][0] = row;
      result[idx++][1] = col;
   }

   public static void main(String[] args) {
      spiralMatrixIII(1, 4, 0, 0);
      for (int[] res : result) {
         System.out.println(Arrays.toString(res));
      }
   }
}
