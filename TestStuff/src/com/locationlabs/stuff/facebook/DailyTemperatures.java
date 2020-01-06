package com.locationlabs.stuff.facebook;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by manjeet.singh on 8/7/19.
 */
public class DailyTemperatures {
   private static int[] dailyTemperatures(int[] T) {
      if (T == null || T.length == 0) {
         return new int[1];
      }

      int len = T.length;
      int[] result = new int[len];
      final Deque<Integer> stack = new ArrayDeque<>();

      for (int i = len - 1; i >= 0; i--) {
         while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
            stack.pop();
         }
         result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
         stack.push(i);
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
   }
}
