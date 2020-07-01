package com.locationlabs.stuff.msft;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by manjeet.singh on 3/30/20.
 */
public class ContainsDuplicate {
   private static boolean containsDuplicate(int[] nums) {
      if (nums == null || nums.length <= 1) {
         return false;
      }

      final Set<Integer> set = new HashSet<>();
      for (int num : nums) {
         if (!set.add(num)) {
            return true;
         }
      }

      return false;
   }

   private static boolean containsDuplicateII(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
         return false;
      }

      final Set<Integer> set = new HashSet<>();

      for (int i = 0; i < nums.length; i++) {
         final int num = nums[i];
         if (!set.add(num)) {
            return true;
         }

         if (set.size() > k) {
            set.remove(nums[i - k]);
         }
      }

      return false;
   }

   private static boolean containsDuplicateIII(int[] nums, int k, long t) {
      if (nums == null || nums.length <= 1 || k <= 0) {
         return false;
      }

      final TreeSet<Long> window = new TreeSet<>();
      for (int i = 0; i < nums.length; i++) {
         final long current = nums[i];

         // find successor of this element in the tree
         // if diff between successor and this elem <= t, return true
         final Long successor = window.ceiling(current);
         if (successor != null && successor - current <= t) {
            return true;
         }

         // find predecessor of this element in the tree
         // if diff between successor and this elem <= t, return true
         final Long predecessor = window.floor(current);
         if (predecessor != null && current - predecessor <= t) {
            return true;
         }

         window.add(current);

         if (i >= k) {
            window.remove((long)(nums[i - k]));
         }
      }

      return false;
   }

   public static void main(String[] args) {
      /*System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
      System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
      System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));

      System.out.println(containsDuplicateII(new int[]{1, 2, 3, 1}, 3));
      System.out.println(containsDuplicateII(new int[]{1, 0, 1, 1}, 1));
      System.out.println(containsDuplicateII(new int[]{1, 2, 3, 1, 2, 3}, 2));*/

      System.out.println(containsDuplicateIII(new int[]{1, 2, 3, 1}, 3, 0));
      System.out.println(containsDuplicateIII(new int[]{1, 0, 1, 1}, 1, 2));
      System.out.println(containsDuplicateIII(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
      System.out.println(containsDuplicateIII(new int[]{-1, 2147483647}, 1, 2147483647));
   }
}
