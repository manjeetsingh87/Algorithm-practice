package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/13/20.
 */
public class OneBitCharacter {
   private static boolean isOneBitCharacter(int[] bits) {
      int ones = 0;
      //Starting from one but last, as last one is always 0.
      for (int i = bits.length - 2; i >= 0 && bits[i] != 0 ; i--) {
         ones++;
      }
      return ones % 2 == 0;
   }

   public static void main(String[] args) {
      System.out.println(isOneBitCharacter(new int[]{1, 0, 0}));
   }
}
