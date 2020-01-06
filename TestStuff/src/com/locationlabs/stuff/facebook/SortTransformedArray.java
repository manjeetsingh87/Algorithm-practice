package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class SortTransformedArray {
   private static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
      if (nums == null || nums.length <= 1) {
         return nums;
      }

      final int[] result = new int[nums.length];
      int start = 0, end = nums.length - 1;
      int i = a >= 0 ? nums.length - 1 : 0;

      while (start <= end) {
         int startNum = getNum(nums[start], a, b, c);
         int endNum = getNum(nums[end], a, b, c);

         if (a >= 0) {
            if (startNum >= endNum) {
               result[i--] = startNum;
               start++;
            } else {
               result[i--] = endNum;
               end--;
            }
         } else {
            if (startNum <= endNum) {
               result[i++] = startNum;
               start++;
            } else {
               result[i++] = endNum;
               end--;
            }
         }
      }

      return result;
   }

   private static int getNum(int x, int a, int b, int c) {
      return (a * x * x) + (b * x) + c;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(sortTransformedArray(new int[]{-4,-2,2,4}, -1, 3, 5)));
   }
}
