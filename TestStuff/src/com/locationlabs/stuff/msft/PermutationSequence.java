package com.locationlabs.stuff.msft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by manjeet.singh on 4/11/20.
 */
public class PermutationSequence {
   /**
    * The logic is as follows: for n numbers the permutations can be divided to (n-1)! groups, for n-1 numbers can be divided to (n-2)! groups, and so on. Thus k/(n-1)! indicates the index of current number, and k%(n-1)! denotes remaining index for the remaining n-1 numbers.
    * We keep doing this until n reaches 0, then we get n numbers permutations that is kth.
    */
   private static String getPermutation(int n, int k) {
      if (n <= 0 || k <= 0) {
         return null;
      }

      final List<Integer> nums = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());

      int[] fact = new int[n];  // factorial
      fact[0] = 1;
      for (int i = 1; i < n; i++) {
         fact[i] = i * fact[i - 1];
      }

      k--;
      StringBuilder sb = new StringBuilder();
      for (int i = n; i > 0; i--) {
         int ind = k / fact[i-1];
         k %= fact[i-1];
         sb.append(nums.remove(ind));
      }
      return sb.toString();
   }

   public static void main(String[] args) {
      System.out.println(getPermutation(3, 3));
      System.out.println(getPermutation(4, 9));
   }
}
