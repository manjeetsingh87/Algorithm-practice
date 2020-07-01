package com.locationlabs.stuff.apple;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/26/20.
 */
public class SortArray {
   private static int[] sortArray(int[] nums) {
      if (nums == null || nums.length <= 1) {
         return nums;
      }
      mergeSort(nums, 0, nums.length - 1);
      return nums;
   }

   private static void mergeSort(int[] nums, int low, int high) {
      if (low >= high) {
         return;
      }

      final int mid = low + (high - low) / 2;
      mergeSort(nums, low, mid);
      mergeSort(nums, mid + 1, high);
      merge(nums, low, high);
   }

   private static void merge(int[] nums, int low, int high) {
      final int len = high - low + 1;
      int[] tmp = new int[len];

      final int mid = low + (high - low) / 2;
      int i = low;
      int j = mid + 1;
      int k = 0;

      while (i <= mid && j <= high) {
         if (nums[i] <= nums[j]) {
            tmp[k++] = nums[i++];
         } else {
            tmp[k++] = nums[j++];
         }
      }

      while (i <= mid) {
         tmp[k++] = nums[i++];
      }

      while (j <= high) {
         tmp[k++] = nums[j++];
      }

      System.arraycopy(tmp, 0, nums, low, len);
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(sortArray(new int[]{5,2,3,1})));
      System.out.println(Arrays.toString(sortArray(new int[]{5,1,1,2,0,0})));
   }
}
