package com.locationlabs.stuff.apple;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 6/19/20.
 */
public class SlidingWindowMax {
   private static int[] maxSlidingWindow(int[] nums, int k) {
      if (nums == null || nums.length == 0 || k <= 0) {
         return new int[0];
      }

      final int len = nums.length;
      int[] leftMax = new int[len];
      int[] rightMax = new int[len];

      leftMax[0] = nums[0];
      rightMax[len - 1] = nums[len - 1];

      for (int i = 1; i < len; i++) {
         leftMax[i] = (i % k == 0) ? nums[i] : Math.max(leftMax[i - 1], nums[i]);

         final int right = len - 1 - i;
         rightMax[right] = (right % k == 0) ? nums[right] : Math.max(rightMax[right + 1], nums[right]);
      }

      int[] slidingMax = new int[len - k + 1];
      for (int i = 0; i < len - k + 1; i++) {
         slidingMax[i] = Math.max(leftMax[i + k - 1], rightMax[i]);
      }
      return slidingMax;
   }

   private static int[] slidingWindowMax(int[] nums, int k) {
      if (nums == null || nums.length == 0 || k <= 0) {
         return new int[0];
      }

      final int len = nums.length;

      final int[] result = new int[len - k + 1];
      int idx = 0;
      final Deque<Integer> queue = new ArrayDeque<>();

      for (int i = 0; i < len; i++) {
         while (!queue.isEmpty() && queue.peek() < i - k + 1) {
            queue.poll();
         }

         while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
            queue.pollLast();
         }

         queue.offer(i);
         if (i >= k - 1) {
            result[idx++] = nums[queue.peek()];
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
      System.out.println(Arrays.toString(slidingWindowMax(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
   }
}
