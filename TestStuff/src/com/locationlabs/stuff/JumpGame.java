package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 6/4/19.
 */
public class JumpGame {
   private static boolean canJump(int[] nums) {
      if (nums == null || nums.length <= 1) {
         return true;
      }

      int lastPos = nums.length - 1;
      for (int i = nums.length - 2; i >= 0; i--) {
         if (i + nums[i] >= lastPos) {
            lastPos = i;
         }
      }

      return lastPos == 0;
   }

   private static boolean canJumpApproachII(int[] nums) {
      if (nums == null || nums.length <= 1) {
         return true;
      }
      int reachPos = 0;
      for (int i = 0; i < nums.length; i++) {
         if (reachPos < i) {
            return false;
         }
         reachPos = Math.max(reachPos, i + nums[i]);
      }
      return true;
   }

   private static int jumpGameII(int[] nums) {
      if (nums == null || nums.length <= 1) {
         return 0;
      }

      int jumps = 0, currEnd = 0, currentFarthest = 0;
      for (int i = 0; i < nums.length - 1; i++) {
         currentFarthest = Math.max(currentFarthest, i + nums[i]);
         if (i == currEnd) {
            jumps++;
            currEnd = currentFarthest;
         }
      }

      return jumps;
   }

   public static void main(String[] args) {
      System.out.println(canJump(new int[]{2,3,1,1,4}));
      System.out.println(canJumpApproachII(new int[]{2,3,1,1,4}));
      System.out.println("-------------------------------\n");
      System.out.println(canJump(new int[]{3,2,1,0,4}));
      System.out.println(canJumpApproachII(new int[]{3,2,1,0,4}));

      System.out.println("--------------------------------\n Jump II \n");
      System.out.println(jumpGameII(new int[]{2,3,1,1,4}));
   }
}
