package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/30/19.
 */
public class CanPlaceFlowers {
   private static boolean canPlaceFlowers(int[] flowerbed, int n) {
      if (flowerbed == null || flowerbed.length == 0) {
         return false;
      }

      int count = 0;
      for (int i=0; i<flowerbed.length; i++) {
         if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0)
                 && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
            flowerbed[i] = 1;
            count++;
         }

         if (count >= n) {
            return true;
         }
      }
      System.out.println(count);
      return false;
   }

   public static void main(String[] args) {
      System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
      System.out.println("-----------------------");
      System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
   }
}
