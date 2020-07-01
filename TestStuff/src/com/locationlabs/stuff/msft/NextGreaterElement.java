package com.locationlabs.stuff.msft;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 4/7/20.
 */
public class NextGreaterElement {
   private static int[] nextGreaterElementI(int[] nums1, int[] nums2) {
      if (nums2 == null || nums2.length == 0) {
         return null;
      }

      final Deque<Integer> stack = new ArrayDeque<>();
      final Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums2) {
         while (!stack.isEmpty() && stack.peek() < num) {
            map.put(stack.pop(), num);
         }

         stack.push(num);
      }

      int[] result = new int[nums1.length];
      for (int i = 0; i < nums1.length; i++) {
         result[i] = map.getOrDefault(nums1[i], -1);
      }
      return result;
   }

   private static int[] nextGreaterElementsII(int[] nums) {
      if (nums == null || nums.length == 0) {
         return nums;
      }

      int len = nums.length;
      int[] result = new int[len];
      Arrays.fill(result, -1);

      final Deque<Integer> stack = new ArrayDeque<>();
      for (int i = 0; i < 2 * len; i++) {
         int num = nums[i % len];
         while (!stack.isEmpty() && nums[stack.peek()] < num) {
            result[stack.pop()] = num;
         }

         if (i < len) {
            stack.push(i);
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(nextGreaterElementI(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
      System.out.println(Arrays.toString(nextGreaterElementI(new int[]{2, 4}, new int[]{1, 2, 3, 4})));

      System.out.println(Arrays.toString(nextGreaterElementsII(new int[]{1, 2, 1})));
   }
}
