package com.locationlabs.stuff.msft;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by manjeet.singh on 3/30/20.
 */
public class RelativeSortArray {
   private static int[] relativeSortArray(int[] arr1, int[] arr2) {
      if ((arr2 == null || arr2.length == 0) || (arr1 == null || arr1.length == 0)) {
         return arr1;
      }

      final TreeMap<Integer, Integer> arr1NumCounts = new TreeMap<>();
      for (int num : arr1) {
         arr1NumCounts.put(num, arr1NumCounts.getOrDefault(num, 0) + 1);
      }

      final int[] result = new int[arr1.length];
      int i = 0;
      for (int num : arr2) {
         if (arr1NumCounts.containsKey(num)) {
            i = populateResult(arr1NumCounts, result, i, num);
         }
         arr1NumCounts.remove(num);
      }

      for (int num : arr1NumCounts.keySet()) {
         i = populateResult(arr1NumCounts, result, i, num);
      }

      System.out.println(Arrays.toString(result));

      return result;
   }

   private static int populateResult(TreeMap<Integer, Integer> arr1NumCounts, int[] result, int i, int num) {
      int repetition = arr1NumCounts.get(num);
      while (repetition-- > 0) {
         result[i++] = num;
      }
      return i;
   }

   public static void main(String[] args) {
      relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6});
      relativeSortArray(new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31}, new int[]{2,42,38,0,43,21});
   }
}
