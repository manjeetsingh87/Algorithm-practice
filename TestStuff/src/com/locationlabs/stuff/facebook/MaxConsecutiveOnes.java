package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/8/19.
 */
public class MaxConsecutiveOnes {
   private static int findMaxConsecutiveOnes(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int max = 0, maxSoFar = 0;
      for (int num : nums) {
         if (num == 1) {
            maxSoFar++;
            max = Math.max(max, maxSoFar);
         } else {
            maxSoFar = 0;
         }
      }
      return max;
   }

   private static int findMaxConsecutiveOnesII(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int count = 0, previous = 0, current = 0;
      for (int num : nums) {
         if (num == 1) {
            current++;
         } else {
            previous = current + 1;
            current = 0;
         }
         count = Math.max(count, current + previous);
      }

      return count;
   }

   private static int findMaxConsecutiveOnesIII(int[] nums, int K) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int left = 0, right = 0, result = 0, count = 0;
      while (right < nums.length) {
         if (nums[right++] == 0) {
            count++;
         }

         while (count > K) {
            if (nums[left++] == 0) {
               count--;
            }
         }
         result = Math.max(result, right - left);
      }
      return result;
   }

   public static void main(String[] args) {
      System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
      System.out.println(findMaxConsecutiveOnesII(new int[]{1,1,0,0,1,1,1}));
      System.out.println(findMaxConsecutiveOnesIII(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
      System.out.println(findMaxConsecutiveOnesIII(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
   }
}
