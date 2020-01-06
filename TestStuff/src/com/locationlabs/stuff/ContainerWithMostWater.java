package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/17/19.
 */
public class ContainerWithMostWater {
   private static int maxArea(int[] height) {
      if (height == null || height.length < 2) {
         return 0;
      }

      int left = 0, right = height.length - 1;
      int maxArea = 0;

      while (left < right) {
         maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
         if (height[left] < height[right]) {
            left++;
         } else {
            right--;
         }
      }

      return maxArea;
   }

   public static void main(String[] args) {
      System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
   }
}
