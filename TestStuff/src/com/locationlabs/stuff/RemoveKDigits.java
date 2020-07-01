package com.locationlabs.stuff;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manjeet.singh on 10/7/19.
 */
public class RemoveKDigits {
   private static String removeKdigits(String num, int k) {
      if (num == null || num.isEmpty() || num.length() <= k) {
         return "0";
      }

      final Deque<Character> stack = new ArrayDeque<>();
      for (int i = 0; i < num.length(); i++) {
         char ch = num.charAt(i);
         while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
            stack.pop();
            k--;
         }
         stack.push(ch);
      }

      while (k-- > 0) {
         stack.pop();
      }

      final StringBuilder sb = new StringBuilder();
      while (!stack.isEmpty()) {
         sb.append(stack.pop());
      }

      sb.reverse();

      while (sb.length() > 1 && sb.charAt(0) == '0') {
         sb.deleteCharAt(0);
      }
      return sb.toString();
   }

   public static void main(String[] args) {
//      System.out.println(removeKdigits("1432219", 3));
//      System.out.println(removeKdigits("10200", 1));
      System.out.println(removeKdigits("10", 2));
   }
}
