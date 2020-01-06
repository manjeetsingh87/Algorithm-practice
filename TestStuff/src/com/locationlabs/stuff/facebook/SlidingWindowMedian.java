package com.locationlabs.stuff.facebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Supplier;

/**
 * Created by manjeet.singh on 8/12/19.
 */
public class SlidingWindowMedian {
   private static double[] medianSlidingWindow(int[] nums, int k) {
      final Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
      final TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
      final TreeSet<Integer> right = new TreeSet<>(comparator);

      final Supplier<Double> median = (k % 2 == 0) ?
              () -> ((double) nums[left.first()] + nums[right.first()]) / 2 :
              () -> ((double) nums[right.first()]);

      final Runnable balance = () -> {
         while (right.size() < left.size()) {
            right.add(left.pollFirst());
         }
      };

      final double[] result = new double[nums.length - k + 1];

      for (int i = 0; i < k; i++) {
         left.add(i);
      }

      balance.run();

      result[0] = median.get();

      int r = 1;
      for (int i = k; i < nums.length; i++) {
         // remove tail of window from either left or right
         if (!left.remove(i - k)) {
            right.remove(i - k);
         }

         // add next num, this will always increase left size
         right.add(i);
         left.add(right.pollFirst());

         // rebalance left and right, then get median from them
         balance.run();
         result[r++] = median.get();
      }

      return result;
   }

   public static void main(String[] args) {
      double[] result = medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
      System.out.println(Arrays.toString(result));
   }
}
