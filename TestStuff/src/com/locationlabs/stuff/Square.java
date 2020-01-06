package com.locationlabs.stuff;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/**
 * The game of chess is played by 2 players on an 8-by-8 board.
 * Each player has a collection of pieces with different rules for moving.
 * During a turn, each player must move exactly one of their pieces.
 * For starters, let's learn about the rook (castle).
 * A rook can move as many spaces as it likes within its row and column, as long as nothing is in its way.
 * For example, if R is a rook, the squares with Xs represent valid moves.
 *
 *
 *  [ ][ ][ ][X][ ][ ][ ][ ]
 *  [ ][ ][ ][X][ ][ ][ ][ ]
 *  [ ][ ][ ][X][ ][ ][ ][ ]
 *  [X][X][X][R][X][X][X][X]
 *  [ ][ ][ ][X][ ][ ][ ][ ]
 *  [ ][ ][ ][X][ ][ ][ ][ ]
 *  [ ][ ][ ][X][ ][ ][ ][ ]
 *  [ ][ ][ ][X][ ][ ][ ][ ]
 *
 * If an enemy piece is in the rook's path, the rook may capture the enemy piece and move to its square.
 * If Es represent enemy pieces, the following squares (including E squares) are available:
 *
 *  [ ][ ][ ][E][ ][ ][ ][ ]
 *  [ ][ ][ ][X][ ][ ][ ][ ]
 *  [ ][ ][ ][X][ ][ ][ ][ ]
 *  [ ][E][X][R][X][F][ ][ ]
 *  [ ][ ][ ][X][ ][ ][ ][ ]
 *  [ ][ ][ ][X][ ][ ][ ][ ]
 *  [ ][ ][ ][E][ ][ ][ ][ ]
 *  [ ][ ][ ][ ][ ][ ][ ][ ]
 *
 * Note that if E belonged to the same player as R, its square would not be a valid move.
 *
 * Problem: Using the language with which you are most comfortable, write a Rook class with a method that, given a position on a board,
 * will return a list of all available moves.
 * You may use any data structure to represent the board and its relationship to its pieces.
 * Write some tests for the rook's "available moves" logic by populating a board with some enemy and/or friendly pieces.
 */


public class Square {
   private static List<List<Integer>> validMovies(String[][] board, int[] rookPosition) {
      final List<List<Integer>> validMoves = new ArrayList<>();

      if (board == null || board.length == 0) {
         return validMoves;
      }

      if (rookPosition[0] < 0 || rookPosition[0] >= 8
              || rookPosition[1] < 0 || rookPosition[1] >= 8) {
         return validMoves;
      }

      int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

      for (int[] dir : dirs) {
         int x = rookPosition[0] + dir[0];
         int y = rookPosition[1] + dir[1];
         boolean isNextMoveValid = true;
         while (x >= 0 && x < 8 && y >= 0 && y < 8 && isNextMoveValid
                 && (board[x][y].equals(" ") || board[x][y].equals("E"))) {

            validMoves.add(Arrays.asList(x, y));

            if (board[x][y].equals("E")) {
               isNextMoveValid = false;
            } else {
               isNextMoveValid = true;
            }
            x += dir[0];
            y += dir[1];
            if (x < 0 || x >= 8 || y < 0 || y >= 8) {
               continue;
            }
         }
      }

      return validMoves;
   }

   public static void main(String[] args) {
      String[][] board =
              {{" ", " ", " ", " ", " ", " ", " ", " "},
                      {" ", " ", " ", " ", " ", " ", " ", " "},
                      {" ", " ", " ", " ", "E", " ", " ", " "},
                      {" ", " ", " ", " ", "R", " ", " ", " "},
                      {" ", " ", " ", " ", " ", " ", " ", " "},
                      {" ", " ", " ", " ", " ", " ", " ", " "},
                      {" ", " ", " ", " ", " ", " ", " ", " "},
                      {" ", " ", " ", " ", " ", " ", " ", " "}};

      System.out.println(validMovies(board, new int[]{3,4}));
   }
}
