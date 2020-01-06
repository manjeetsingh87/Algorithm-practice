package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by manjeet.singh on 7/15/19.
 */
public class KPairsWithSmallestSum {
   private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      final List<List<Integer>> result = new ArrayList<>();
      if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
         return result;
      }

      final PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
              (a, b) -> (a.get(0) + a.get(1) - (b.get(0) + b.get(1))));

      for (int i = 0; i < nums1.length; i++) {
         pq.offer(Arrays.asList(nums1[i], nums2[0], 0));
      }

      while (k-- > 0 && !pq.isEmpty()) {
         List<Integer> currentMinPair = pq.poll();
         result.add(Arrays.asList(currentMinPair.get(0), currentMinPair.get(1)));
         int nexIdx = currentMinPair.get(2);
         if (nexIdx == nums2.length - 1) {
            continue;
         }
         pq.offer(Arrays.asList(currentMinPair.get(0), nums2[nexIdx + 1], nexIdx + 1));
      }
      System.out.println(result);
      return result;
   }

   public static void main(String[] args) {
      kSmallestPairs(new int[]{1,7,11}, new int[]{2, 4, 6}, 3);
      kSmallestPairs(new int[]{1,1,2}, new int[]{1, 2, 3}, 2);
      kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3);
   }
}
