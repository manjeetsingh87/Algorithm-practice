package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by manjeet.singh on 5/2/19.
 */
public class TopKFrequentElements {
   private static List<Integer> topKFrequent(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
         return null;
      }

      if (k >= nums.length) {
         return Arrays.stream(nums).boxed().collect(Collectors.toList());
      }

      final Map<Integer, Integer> map = new HashMap<>();
      for(int num : nums) {
         map.put(num, map.getOrDefault(num, 0) + 1);
      }

      final Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

      for (int num : map.keySet()) {
         heap.offer(num);
         if (heap.size() > k) {
            heap.poll();
         }
      }

      final LinkedList<Integer> result = new LinkedList<>();

      while (!heap.isEmpty()) {
         result.addFirst(heap.poll());
      }

      return result;
   }

   private static List<Integer> topKFrequentItems(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
         return null;
      }

      if (k >= nums.length) {
         return Arrays.stream(nums).boxed().collect(Collectors.toList());
      }

      final Map<Integer, Integer> map = new HashMap<>();
      for(int num : nums) {
         map.put(num, map.getOrDefault(num, 0) + 1);
      }

      final List<Integer>[] bucket = new List[nums.length + 1];
      for (int num : map.keySet()) {
         int frequency = map.get(num);
         if (bucket[frequency]== null) {
            bucket[frequency] = new ArrayList<>();
         }
         bucket[frequency].add(num);
      }

      final List<Integer> result = new ArrayList<>();
      for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
         if (bucket[i] != null) {
            result.addAll(bucket[i]);
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(topKFrequent(new int[]{1,1,1,2,2,3}, 2));
      System.out.println(topKFrequent(new int[]{1}, 1));
      System.out.println(topKFrequentItems(new int[]{1,1,1,2,2,3}, 2));
      System.out.println(topKFrequentItems(new int[]{1}, 1));
   }
}
