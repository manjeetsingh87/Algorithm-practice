package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/12/19.
 */
public class SparseMultiplication {
   private static int[][] multiply(int[][] A, int[][] B) {
      if (A == null || B == null) {
         return null;
      }

      int m = A.length, n = A[0].length, nB = B[0].length;

      if (n != B.length) {
         return null;
      }

      int[][] C = new int[m][nB];
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            if (A[i][j] != 0) {
               for (int k = 0; k < nB; k++) {
                  if (B[j][k] != 0) {
                     C[i][k] += A[i][j] * B[j][k];
                  }
               }
            }
         }
      }
      return C;
   }
}
