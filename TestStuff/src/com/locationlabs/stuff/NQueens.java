package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by manjeet.singh on 9/30/19.
 */
public class NQueens {
   private static Set<Integer> cols = new HashSet<>();
   private static Set<Integer> diagonals = new HashSet<Integer>();
   private static Set<Integer> antiDiagonals = new HashSet<Integer>();

   private static List<List<String>> solveNQueens(int n) {
      final List<List<String>> result = new ArrayList<>();
      if (n <= 0) {
         return result;
      }

      dfs(result, new ArrayList<>(), 0, n);
      return result;
   }

   private static void dfs(List<List<String>> result, List<String> current, int row, int n) {
      if (row == n) {
         result.add(new ArrayList<>(current));
         return;
      }

      for (int i = 0; i < n; i++) {
         if (cols.contains(i) || diagonals.contains(row + i) || antiDiagonals.contains(row - i)) {
            continue;
         }

         final char[] charArray = new char[n];
         Arrays.fill(charArray, '.');
         charArray[i] = 'Q';
         final String rowString = new String(charArray);

         current.add(rowString);
         cols.add(i);
         diagonals.add(row + i);
         antiDiagonals.add(row - i);

         dfs(result, current, row + 1, n);

         current.remove(current.size() - 1);
         cols.remove(i);
         diagonals.remove(row + i);
         antiDiagonals.remove(row - i);
      }
   }

   public static void main(String[] args) {
      System.out.println(solveNQueens(4));
   }
}
