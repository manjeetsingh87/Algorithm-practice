package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/7/19.
 */
public class BattleShips {
   private static int countBattleships(char[][] board) {
      if (board == null || board.length == 0) {
         return 0;
      }

      int ships = 0;
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == '.') {
               continue;
            }

            if (i > 0 && board[i - 1][j] == 'X') {
               continue;
            }

            if (j > 0 && board[i][j - 1] == 'X') {
               continue;
            }

            ships++;
         }
      }
      return ships;
   }

   public static void main(String[] args) {
      char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
      System.out.println(countBattleships(board));
   }
}
