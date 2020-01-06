package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/3/19.
 */
public class GameOfLife {
   private static void gameOfLife(int[][] board) {
      if (board == null || board.length == 0) {
         return;
      }

      int rows = board.length;
      int columns = board[0].length;

      int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            int live = 0;
            for (int[] dir : dirs) {
               if (dir[0] + i < 0 || dir[0] + i >= rows || dir[1] + j < 0 || dir[1] + j >= columns) {
                  continue;
               }
               if (board[dir[0]+i][dir[1]+j] == 1 || board[dir[0]+i][dir[1]+j] == 2) {
                  live++;
               }
            }
            if (board[i][j] == 0 && live == 3) {
               board[i][j] = 3; // dead to alive
            }
            if (board[i][j] == 1 && (live < 2 || live > 3)) {
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
         for (int j = 0; j < columns; j++) {
            System.out.print(board[i][j]);
            System.out.print(j == columns-1 ? "" : " ");
         }
         System.out.print("\n");
      }
   }

   public static void main(String[] args) {
      gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
   }
}
