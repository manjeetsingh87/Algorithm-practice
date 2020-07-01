package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/2/20.
 */
public class ExcelSheetColumnTitle {
   private static String convertToTitle(int n) {
      if (n <= 0) {
         return "";
      }

      final StringBuilder result = new StringBuilder();

      while (n > 0) {
         n--;
         result.append((char)('A' + n % 26));
         n /= 26;
      }

      return result.reverse().toString();
   }

   public static void main(String[] args) {
      System.out.println(convertToTitle(1));
      System.out.println(convertToTitle(16));
      System.out.println(convertToTitle(26));
      System.out.println(convertToTitle(27));
      System.out.println(convertToTitle(28));
      System.out.println(convertToTitle(701));
   }
}
