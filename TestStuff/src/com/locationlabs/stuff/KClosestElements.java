package com.locationlabs.stuff;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by manjeet.singh on 5/13/19.
 */
public class KClosestElements {

   private static List<Integer> findClosestElements(int[] arr, int k, int x) {
      if (arr == null || arr.length == 0) {
         return null;
      }

      int len = arr.length;
      if (x < arr[0]) {
         return Arrays.stream(Arrays.copyOfRange(arr, 0, k)).boxed().collect(Collectors.toList());
      }

      if (x > arr[arr.length - 1]) {
         return Arrays.stream(Arrays.copyOfRange(arr, len - k, len)).boxed().collect(Collectors.toList());
      }

      int index = Arrays.binarySearch(arr, x);
      if (index < 0) {
         index = -index - 1;
      }

      int low = Math.max(0, index - k - 1);
      int high = Math.min(len - 1, index + k - 1);

      while (high - low > k - 1) {
         if (low < 0 || (x - arr[low] <= arr[high] - x)) {
            high--;
         } else if (high > len || (x - arr[low] > arr[high] - x)) {
            low++;
         } else {
            // should never get here;
            // throw unhandled exception;
         }
      }

      return Arrays.stream(Arrays.copyOfRange(arr, low, high + 1)).boxed().collect(Collectors.toList());
   }

   public static void main(String[] args) {
      System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
      System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 2, 5));
   }
}
