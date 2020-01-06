package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/8/19.
 */
public class TicTacToe {

   private int[] rows;
   private int[] columns;
   private int diagonal;
   private int antiDiagonal;

   /** Initialize your data structure here. */
   public TicTacToe(int n) {
      rows = new int[n];
      columns = new int[n];
   }

   /** Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
    0: No one wins.
    1: Player 1 wins.
    2: Player 2 wins. */
   public int move(int row, int col, int player) {
      int val = (player == 1) ? 1 : -1;

      rows[row] += val;
      columns[col] += val;

      if (row == col) {
         diagonal += val;
      }

      if (row + col == rows.length - 1) {
         antiDiagonal += val;
      }

      if (rows[row] == rows.length || columns[col] == rows.length
              || diagonal == rows.length || antiDiagonal == rows.length) {
         return 1;
      }

      if (rows[row] == -rows.length || columns[col] == -rows.length
              || diagonal == -rows.length || antiDiagonal == -rows.length) {
         return 2;
      }

      return 0;
   }

   public static void main(String[] args) {
      final TicTacToe ticTacToe = new TicTacToe(3);
      System.out.println(ticTacToe.move(0, 0, 1));
      System.out.println(ticTacToe.move(0, 2, 2));
      System.out.println(ticTacToe.move(2, 2, 1));
      System.out.println(ticTacToe.move(1, 1, 2));
      System.out.println(ticTacToe.move(2, 0, 1));
      System.out.println(ticTacToe.move(1, 0, 2));
      System.out.println(ticTacToe.move(2, 1, 1));
   }
}
