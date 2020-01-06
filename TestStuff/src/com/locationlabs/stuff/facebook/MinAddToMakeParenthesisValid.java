package com.locationlabs.stuff.facebook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manjeet.singh on 8/7/19.
 */
public class MinAddToMakeParenthesisValid {
   private static int minAddToMakeValid(String S) {
      if (S == null || S.isEmpty()) {
         return 0;
      }

      int minParenthesis = 0;
      final Deque<Character> stack = new ArrayDeque<>();
      for (char ch : S.toCharArray()) {
         if (ch == '(') {
            stack.push(ch);
         } else if (stack.isEmpty()) {
            minParenthesis++;
         } else {
            stack.pop();
         }
      }

      return minParenthesis + stack.size();
   }

   private static int way2(String S) {
      if (S == null || S.isEmpty()) {
         return 0;
      }

      int open = 0, close = 0;
      for (char ch : S.toCharArray()) {
         if (ch == '(') {
            close++;
         } else if (close > 0) {
            close--;
         } else {
            open++;
         }
      }

      return open + close;
   }

   public static void main(String[] args) {
      System.out.println(minAddToMakeValid("())"));
      System.out.println(minAddToMakeValid("((("));
      System.out.println(minAddToMakeValid("()"));
      System.out.println(minAddToMakeValid("()))(("));

      System.out.println("------------------------\n");
      System.out.println(way2("())"));
      System.out.println(way2("((("));
      System.out.println(way2("()"));
      System.out.println(way2("()))(("));
   }
}
