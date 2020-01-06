package com.locationlabs.stuff;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by manjeet.singh on 5/27/19.
 */
public class ReversePolishNotation {
   private static int evalRPN(String[] tokens) {
      if (tokens == null || tokens.length == 0) {
         return 0;
      }

      final Deque<Integer> stack = new ArrayDeque<>();
      int num1, num2;

      for (String token : tokens) {
         if (token.equals("+")) {
            stack.push(stack.pop() + stack.pop());
         } else if (token.equals("-")) {
            num1 = stack.pop();
            num2 = stack.pop();
            stack.push(num2 - num1);
         } else if (token.equals("*")) {
            stack.push(stack.pop() * stack.pop());
         } else if (token.equals("/")) {
            num1 = stack.pop();
            num2 = stack.pop();
            stack.push(num2 / num1);
         } else {
            stack.push(Integer.parseInt(token));
         }
      }

      return stack.pop();
   }

   public static void main(String[] args) {
      System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
      System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
      System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
   }
}
