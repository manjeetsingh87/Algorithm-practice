package com.locationlabs.stuff.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/19/20.
 */
public class SteppingNumber {
   private static List<Integer> countSteppingNumbers(int low, int high) {
      final List<Integer> result = new ArrayList<>();
      if (low > high) {
         return result;
      }

      /*final Queue<Long> queue = new LinkedList<>();
      for (long i = 1; i <= 9; i++) {
         queue.offer(i);
      }

      if (low == 0) {
         result.add(0);
      }

      while (!queue.isEmpty()) {
         final long curr = queue.poll();

         if (curr >= low && curr <= high) {
            result.add((int)curr);
         }

         if (curr > high) {
            continue;
         }

         long lastDigit = curr % 10;
         if (lastDigit > 0) {
            queue.offer(curr * 10 + lastDigit - 1);
         }

         if (lastDigit < 9) {
            queue.offer(curr * 10 + lastDigit + 1);
         }
      }*/

      if (low == 0) {
         result.add(0);
      }

      for (long i = 1; i <= 9; i++) {
         dfs(low, high, i, result);
      }

      Collections.sort(result);

      return result;
   }

   private static void dfs(int low, int high, long curr, List<Integer> result) {
      if (curr == 0 || curr > high) {
         return;
      }

      if (curr >= low && curr <= high) {
         result.add((int)curr);
      }

      long lastDigit = curr % 10;
      long inc = curr * 10 + lastDigit + 1;
      long dec = curr * 10 + lastDigit - 1;

      if (lastDigit > 0) {
         dfs(low, high, dec, result);
      }

      if (lastDigit < 9) {
         dfs(low, high, inc, result);
      }
   }

   public static void main(String[] args) {
      System.out.println(countSteppingNumbers(80, 95));
   }
}
