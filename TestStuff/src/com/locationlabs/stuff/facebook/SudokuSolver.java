package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/14/19.
 */
public class SudokuSolver {
   private static void solveSudoku(char[][] board) {
      if (board == null || board.length == 0) {
         return;
      }

      solve(board);
   }

   private static boolean solve(char[][] board) {
      for (int i = 0; i < 9; i++) {
         for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') {
               for (char ch = '1'; ch <= '9'; ch++) {
                  if (isValid(board, i, j , ch)) {
                     board[i][j] = ch;
                     if (solve(board)) {
                        return true;
                     } else {
                        board[i][j] = '.';
                     }
                  }
               }
               return false;
            }
         }
      }
      return true;
   }

   private static boolean isValid(char[][] board, int row, int col, char ch) {
      for (int i = 0; i < 9; i++) {
         if (board[i][col] != '.' && board[i][col] == ch) {
            return false;
         }

         if (board[row][i] != '.' && board[row][i] == ch) {
            return false;
         }

         int gridRow = 3 * (row / 3) + i / 3;
         int gridCol = 3 * (col / 3) + i % 3;
         if (board[gridRow][gridCol] != '.' && board[gridRow][gridCol] == ch) {
            return false;
         }

      }
      return true;
   }
}
