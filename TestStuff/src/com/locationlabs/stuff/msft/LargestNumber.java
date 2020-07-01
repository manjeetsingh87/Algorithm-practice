package com.locationlabs.stuff.msft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjeet.singh on 2/23/20.
 */
public class LargestNumber {
   private static int largestNumExtraSpace(int[] A) {
      if (A == null || A.length == 0) {
         return 0;
      }

      int largest = 0;
      final Set<Integer> set = new HashSet<>();
      for (int i : A) {
         set.add(-i);
         if (set.contains(i)) {
            largest = Math.max(largest, Math.abs(i));
         }
      }
      return largest;
   }

   private static int largestNum(int[] A) {
      if (A == null || A.length == 0) {
         return 0;
      }

      int largest = 0;
      Arrays.sort(A);
      int left = 0, right = A.length - 1;
      while (left < right) {
         final int sum = A[left] + A[right];
         if (sum == 0) {
            largest = Math.max(largest, Math.abs(A[right]));
            left++;
            right--;
         } else if (sum < 0) {
            left++;
         } else {
            right--;
         }
      }

      return largest;
   }

   public static void main(String[] args) {
      System.out.println(largestNum(new int[]{3, 2, -2, 5, -3}));
      System.out.println(largestNum(new int[]{1, 1, 2, -1, 2, -1}));
      System.out.println(largestNum(new int[]{1, 2, 3, -4}));

      System.out.println("\n---------------------------------\n");

      System.out.println(largestNumExtraSpace(new int[]{3, 2, -2, 5, -3}));
      System.out.println(largestNumExtraSpace(new int[]{1, 1, 2, -1, 2, -1}));
      System.out.println(largestNumExtraSpace(new int[]{1, 2, 3, -4}));
   }
}
