package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class MajorityElement {
   private static int majorityElement(int[] nums) {
      if (nums == null || nums.length == 0) {
         return Integer.MIN_VALUE;
      }

      int candidate = 0;
      int count = 0;
      for (int num : nums) {
         if (count == 0) {
            candidate = num;
         }

         count += (candidate == num) ? 1 : -1;
      }

      return candidate;
   }

   public static void main(String[] args) {
      System.out.println(majorityElement(new int[]{3, 2, 3}));
      System.out.println(majorityElement(new int[]{2,2,1,3,1,4,2}));
   }
}
