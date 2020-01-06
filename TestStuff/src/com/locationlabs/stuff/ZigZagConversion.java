package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 6/5/19.
 */
public class ZigZagConversion {
   private static String convert(String s, int numRows) {
      if (numRows == 1) return s;

      final List<StringBuilder> rows = new ArrayList<>();
      for (int i = 0; i < Math.min(numRows, s.length()); i++) {
         rows.add(new StringBuilder());
      }

      int currRow = 0;
      boolean goingDown = false;
      for (char ch : s.toCharArray()) {
         rows.get(currRow).append(ch);
         if (currRow == 0 || currRow == numRows - 1) {
            goingDown = !goingDown;
         }
         currRow += goingDown ? 1 : -1;
      }

      final StringBuilder result = new StringBuilder();
      for (StringBuilder row : rows) {
         result.append(row);
      }
      return result.toString();
   }

   private static String zigZagConversion(String s, int numRows) {
      if (s == null || s.length() == 0 || numRows <= 1) {
         return s;
      }

      List<StringBuilder> list = new ArrayList<>();
      for (int i = 0; i < numRows; i++) {
         list.add(new StringBuilder());
      }

      int len = s.length();
      int i = 0;
      while (i < len) {
         for (int idx = 0; idx < numRows && i < len; idx++) {
            list.get(idx).append(s.charAt(i++));
         }

         for (int idx = numRows-2; idx >= 1 && i < len; idx--) {
            list.get(idx).append(s.charAt(i++));
         }
      }

      StringBuilder result = new StringBuilder();
      for (StringBuilder sb : list) {
         result.append(sb);
      }
      return result.toString();
   }

   public static void main(String[] args) {
      System.out.println(zigZagConversion("PAYPALISHIRING", 3));
      System.out.println(convert("AB", 1));
   }
}
