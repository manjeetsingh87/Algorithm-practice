package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 6/17/19.
 */
public class WiggleSort {
   private static void wiggleSort(int[] nums) {
      if (nums == null || nums.length == 0) {
         return;
      }

      for (int i = 0; i < nums.length; i++) {
         if (i % 2 == 1) {
            if (nums[i-1] > nums[i]) {
               swap(nums, i);
            }
         } else if (i != 0 && nums[i-1] < nums[i]) {
            swap(nums, i);
         }
      }

      System.out.println(Arrays.toString(nums));
   }

   private static void swap(int[] nums, int i){
      int tmp=nums[i];
      nums[i]=nums[i-1];
      nums[i-1]=tmp;
   }

   public static void main(String[] args) {
      wiggleSort(new int[]{3,5,2,1,6,4});
   }
}
