package com.locationlabs.stuff.msft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 4/9/20.
 */
public class SummaryRanges {
   private static List<String> summaryRanges(int[] nums) {
      final List<String> ranges = new ArrayList<>();

      if (nums == null || nums.length == 0) {
         return ranges;
      }

      int j;
      for (int i = 0; i < nums.length; ) {
         StringBuilder currentRange = new StringBuilder(String.valueOf(nums[i]));
         j = i;
         while (j < nums.length - 1 && nums[j + 1] - nums[j] == 1) {
            j++;
         }

         if (nums[i] != nums[j]) {
            currentRange.append("->").append(nums[j]);
         }

         i = j + 1;
         ranges.add(currentRange.toString());
      }

      return ranges;
   }

   public static void main(String[] args) {
      System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
      System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
      System.out.println(summaryRanges(new int[]{0}));
   }
}
