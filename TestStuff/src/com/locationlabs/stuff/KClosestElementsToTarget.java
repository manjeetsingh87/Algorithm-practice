package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by manjeet.singh on 5/18/19.
 */
public class KClosestElementsToTarget {
   private static List<Integer> findClosestElements(int[] arr, int k, int x) {
      if (arr == null || arr.length == 0) {
         return null;
      }

      List<Integer> numList = Arrays.stream(arr).boxed().collect(Collectors.toList());
      Collections.sort(numList, (a, b) -> a.equals(b) ? (a - b) : Math.abs(a - x) - Math.abs(b - x));
      System.out.println(numList);
      numList = numList.subList(0, k);
      Collections.sort(numList);
      return numList;
   }

   private static List<Integer> findClosestElementsBSearch(int[] arr, int k, int x) {
      if (arr == null || arr.length == 0) {
         return null;
      }

      List<Integer> numList = Arrays.stream(arr).boxed().collect(Collectors.toList());

      if (x <= numList.get(0)) {
         return numList.subList(0, k);
      }

      int size = numList.size();

      if (x >= numList.get(size - 1)) {
         return numList.subList(size-k, size);
      }

      int index = Collections.binarySearch(numList, x);

      if (index < 0) {
         index = -index - 1;
      }

      int lower = Math.max(0, index - k - 1);
      int upper = Math.min(size - 1, index + k - 1);

      while (upper - lower > k - 1) {
         if (lower < 0 || (x - numList.get(lower)) <= (numList.get(upper) - x)) {
            upper--;
         } else if (upper > size-1 ||
                 (x - numList.get(lower)) > (numList.get(upper) - x)) {
            lower++;
         }
      }
      return numList.subList(lower, upper+1);
   }

   public static void main(String[] arr) {
      System.out.println(findClosestElementsBSearch(new int[]{1,2,10,10,12,15}, 3, 9));
   }
}
