package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 9/26/19.
 */
public class Combinations {
   private static List<List<Integer>> combine(int n, int k) {
      final List<List<Integer>> combinations = new ArrayList<>();
      backtrack(combinations, new ArrayList<>(), 1, n, k);
      return combinations;
   }

   private static void backtrack(List<List<Integer>> combinations,
                                 List<Integer> conbination,
                                 int start, int n, int k) {
      if (k == 0) {
         combinations.add(conbination);
         return;
      }

      for (int i = start; i <= n; i++) {
         conbination.add(i);
         backtrack(combinations, new ArrayList<>(conbination), i + 1, n, k - 1);
         conbination.remove(conbination.size() - 1);
      }
   }

   public static void main(String[] args) {
      System.out.println(combine(4, 2));
   }
}
