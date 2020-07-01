package com.locationlabs.stuff.apple;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by manjeet.singh on 6/24/20.
 */
public class SlidingWindowMedian {
   private static final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
   private static final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));

   private static double[] medianSlidingWindow(int[] nums, int k) {
      if (nums == null || nums.length == 0 || k <= 0) {
         return new double[0];
      }

      final int n = nums.length;
      final double[] result = new double[n - k + 1];

      for (int i = 0; i < n; i++) {
         add(nums[i]);
         if (i - k >= 0) {
            remove(nums[i - k]);
         }

         if (i - k + 1 >= 0) {
            result[i - k + 1] = getMedian();
         }
      }

      return result;
   }

   private static void add(int num) {
      if (minHeap.isEmpty()) {
         minHeap.offer(num);
         return;
      }

      if (minHeap.peek() <= num) {
         minHeap.offer(num);
      } else {
         maxHeap.offer(num);
      }

      rebalance();
   }

   private static void remove(int num) {
      if (minHeap.peek() <= num) {
         minHeap.remove(num);
      } else {
         maxHeap.remove(num);
      }

      rebalance();
   }

   private static void rebalance() {
      if (minHeap.size() - maxHeap.size() > 1) {
         maxHeap.offer(minHeap.poll());
      } else if (maxHeap.size() > minHeap.size()) {
         minHeap.offer(maxHeap.poll());
      }
   }

   private static double getMedian() {
      if (maxHeap.isEmpty() && minHeap.isEmpty()) {
         return 0.0;
      }

      if (maxHeap.size() == minHeap.size()) {
         return (((double)maxHeap.peek()) + ((double) minHeap.peek())) / 2.0;
      }

      return (double) minHeap.peek();
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
      minHeap.clear();
      maxHeap.clear();
      System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1,4,2,3}, 4)));
   }
}
