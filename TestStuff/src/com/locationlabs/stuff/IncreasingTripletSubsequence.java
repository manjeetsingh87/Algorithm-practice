package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/17/19.
 */
public class IncreasingTripletSubsequence {
   private static boolean increasingTriplet(int[] nums) {
      if (nums == null || nums.length < 3) {
         return false;
      }

      int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
      for (int num : nums) {
         if (num <= firstMin) {
            firstMin = num;
         } else if (num < secondMin) {
            secondMin = num;
         } else if (num > secondMin) {
            return true;
         }
      }
      return false;
   }

   public static void main(String[] args) {
      System.out.println(increasingTriplet(new int[]{1,2,3,4,5}));
      System.out.println(increasingTriplet(new int[]{5,4,3,2,1}));
   }
}
