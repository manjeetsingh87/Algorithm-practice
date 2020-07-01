package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/14/19.
 */
public class SudokuSolver {
   private static boolean solveSudoku(char[][] board) {
      if (board == null || board.length == 0) {
         return false;
      }

      return solve(board);
   }

   private static boolean solve(char[][] board) {
      for (int i = 0; i < 9; i++) {
         for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') {
               for (char ch = '1'; ch <= '9'; ch++) {
                  if (isValid(board, i, j, ch)) {
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
         if (board[row][i] != '.' && board[row][i] == ch) {
            return false;
         }

         if (board[i][col] != '.' && board[i][col] == ch) {
            return false;
         }

         final int cellRow = 3 * (row / 3) + i / 3;
         final int cellCol = 3 * (col / 3) + i % 3;
         if (board[cellRow][cellCol] != '.' && board[cellRow][cellCol] == ch) {
            return false;
         }
      }

      return true;
   }

   public static void main(String[] args) {
      char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
      System.out.println(solveSudoku(board));
   }
}
