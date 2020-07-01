package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 3/31/20.
 */
public class ExcelSheetColumnNumber {
   private static int titleToNumber(String s) {
      if (s == null || s.isEmpty()) {
         return 0;
      }

      int numericValue = 0;
      for (int i = 0; i < s.length(); i++) {
         numericValue = 26 * numericValue + (s.charAt(i) - 'A' + 1);
      }

      return numericValue;
   }

   public static void main(String[] args) {
      System.out.println(titleToNumber("A"));
      System.out.println(titleToNumber("B"));
      System.out.println(titleToNumber("AA"));
      System.out.println(titleToNumber("AB"));
      System.out.println(titleToNumber("ZY"));
   }
}
