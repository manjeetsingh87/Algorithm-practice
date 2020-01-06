package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/16/19.
 */
public class FirstLastElemPosSortedArray {
   private static int[] searchRange(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
         return new int[]{-1, -1};
      }

      int[] result = new int[]{-1, -1};

      int start = 0, end = nums.length - 1;

      while (start < end) {
         int mid = (start + end) / 2;

         if (nums[mid] < target) {
            start = mid + 1;
         } else {
            end = mid;
         }
      }

      if (nums[start] != target) {
         return result;
      }
      result[0] = start;

      end = nums.length - 1;
      while (start < end) {
         int mid = (start + end) / 2 + 1;

         if (nums[mid] > target) {
            end = mid - 1;
         } else {
            start = mid;
         }
      }
      result[1] = end;

      return result;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));

      //System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 3)));
   }
}
