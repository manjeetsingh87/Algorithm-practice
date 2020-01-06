package com.locationlabs.stuff.dropbox;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 7/21/19.
 */
public class GameOfLife {
   private static void gameOfLife(int[][] board) {
      if (board == null || board.length == 0) {
         return;
      }

      int rows = board.length;
      int columns = board[0].length;

      int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};

      /** Rules:
       *  1. Any live cell with fewer than two live neighbors dies, as if caused by under-population. (Alive to dead) 1 -> 2
       *  2. Any live cell with two or three live neighbors lives on to the next generation. (Alive to Alive) no change
       *  3. Any live cell with more than three live neighbors dies, as if by over-population.. (Alive to dead) 1-> 2
       *  4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction (dead to alive) 0 -> 3
       */
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            int alive = 0;
            for (int[] dir : dirs) {
               int x = dir[0] + i;
               int y = dir[1] + j;
               if (x < 0 || x >= rows || y < 0 || y >= columns) {
                  continue;
               }

               if (board[x][y] == 1 || board[x][y] == 2) {
                  alive++;
               }
            }

            if (board[i][j] == 0 && alive == 3) {
               board[i][j] = 3; // dead to alive
            }

            if (board[i][j] == 1 && (alive < 2 || alive > 3)) {
               board[i][j] = 2; // alive to dead
            }
         }
      }

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            board[i][j] %= 2;
         }
      }
      for (int i = 0; i < rows; i++) {
         System.out.println(Arrays.toString(board[i]));
      }
   }

   public static void main(String[] args) {
      gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
   }
}
