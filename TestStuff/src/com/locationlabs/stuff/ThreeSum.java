package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manjeet.singh on 6/3/19.
 */
public class ThreeSum {
   private static List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      if (nums == null || nums.length < 3) {
         return result;
      }

      // sort the input array
      Arrays.sort(nums);

      for (int i = 0; i < nums.length - 2; i++) {
         if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
            int start = i+1, end = nums.length-1, sum = 0 - nums[i];
            while (start < end) {
               if (nums[start] + nums[end] == sum) {
                  result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                  while (start < end && nums[start] == nums[start+1]) {
                     start++;
                  }
                  while (start < end && nums[end] == nums[end-1]) {
                     end--;
                  }
                  start++;
                  end--;
               } else if (nums[start] + nums[end] < sum) {
                  start++;
               } else {
                  end--;
               }
            }
         }
      }

      return result;
   }

   private static int threeSumClosest(int[] nums, int target) {
      if (nums == null || nums.length < 3) {
         return 0;
      }

      Arrays.sort(nums);
      int n = nums.length;
      int closest = nums[0] + nums[1] + nums[2];
      for (int i = 0 ; i < n - 2; i++) {
         int start = i + 1, end = n - 1;
         while (start < end) {
            int sum = nums[i] + nums[start] + nums[end];
            if (sum == target) {
               return target;
            }

            if (sum > target) {
               while (start < end && nums[end] == nums[end-1]) {
                  end--;
               }
               end--;
            } else {
               while (start < end && nums[start] == nums[start+1]) {
                  start++;
               }
               start++;
            }

            if (Math.abs(target - sum) < Math.abs(target - closest)) {
               closest = sum;
            }
         }
      }
      return closest;
   }

   public static void main(String[] args) {
      /*System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));*/
      System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
   }
}
