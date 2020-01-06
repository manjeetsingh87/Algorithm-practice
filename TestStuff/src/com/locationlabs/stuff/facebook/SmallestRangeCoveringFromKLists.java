package com.locationlabs.stuff.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by manjeet.singh on 8/13/19.
 */
public class SmallestRangeCoveringFromKLists {
   private static int[] smallestRange(List<List<Integer>> nums) {
      if (nums == null || nums.size() == 0) {
         return new int[0];
      }

      final PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < nums.size(); i++) {
         final Tuple element = new Tuple(i, 0, nums.get(i).get(0));
         pq.offer(element);
         max = Math.max(max, element.val);
      }

      int range = Integer.MAX_VALUE;
      int start = -1, end = -1;
      while (pq.size() == nums.size()) {
         Tuple curr = pq.poll();
         if (max - curr.val < range) {
            range = max - curr.val;
            start = curr.val;
            end = max;
         }

         if (curr.col + 1 < nums.get(curr.row).size()) {
            int nextVal = nums.get(curr.row).get(curr.col + 1);
            Tuple next = new Tuple(curr.row, curr.col + 1, nextVal);
            pq.offer(next);
            max = Math.max(max, next.val);
         }
      }

      return new int[]{start, end};
   }

   private static class Tuple {
      int row, col, val;
      private Tuple (int row, int col, int val) {
         this.row = row;
         this.col = col;
         this.val = val;
      }
   }

   public static void main(String[] args) {
      List<List<Integer>> input = new ArrayList<>();
      input.add(Arrays.asList(4,10,15,24,26));
      input.add(Arrays.asList(0,9,12,20));
      input.add(Arrays.asList(5,18,22,30));
      int[] result = smallestRange(input);
      System.out.println(Arrays.toString(result));
   }
}
