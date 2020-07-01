package com.locationlabs.stuff.msft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by manjeet.singh on 4/10/20.
 */
public class SubsetsII {
   private static List<List<Integer>> subsetsWithDup(int[] nums) {
      final List<List<Integer>> subsets = new ArrayList<>();

      if (nums == null || nums.length == 0) {
         return subsets;
      }

      Arrays.sort(nums);
      backtrack(nums, subsets, new ArrayList<>(), 0);
      return subsets;
   }

   private static void backtrack(int[] nums,
                                 List<List<Integer>> subsets,
                                 List<Integer> subset,
                                 int index) {
      subsets.add(new ArrayList<>(subset));

      for (int i = index; i < nums.length; i++) {
         final int curr = nums[i];
         if (i > index && curr == nums[i - 1]) {
            continue;
         }
         subset.add(curr);
         backtrack(nums, subsets, subset, i + 1);
         subset.remove(subset.size() - 1);
      }
   }

   public static void main(String[] args) {
      System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
   }
}
