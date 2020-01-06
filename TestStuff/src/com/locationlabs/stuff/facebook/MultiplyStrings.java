package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class MultiplyStrings {
   private static String multiply(String num1, String num2) {
      if (num1 == null || num2 == null) {
         return "0";
      }

      int len1 = num1.length();
      int len2 = num2.length();
      if (len1 * len2 == 0) {
         return "0";
      }

      int len = len1 + len2;
      int[] mul = new int[len];
      for (int i = len1 - 1; i >= 0; i--) {
         for (int j = len2 - 1; j >= 0; j--) {
            int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            int p1 = i + j, p2 = i + j + 1;
            int sum = prod + mul[p2];

            mul[p1] += sum / 10;
            mul[p2] = sum % 10;
         }
      }

      int i = 0;
      while (mul[i] == 0 && i < len - 1) {
         i++;
      }

      if (i >= len) {
         return "0";
      }

      final StringBuilder sb = new StringBuilder();
      for (; i < len; i++) {
         sb.append(mul[i]);
      }
      return sb.length() == 0 ? "0" : sb.toString();
   }

   public static void main(String[] args) {
      System.out.println(multiply("12", "14"));
      System.out.println(multiply("123", "456"));
   }
}
