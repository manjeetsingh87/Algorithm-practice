package com.locationlabs.stuff;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * Created by manjeet.singh on 3/27/19.
 */
public class ValidParenthesis {

   private static boolean isValid(String s) {

      if (s == null || s.isEmpty() || s.length() %2 == 1) {
         return false;
      }

      Deque<Character> stack = new ArrayDeque();

      for (Character ch: s.toCharArray()) {
         if (ch == '(') {
            stack.push(')');
         } else if (ch == '[') {
            stack.push(']');
         } else if (ch == '{') {
            stack.push('}');
         } else if (stack.isEmpty() || stack.pop() != ch) {
            return false;
         }
      }

      return stack.isEmpty();
   }

   public static void main(String[] args) {
      System.out.println(isValid("({[}])"));
   }

}
