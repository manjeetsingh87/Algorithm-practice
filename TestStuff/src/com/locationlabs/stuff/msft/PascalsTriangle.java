package com.locationlabs.stuff.msft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by manjeet.singh on 3/31/20.
 */
public class PascalsTriangle {
   private static List<List<Integer>> generate(int numRows) {
      final List<List<Integer>> result = new ArrayList<>();

      // if no rows to generate, return empty list
      if (numRows <= 0) {
         return result;
      }

      // first row will always have only one entry with value 1
      result.add(Collections.singletonList(1));

      for (int rowNum = 1; rowNum < numRows; rowNum++) {
         final List<Integer> row = new ArrayList<>();
         final List<Integer> prevRow = result.get(rowNum - 1);

         // add 1 at start of row
         row.add(1);

         for (int i = 1; i < rowNum; i++) {
            row.add(prevRow.get(i - 1) + prevRow.get(i));
         }

         // add 1 at end of row
         row.add(1);

         result.add(row);
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(generate(5));
   }
}
