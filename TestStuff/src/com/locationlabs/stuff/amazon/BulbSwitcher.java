package com.locationlabs.stuff.amazon;

/**
 * Created by manjeet.singh on 5/11/20.
 */
public class BulbSwitcher {
   private static int numTimesAllBlue(int[] light) {
      if (light == null || light.length <= 1) {
         return 0;
      }

      int right = 0;
      int times = 0;

      for (int left = 0; left < light.length; left++) {
         right = Math.max(right, light[left]);

         if (right == left + 1) {
            times++;
         }
      }

      return times;
   }

   public static void main(String[] args) {
      System.out.println(numTimesAllBlue(new int[]{2, 1, 3, 5, 4}));
      System.out.println(numTimesAllBlue(new int[]{3, 2, 4, 1, 5}));
      System.out.println(numTimesAllBlue(new int[]{4, 1, 2, 3}));
      System.out.println(numTimesAllBlue(new int[]{2, 1, 4, 3, 6, 5}));
      System.out.println(numTimesAllBlue(new int[]{1, 2, 3, 4, 5, 6}));
   }
}
