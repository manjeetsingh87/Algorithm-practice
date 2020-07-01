package com.locationlabs.stuff.facebook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manjeet.singh on 5/21/20.
 */
public class RemoveAllAdjacentDuplicateStrings {
   private static String removeDuplicates(String S) {
      if (S == null || S.isEmpty()) {
         return null;
      }

      final Deque<Character> stack = new ArrayDeque<>();
      for (char ch : S.toCharArray()) {
         if (!stack.isEmpty() && stack.peek() == ch) {
            stack.pop();
         } else {
            stack.push(ch);
         }
      }

      if (stack.isEmpty()) {
         return null;
      }

      final StringBuilder sb = new StringBuilder();
      final int size = stack.size();
      for (int i = 0; i < size; i++) {
         sb.append(stack.pollLast());
      }

      return sb.toString();
   }

   public static void main(String[] args) {
      System.out.println(removeDuplicates("abbaca"));
   }
}
