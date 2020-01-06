package com.locationlabs.stuff.apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manjeet.singh on 8/20/19.
 */
public class DissapearedNumsInArray {
   private static List<Integer> findDisappearedNumbers(int[] nums) {
      final List<Integer> result = new ArrayList<>();
      if (nums == null || nums.length == 0) {
         return result;
      }

      for (int i = 0; i < nums.length; i++) {
         int val = Math.abs(nums[i]) - 1;
         if (nums[val] > 0) {
            nums[val] = -nums[val];
         }
      }

      for (int i = 0; i < nums.length; i++) {
         if (nums[i] > 0) {
            result.add(i + 1);
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
   }
}
