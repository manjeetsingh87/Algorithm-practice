package com.locationlabs.stuff.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 5/21/20.
 */
public class IntersectionOfThreeSortedArrays {
   private static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
      final List<Integer> result = new ArrayList<>();

      int i = 0, j = 0, k = 0;
      while (i < arr1.length && j < arr2.length && k < arr3.length) {
         if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
            result.add(arr1[i]);
            i++;
            j++;
            k++;
         } else {
            final int max = Math.max(arr1[i], Math.max(arr2[j], arr3[k]));

            while (i < arr1.length && arr1[i] < max) {
               i++;
            }

            while (j < arr2.length && arr2[j] < max) {
               j++;
            }

            while (k < arr3.length && arr3[k] < max) {
               k++;
            }
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(arraysIntersection(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 5, 7, 9}, new int[]{1, 3, 4, 5, 8}));
   }
}
