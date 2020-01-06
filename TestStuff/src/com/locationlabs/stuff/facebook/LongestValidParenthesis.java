package com.locationlabs.stuff.facebook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manjeet.singh on 8/12/19.
 */
public class LongestValidParenthesis {
   private static int longestValidParentheses(String s) {
      if (s == null || s.isEmpty()) {
         return 0;
      }

      final Deque<Integer> stack = new ArrayDeque<>();
      int max = 0, left = -1;

      for (int i = 0; i < s.length(); i++) {
         if (s.charAt(i) == '(') {
            stack.push(i);
         } else {
            if (stack.isEmpty()) {
               left = i;
            } else {
               stack.pop();
               if (stack.isEmpty()) {
                  max = Math.max(max, i - left);
               } else {
                  max = Math.max(max, i - stack.peek());
               }
            }
         }
      }

      return max;
   }

   public static void main(String[] args) {
      System.out.println(longestValidParentheses("(()"));
      System.out.println(longestValidParentheses(")()())"));
   }
}
