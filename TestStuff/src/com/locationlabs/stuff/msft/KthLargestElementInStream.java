package com.locationlabs.stuff.msft;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by manjeet.singh on 4/2/20.
 */
public class KthLargestElementInStream {
   private int size;
   private Queue<Integer> pq;

   public KthLargestElementInStream(int k, int[] nums) {
      this.size = k;
      pq = new PriorityQueue<>();
      initializePQ(nums);
   }

   private void initializePQ(int[] nums) {
      for (int num : nums) {
         pq.offer(num);
         if (pq.size() > this.size) {
            pq.remove();
         }
      }
   }

   public int add(int val) {
      pq.offer(val);
      if (pq.size() > this.size) {
         pq.remove();
      }
      return pq.peek();
   }

   public static void main(String[] args) {
      int[] arr = {4, 5, 8, 2};
      KthLargestElementInStream kthLargest = new KthLargestElementInStream(3, arr);
      System.out.println(kthLargest.add(3));   // returns 4
      System.out.println(kthLargest.add(5));   // returns 5
      System.out.println(kthLargest.add(10));  // returns 5
      System.out.println(kthLargest.add(9));   // returns 8
      System.out.println(kthLargest.add(4));   // returns 8
   }
}
