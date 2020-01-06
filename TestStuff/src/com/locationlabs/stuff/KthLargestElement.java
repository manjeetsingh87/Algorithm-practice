package com.locationlabs.stuff;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/2/19.
 */
public class KthLargestElement {

   private static int findKthLargest(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      if (nums.length == 1) {
         return nums[0];
      }

      final Queue<Integer> heap = new PriorityQueue<>();

      for (int num : nums) {
         heap.offer(num);
         if (heap.size() > k) {
            heap.poll();
         }
      }

      return heap.poll();
   }

   public static void main(String[] args) {
      //System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
      System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
   }
}
