package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/12/19.
 */
public class TrappingRainWater {
   private static int trap(int[] height) {
      if (height == null || height.length == 0) {
         return 0;
      }

      int ans = 0;
      int left = 0, right = height.length - 1;
      int leftMax = 0, rightMax = 0;

      while (left < right) {
         if (height[left] < height[right]) {
            if (height[left] > leftMax) {
               leftMax = height[left];
            } else {
               ans += leftMax - height[left];
            }
            left++;
         } else {
            if (height[right] > rightMax) {
               rightMax = height[right];
            } else {
               ans += rightMax - height[right];
            }
            right--;
         }
      }

      return ans;
   }

   public static void main(String[] args) {
      System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
   }
}
