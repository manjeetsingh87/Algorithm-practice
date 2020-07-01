package com.locationlabs.stuff.amazon;

/**
 * Created by manjeet.singh on 5/17/20.
 */
public class NumberOfNiceSubarrays {
   private static int numberOfSubarrays(int[] nums, int k) {
      if (nums == null || nums.length == 0 || k <= 0) {
         return 0;
      }

      final int len = nums.length;
      int oddCount = 0, left = 0;
      int niceCount = 0;
      int count = 0;

      for (int right = 0; right < len; right++) {
         if (nums[right] % 2 == 1) {
            oddCount++;
         }

         if (oddCount == k) {
            count = 0;
            while (oddCount == k) {
               if (nums[left++] % 2 == 1) {
                  oddCount--;
               }
               count++;
            }
         }

         niceCount += count;
      }

      return niceCount;
   }

   public static void main(String[] args) {
      System.out.println(numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
      System.out.println(numberOfSubarrays(new int[]{2, 4, 6}, 1));
      System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
   }
}
