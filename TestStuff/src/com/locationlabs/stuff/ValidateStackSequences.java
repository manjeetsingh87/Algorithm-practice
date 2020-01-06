package com.locationlabs.stuff;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manjeet.singh on 7/9/19.
 */
public class ValidateStackSequences {
   private static boolean validateStackSequences(int[] pushed, int[] popped) {
      if ((pushed == null && popped == null) || (pushed.length == 0 && popped.length == 0)) {
         return true;
      }

      if (pushed == null || popped == null) {
         return false;
      }

      if (pushed.length != 0 || popped.length != 0) {
         return false;
      }

      int pushLen = pushed.length , j = 0;
      final Deque<Integer> stack = new ArrayDeque<>();

      for (int num : pushed) {
         stack.push(num);
         while (!stack.isEmpty() && j < pushLen && stack.peek() == popped[j]) {
            stack.pop();
            j++;
         }
      }

      return stack.isEmpty();
   }

   public static void main(String[] args) {
      System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
      System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
   }
}
