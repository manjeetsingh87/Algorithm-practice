package com.locationlabs.stuff.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 5/18/19.
 */
public class FactorCombinations {
   private static List<List<Integer>> getFactors(int n) {
      List<List<Integer>> result = new ArrayList<>();

      if (n <= 3) {
         return result;
      }

      findFactors(result, new ArrayList<>(), n, 2);
      return result;
   }

   private static void findFactors(List<List<Integer>> result, List<Integer> current, int number, int factor) {
      int limit = (int) Math.sqrt(number);

      for (int i = factor; i <= limit; i++) {
         if (number % i == 0) {
            current.add(i);
            current.add(number/i);
            result.add(new ArrayList<>(current));
            current.remove(current.size()-1);
            findFactors(result, current, number/i, i);
            current.remove(current.size()-1);
         }
      }
   }

   public static void main(String[] args) {
      System.out.println(getFactors(16));
   }
}
