package com.locationlabs.stuff.msft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 4/9/20.
 */
public class GrayCode {

   private static List<Integer> grayCode(int n) {
      final List<Integer> result = new ArrayList<>();

      if (n <= 0) {
         result.add(0);
         return result;
      }

      for (int i = 0; i < 1 << n; i++) {
         result.add(i ^ i >> 1);
      }
      return result;
   }

   private static List<Integer> grayCodeDP(int n) {
      final List<Integer> result = new ArrayList<>();
      result.add(0);

      if (n == 0) {
         return result;
      }

      int increase = 1;

      for (int i = 0; i < n; i++) {
         int len = result.size();
         for (int j = len - 1; j >= 0; j--) {
            result.add(result.get(j) + increase);
         }

         increase *= 2;
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(grayCode(2));
      System.out.println(grayCodeDP(2));
   }
}
