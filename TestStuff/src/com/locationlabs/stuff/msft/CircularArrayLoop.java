package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/7/20.
 */
public class CircularArrayLoop {
   private static boolean circularArrayLoop(int[] nums) {
      if (nums == null || nums.length == 0) {
         return false;
      }

      for (int i = 0 ;i < nums.length; i++) {
         Integer slow = i;
         Integer fast = next(nums, 0, i);
         int dir = nums[i];

         while (slow != null && fast != null && slow != fast) {
            slow = next(nums, dir, slow);
            fast = next(nums, dir, next(nums, dir, fast));
         }

         if (slow != null && fast == slow) {
            return true;
         }
      }

      return false;
   }

   private static Integer next(int[] nums, int dir, Integer pos) {
      if (pos == null) {
         return null;
      }

      if (dir * nums[pos] < 0) { // indicates change of direction
         return null;
      }

      Integer next = (pos + nums[pos]) % nums.length;
      if (next < 0) { // wraparound negative
         next += nums.length;
      }

      if (pos == next) { // looping over itself, break
         next = null;
      }

      return next;
   }

   public static void main(String[] args) {
      System.out.println(circularArrayLoop(new int[]{2,-1,1,2,2}));
      /*System.out.println(circularArrayLoop(new int[]{-1, 2}));
      System.out.println(circularArrayLoop(new int[]{-2,1,-1,-2,-2}));*/
   }
}
