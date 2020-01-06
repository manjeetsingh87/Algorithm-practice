package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class ConvertNumToHex {
   private static void toHex(int num) {
      if (num == 0) {
         return;
      }

      final char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
      final StringBuilder hexVal = new StringBuilder();
      while (num != 0) {
         hexVal.insert(0, map[num & 15]);
         num >>>= 4;
      }
      System.out.println(hexVal);
   }

   private static void toHexDivision(int num) {
      if (num == 0) {
         System.out.println("0");
      }

      long number = num;
      if (number < 0) {
         number = (1L<<32) + number;
      }

      final char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
      final StringBuilder result = new StringBuilder();
      while (number != 0) {
         result.append(map[(int)(number % 16)]);
         number = number / 16;
      }
      System.out.println(result.reverse());
   }

   public static void main(String[] args) {
      /*toHex(26);
      toHex(-1);*/
      toHexDivision(26);
      toHexDivision(-1);
   }
}
