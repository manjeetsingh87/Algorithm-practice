package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 9/30/19.
 */
public class KnightProbabilityChessBoard {
   private static int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

   /**
    * The first solution uses O(k*n^2) space for simplicity:
    * At every k and position i j we store the probability that the knight landed at position i j at step k.
    * We know that this probability is the sum of probabilities of the 8 directions in the previous step k-1
    * because in the previous step all 8 of those knight's have a chance of moving here.
    * For example since one of the directions is 2, 1 we take the current i-2 and j-1 and
    * add that probability/8.0 (because if the knight is currently at i-2, j-1 the chance is
    * only /8.0 that he'll choose this direction out of his 7 other choices).
    * We initialize the r , c index of the k==0 board to 1, because at step 0,
    * we already have the knight at position r, c so the chance it lands there in 0 steps is 100%.
    * The result is the sum of probabilities in all areas of the board in the Kth index Board.
    */
   private static double knightProbability(int N, int K, int r, int c) {
      double[][] prevWays = new double[N][N];
      prevWays[r][c]=1;

      for(int k = 1; k <= K; k++) {
         double [][] ways = new double[N][N];
         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
               for (int[] move : moves) {
                  int oldMoveR = i - move[0];
                  int oldMoveC = j - move[1];
                  if (oldMoveR >= 0 && oldMoveR < N && oldMoveC >= 0 && oldMoveC < N) {
                     ways[i][j] += prevWays[oldMoveR][oldMoveC] / 8.0;
                  }
               }
            }
         }
         prevWays = ways;
      }

      double result = 0;
      for(int i = 0; i < N; i++){
         for(int j = 0; j < N; j++){
            result += prevWays[i][j];
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(knightProbability(3, 2, 0, 0));
   }
}
