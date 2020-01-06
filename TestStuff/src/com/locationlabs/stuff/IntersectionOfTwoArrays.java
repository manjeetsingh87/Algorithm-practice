package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by manjeet.singh on 4/25/19.
 */
public class IntersectionOfTwoArrays {
   private static int[] intersection(int[] nums1, int[] nums2) {
      Set<Integer> set1 = IntStream.of(nums1).boxed().collect(Collectors.toSet());

      final Set<Integer> intersectionSet = new HashSet<>();
      for (int n : nums2) {
         if (set1.contains(n) && !intersectionSet.contains(n)) {
            intersectionSet.add(n);
         }
      }

      return intersectionSet.stream().mapToInt(Integer::intValue).toArray();
   }

   private static int[] intersectionII(int[] nums1, int[] nums2) {
      if (nums1 == null || nums2 == null ||
              nums1.length == 0 || nums2.length == 0) {
         return new int[0];
      }

      final Map<Integer, Integer> map = new HashMap<>();
      for(int num : nums1) {
         int count = map.getOrDefault(num, 0);
         map.put(num, count + 1);
      }

      final List<Integer> result = new ArrayList<>();
      for (int num : nums2) {
         int count = map.getOrDefault(num, 0);
         if (count > 1) {
            result.add(num);
            map.put(num, count - 1);
         } else if (count == 1) {
            result.add(num);
            map.remove(num);
         }
      }

      return result.stream().mapToInt(Integer::intValue).toArray();
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(intersectionII(new int[]{1,2,2,3,4}, new int[]{2,2})));
      System.out.println(Arrays.toString(intersectionII(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
   }
}
