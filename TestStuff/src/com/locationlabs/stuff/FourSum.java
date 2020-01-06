package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manjeet.singh on 9/30/19.
 */
public class FourSum {
   private static List<List<Integer>> fourSum(int[] nums, int target) {
      if (nums == null || nums.length < 4) {
         return new ArrayList<>();
      }

      Arrays.sort(nums);
      return getKSum(nums, target, 0, 4);
   }

   private static List<List<Integer>> getKSum(int[] nums, int target, int start, int k) {
      int len = nums.length;
      final List<List<Integer>> result = new ArrayList<>();
      if (k == 2) {
         int left = start, right = len - 1;
         while (left < right) {
            final int sum = nums[left] + nums[right];
            if (target == sum) {
               final List<Integer> temp = new ArrayList<>();
               temp.add(nums[left]);
               temp.add(nums[right]);
               result.add(temp);

               while (left < right && nums[left] == nums[left + 1]) {
                  left++;
               }

               while (left < right && nums[right] == nums[right - 1]) {
                  right--;
               }
               left++;
               right--;
            } else if (sum < target) {
               left++;
            } else {
               right--;
            }
         }
      } else {
         for (int i = start; i < len - (k - 1); i++) {
            if (i > start && nums[i] == nums[i - 1]) {
               continue;
            }
            final List<List<Integer>> temp = getKSum(nums, target - nums[i], i + 1, k - 1);
            for (List<Integer> t : temp) {
               t.add(0, nums[i]);
            }
            result.addAll(temp);
         }
      }
      return result;
   }

   public static void main(String[] args) {
      System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
   }
}
