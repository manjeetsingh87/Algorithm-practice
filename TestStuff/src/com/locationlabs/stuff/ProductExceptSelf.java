package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/12/19.
 */
public class ProductExceptSelf {
   private static int[] productExceptSelf(int[] nums) {
      if (nums == null || nums.length == 0) {
         return nums;
      }

      int[] leftProducts = new int[nums.length];
      leftProducts[0] = 1;
      for (int i = 1; i < nums.length; i++) {
         leftProducts[i] = leftProducts[i-1] * nums[i-1];
      }

      int[] rightProducts = new int[nums.length];
      rightProducts[nums.length-1] = 1;
      for (int i = nums.length-2; i >= 0; i--) {
         rightProducts[i] = rightProducts[i+1] * nums[i+1];
      }

      int[] result = new int[nums.length];
      for (int i = 0; i < result.length; i++) {
         result[i] = leftProducts[i] * rightProducts[i];
      }
      return result;
   }

   private static int[] productExceptSelfInPlace(int[] nums) {
      if (nums == null || nums.length < 2) {
         return nums;
      }

      int[] result = new int[nums.length];
      result[0] = 1;
      for (int i = 1; i < nums.length; i++) {
         result[i] = result[i-1] * nums[i-1];
      }

      int right = 1;
      for (int i = nums.length-1; i >= 0; i--) {
         result[i] *= right;
         right *= nums[i];
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
      System.out.println(Arrays.toString(productExceptSelfInPlace(new int[]{1,2,3,4})));
   }
}
