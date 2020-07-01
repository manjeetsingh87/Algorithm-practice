package com.locationlabs.stuff.amazon;

/**
 * Created by manjeet.singh on 5/11/20.
 */
public class MinSwapsToEqualStrings {
   private static int minimumSwap(String s1, String s2) {
      if (s1 == null && s2 == null) {
         return 0;
      }

      if (s1 == null || s2 == null) {
         return -1;
      }

      final int s1Len = s1.length();
      final int s2Len = s2.length();

      if (s1Len * s2Len == 0 || s1Len != s2Len) {
         return -1;
      }

      int x = 0, y = 0;
      for (int i = 0; i < s1Len; i++) {
         final char c1 = s1.charAt(i);
         final char c2 = s2.charAt(i);

         if (c1 == c2) {
            continue;
         }

         if (c1 == 'x') {
            x++;
         } else {
            y++;
         }
      }

      if ((x + y) % 2 != 0) {
         return -1;
      }

      /**
       * Cases to do 1 swap:
       *   "xx" => x / 2 => how many pairs of 'x' we have ?
       *   "yy" => y / 2 => how many pairs of 'y' we have ?
       *  Cases to do 2 swaps:
       *   "xy" or "yx" =>  x % 2 + y % 2
      **/
      return x / 2 + y / 2 + x % 2 + y % 2;
   }

   public static void main(String[] args) {
      System.out.println(minimumSwap("xx", "yy"));
      System.out.println(minimumSwap("xy", "yx"));
      System.out.println(minimumSwap("xx", "xy"));
      System.out.println(minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
   }
}
