package com.locationlabs.stuff.apple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 6/25/20.
 */
public class MajorityElementII {
   private static List<Integer> majorityElement(int[] nums) {
      final List<Integer> result = new ArrayList<>();
      if (nums == null || nums.length < 3) {
         return result;
      }

      final int len = nums.length;
      int num1 = nums[0], num2 = nums[0];
      int count1 = 0, count2 = 0;

      for (int num : nums) {
         if (num == num1) {
            count1++;
         } else if (num == num2) {
            count2++;
         } else if (count1 == 0) {
            num1 = num;
            count1 = 1;
         } else if (count2 == 0) {
            num2 = num;
            count2 = 1;
         } else {
            count1--;
            count2--;
         }
      }

      count1 = 0;
      count2 = 0;

      for (int num : nums) {
         if (num == num1) {
            count1++;
         } else if (num == num2) {
            count2++;
         }
      }

      if (count1 > nums.length / 3) {
         result.add(num1);
      }

      if (count2 > nums.length / 3) {
         result.add(num2);
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(majorityElement(new int[]{3, 2, 3}));
      System.out.println(majorityElement(new int[]{1,1,1,3,3,2,2,2}));
   }
}
