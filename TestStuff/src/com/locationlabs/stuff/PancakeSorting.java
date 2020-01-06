package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manjeet.singh on 6/3/19.
 */
public class PancakeSorting {
   private static List<Integer> pancakeSort(int[] A) {
      final List<Integer> result = new ArrayList<>();

      if (A == null || A.length < 2) {
         return result;
      }

      int len = A.length;
      int largest = len;

      for (int i = 0; i < len; i++) {
         int index = findLargest(A, largest);
         flip(A, 0, index);
         result.add(index+1);
         flip(A, 0, largest-1);
         result.add(largest--);
      }

      return result;
   }

   private static int findLargest(int[] A, int target) {
      int max = A[0];
      int maxIdx = 0;
      for (int i = 1; i < target; i++) {
         if (A[i] > max) {
            max = A[i];
            maxIdx = i;
         }
      }

      return maxIdx;
   }

   private static void flip(int[] A, int startIdx, int endIdx) {
      while (startIdx < endIdx) {
         int temp = A[startIdx];
         A[startIdx++] = A[endIdx];
         A[endIdx--] = temp;
      }
   }

   public static void main(String[] args) {
      System.out.println(pancakeSort(new int[]{3,2,4,1}));
   }
}
