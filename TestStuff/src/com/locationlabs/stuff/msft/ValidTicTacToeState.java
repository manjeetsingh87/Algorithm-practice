package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/12/20.
 */
public class ValidTicTacToeState {
   private static boolean validTicTacToe(String[] board) {
      if (board.length == 0) {
         return false;
      }

      int turns = 0;
      boolean xwin;
      boolean owin;
      int[] rows = new int[3];
      int[] cols = new int[3];
      int diag = 0;
      int antidiag = 0;

      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            if (board[i].charAt(j) == 'X') {
               turns++;
               rows[i]++;
               cols[j]++;
               if (i == j) {
                  diag++;
               }
               if (i + j == 2) {
                  antidiag++;
               }
            } else if (board[i].charAt(j) == 'O') {
               turns--;
               rows[i]--;
               cols[j]--;
               if (i == j) {
                  diag--;
               }
               if (i + j == 2) {
                  antidiag--;
               }
            }
         }
      }

      xwin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 ||
              cols[0] == 3 || cols[1] == 3 || cols[2] == 3 ||
              diag == 3 || antidiag == 3;
      owin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 ||
              cols[0] == -3 || cols[1] == -3 || cols[2] == -3 ||
              diag == -3 || antidiag == -3;

      if (xwin && turns == 0 || owin && turns == 1) {
         return false;
      }
      return (turns == 0 || turns == 1) && (!xwin || !owin);
   }
}