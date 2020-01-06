package com.locationlabs.stuff.facebook;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by manjeet.singh on 8/6/19.
 */
public class ThirdMaxNumber {
   private static int thirdMax(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      final Queue<Integer> pq = new PriorityQueue<>();
      final Set<Integer> seen = new HashSet<>();
      for (int num : nums) {
         if (seen.contains(num)) {
            continue;
         }
         pq.offer(num);
         seen.add(num);
         if (pq.size() > 3) {
            seen.remove(pq.poll());
         }
      }

      if (pq.size() < 3) {
         while (pq.size() > 1) {
            pq.poll();
         }
      }
      return pq.poll();
   }

   public static void main(String[] args) {
      System.out.println(thirdMax(new int[]{1, 2, 3}));
      System.out.println(thirdMax(new int[]{1, 2}));
      System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
   }
}
