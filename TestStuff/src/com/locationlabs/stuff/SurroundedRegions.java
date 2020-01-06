package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 10/7/19.
 */
public class SurroundedRegions {
   private void solve(char[][] board) {
      if (board == null || board.length == 0) {
         return;
      }

      int rows = board.length, cols = board[0].length;
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            // check border
            if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
               if (board[i][j] == 'O') {
                  dfs(board, i, j , rows, cols);
               }
            }
         }
      }

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            if (board[i][j] == '*') {
               board[i][j] = 'O';
            } else {
               board[i][j] = 'X';
            }
         }
      }
   }

   private void dfs(char[][] board, int row, int col, int rows, int cols) {
      if (row < 0 || row >= rows || col < 0 || col >= cols) {
         return;
      }

      //X or has been visited
      if (board[row][col] == 'X' || board[row][col] == '*') {
         return;
      }

      //cannot be flipped
      board[row][col] = '*';
      dfs(board, row + 1, col, rows, cols);
      dfs(board, row - 1, col, rows, cols);
      dfs(board, row, col + 1, rows, cols);
      dfs(board, row, col - 1, rows, cols);
   }

   public static void main(String[] args) {
      char[][] board = {{'X', 'X', 'X', 'X'},
              {'X', 'O', 'O', 'X'},
              {'X', 'X', 'O', 'X'},
              {'X', 'O', 'X', 'X'}};

      new SurroundedRegions().solve(board);
      for (char[] ch : board) {
         System.out.println(Arrays.toString(ch));
      }
   }
}
