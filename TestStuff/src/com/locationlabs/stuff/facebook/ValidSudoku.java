package com.locationlabs.stuff.facebook;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjeet.singh on 8/8/19.
 */
public class ValidSudoku {
   private static boolean isValidSudoku(char[][] board) {
      if (board == null || board.length == 0) {
         return true;
      }

      final Set<String> seen = new HashSet<>();
      for(int i = 0; i < 9; i++) {
         for (int j = 0; j < 9; j++) {
            char cellVal = board[i][j];
            if (cellVal == '.') {
               continue;
            }

            if (!seen.add(cellVal + "in row" + i)
                    || !seen.add(cellVal + "in col" + j)
                    || !seen.add(cellVal + "in box" + (i / 3) + "-" + (j / 3))) {
               return false;
            }
         }
      }

      return true;
   }
}
