package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 4/30/19.
 */
public class MergeSortedArrays {
   private static void merge(int[] nums1, int m, int[] nums2, int n) {

      int array1Len = m -1;
      int array2Len = n-1;
      int targetLen = m + n - 1;

      while (array1Len >= 0 && array2Len >= 0) {
         nums1[targetLen--] = (nums1[array1Len] < nums2[array2Len]) ? nums2[array2Len--] : nums1[array1Len--];
      }

      while (array2Len >= 0) {
         nums1[targetLen--] = nums2[array2Len--];
      }

      //System.arraycopy(nums2, 0, nums1, 0, array2Len+1);

      System.out.println(Arrays.toString(nums1));
   }
   public static void main(String[] args) {
      merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
   }
}
