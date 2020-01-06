package com.locationlabs.stuff;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by manjeet.singh on 1/15/19.
 */
public class SortArrayByParity {

   public static void main(String[] args) {
      final int[] input = {1,3,4,2};
      System.out.println(Arrays.toString(sortArray(input)));
   }

   public static int[] sortArrayByParity(int[] A) {
      final Deque<Integer> result = new ArrayDeque<>();
      for (int i = 0; i < A.length; i++) {
         if (A[i] % 2 == 0) {
            result.addFirst(A[i]);
         } else {
            result.addLast(A[i]);
         }
      }

      final int[] resArr = new int[result.size()];
      final Object[] tmpResult = result.toArray();

      for(int i = 0; i < tmpResult.length; i++) {
         resArr[i] = (int)tmpResult[i];
      }

      return resArr;
   }

   public static int[] sortArray(int[] A) {
      final int[] odds = new int[A.length];
      final int[] result = new int[A.length];
      int oddIdx = 0;
      int evenIdx = 0;
      for(int i = 0; i < A.length; i++) {
         if (A[i] % 2 == 0) {
            result[evenIdx++] = A[i];
         } else {
            odds[oddIdx++] = A[i];
         }
      }

      for (int i = 0; i < odds.length; i++) {
         if (odds[i] != 0) {
            result[evenIdx++] = odds[i];
         }
      }

      return result;
   }
}
