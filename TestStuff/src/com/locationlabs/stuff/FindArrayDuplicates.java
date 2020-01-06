package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 10/16/19.
 */
public class FindArrayDuplicates {
   private static List<Integer> findDuplicates(int[] nums) {
      final List<Integer> duplicates = new ArrayList<>();
      if (nums == null || nums.length <= 1) {
         return duplicates;
      }

      for (int i = 0; i < nums.length; i++) {
         final int idx = Math.abs(nums[i]) - 1;
         if (nums[idx] < 0) {
            duplicates.add(Math.abs(idx + 1));
         }
         nums[idx] = -nums[idx];
      }

      return duplicates;
   }

   public static void main(String[] args) {
      System.out.println(findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
   }
}
