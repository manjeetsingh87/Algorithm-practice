package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/22/20.
 */
public class NextGreaterElemIII {
   private static int nextGreater(int n) {
      char[] digits = String.valueOf(n).toCharArray();
      if (digits.length == 1) {
         return -1;
      }

      int i = digits.length - 2;
      while (i >= 0 && digits[i] >= digits[i + 1]) {
         i--;
      }

      if (i < 0) {
         return -1;
      }

      int j = digits.length - 1;
      while (j >= 0 && digits[j] <= digits[i]) {
         j--;
      }

      swap(digits, i, j);
      reverse(digits, i + 1);

      try {
         return Integer.parseInt(new String(digits));
      } catch (Exception e) {
         return -1;
      }
   }

   private static void swap(char[] digits, int i, int j) {
      char tmp = digits[i];
      digits[i] = digits[j];
      digits[j] = tmp;
   }

   private static void reverse(char[] digits, int start) {
      int end = digits.length - 1;
      while (start <= end) {
         swap(digits,start++, end--);
      }
   }

   public static void main(String[] args) {
      System.out.println(nextGreater(21));
      System.out.println(nextGreater(12));
      System.out.println(nextGreater(124));
      System.out.println(nextGreater(989));
      System.out.println(nextGreater(988));
   }
}
