package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/17/19.
 */
public class StrobogrammaticNumber {
   private static boolean isStrobogrammatic(String num) {
      if (num == null || num.length() == 0) {
         return true;
      }

      int start = 0, end = num.length() - 1;
      while (start <= end) {
         if (!canRotate(num.charAt(start), num.charAt(end))) {
            return false;
         }
         start++;
         end--;
      }

      return true;
   }

   private static boolean canRotate(char ch1, char ch2) {
      if (ch1 == '0' && ch2 == '0') {
         return true;
      }

      if (ch1 == '1' && ch2 == '1') {
         return true;
      }

      if (ch1 == '6' && ch2 == '9') {
         return true;
      }

      if (ch1 == '9' && ch2 == '6') {
         return true;
      }

      if (ch1 == '8' && ch2 == '8') {
         return true;
      }

      return false;
   }

   public static void main(String[] args) {
      /*System.out.println(isStrobogrammatic("69"));
      System.out.println(isStrobogrammatic("88"));
      System.out.println(isStrobogrammatic("962"));*/
      System.out.println(isStrobogrammatic("2"));
   }
}
