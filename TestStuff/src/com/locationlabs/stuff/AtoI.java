package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/8/19.
 */
public class AtoI {

   private static int myAtoi(String str) {
      if (str == null || str.trim().length() == 0) {
         return 0;
      }

      String strWithoutSpace = str.trim();

      if (Character.isAlphabetic(strWithoutSpace.charAt(0))) {
         return 0;
      }

      int sign = 1;
      int total = 0;
      int index = 0;
      if (strWithoutSpace.charAt(0) == '-' ||
              strWithoutSpace.charAt(0) == '+') {
         sign = strWithoutSpace.charAt(0) == '-' ? -1 : 1;
         index = 1;
      }


      while (index < strWithoutSpace.length()) {
         int currentDigit = strWithoutSpace.charAt(index) - '0';

         if (currentDigit < 0 || currentDigit > 9) {
            break;
         }

         // check for integer overflow
         try {
            total = Math.multiplyExact(total, 10);
            total = Math.addExact(total, currentDigit);
         } catch (ArithmeticException e) {
            System.out.println(String.format("Overflow error, current total is: %s", total));
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
         }
         index++;
      }

      return total * sign;
   }

   public static void main(String[] args) {
      /*System.out.println(myAtoi("42"));
      System.out.println(myAtoi("2147483648"));
      System.out.println(myAtoi("4193 with words"));
      System.out.println(myAtoi("words and 987"));*/
      System.out.println(myAtoi("-91283472332"));
   }
}
