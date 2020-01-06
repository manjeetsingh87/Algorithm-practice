package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/6/19.
 */
public class RangeSumImmutable {
   private int[] sum;

   public RangeSumImmutable(int[] nums) {
      sum = new int[nums.length + 1];
      for (int i = 0; i < nums.length; i++) {
         sum[i + 1] = sum[i] + nums[i];
      }
   }

   public int sumRange(int i, int j) {
      return sum[j + 1] - sum[i];
   }

   public static void main(String[] args) {
      final RangeSumImmutable rangeSumImmutable = new RangeSumImmutable(new int[]{-2, 0, 3, -5, 2, -1});
      System.out.println(rangeSumImmutable.sumRange(0, 2));
      System.out.println(rangeSumImmutable.sumRange(2, 5));
      System.out.println(rangeSumImmutable.sumRange(0, 5));
   }
}
