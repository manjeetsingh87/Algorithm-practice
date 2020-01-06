package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class SingleNumber {
   private static int singleNumber(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int singleNum = 0;
      for (int num : nums) {
         singleNum ^= num;
      }
      return singleNum;
   }

   public static void main(String[] args) {
      System.out.println(singleNumber(new int[]{2, 2, 1}));
      System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
   }
}
