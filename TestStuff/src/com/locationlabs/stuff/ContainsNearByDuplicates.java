package com.locationlabs.stuff;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjeet.singh on 6/17/19.
 */
public class ContainsNearByDuplicates {
   private static boolean containsNearbyDuplicate(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
         return false;
      }

      final Set<Integer> set = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
         if (set.contains(nums[i])) {
            return true;
         }
         set.add(nums[i]);
         if (set.size() > k) {
            set.remove(nums[i-k]);
         }
      }

      return false;
   }

   public static void main(String[] args) {
      /*System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
      System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));*/
      System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
   }
}
