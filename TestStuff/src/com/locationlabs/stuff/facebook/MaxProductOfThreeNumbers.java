package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/6/19.
 */
public class MaxProductOfThreeNumbers {
   private static int maximumProduct(int[] nums) {
      if (nums == null || nums.length < 3) {
         return 0;
      }

      int max1 = Integer.MIN_VALUE;
      int max2 = Integer.MIN_VALUE;
      int max3 = Integer.MIN_VALUE;
      int min1 = Integer.MAX_VALUE;
      int min2 = Integer.MAX_VALUE;

      for (int num : nums) {
         if (num > max1) {
            max3 = max2;
            max2 = max1;
            max1 = num;
         } else if (num > max2) {
            max3 = max2;
            max2 = num;
         } else if (num > max3) {
            max3 = num;
         }

         if (num < min1) {
            min2 = min1;
            min1 = num;
         } else if (num < min2) {
            min2 = num;
         }
      }

      return Math.max(min1 * min2 * max1, max1 * max2 * max3);
   }

   public static void main(String[] args) {
      System.out.println(maximumProduct(new int[]{1,2,3}));
      System.out.println(maximumProduct(new int[]{1,2,3,4}));
      System.out.println(maximumProduct(new int[]{-1,-2,-3}));
   }
}
