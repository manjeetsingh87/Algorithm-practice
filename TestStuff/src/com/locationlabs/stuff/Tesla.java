package com.locationlabs.stuff;

import java.util.Stack;

/**
 * Created by manjeet.singh on 5/18/19.
 */
public class Tesla {

   private static int stackOprn(String s) {
      if (s == null || s.length() == 0) {
         return 0;
      }

      String[] arr = s.split(" ");
      final Stack<Integer> stack = new Stack<>();

      for (String curr : arr) {
         if (isStringNumeric(curr)) {
            int num = Integer.parseInt(curr);

            if (checkIntRange(num)) {
               return -1;
            }

            stack.push(num);
         } else {
            if (stack.isEmpty()) {
               return -1;
            }

            if (curr.equals("DUP")) {
               stack.push(stack.peek());
            } else if (curr.equals("POP")) {
               stack.pop();
            } else if (curr.equals("+") || curr.equals("-")) {
               if (stack.size() < 2) {
                  return -1;
               }

               int elemA = stack.pop();
               int elemB = stack.pop();
               int result = 0;

               if (curr.equals("+")) {
                  result = Math.addExact(elemA, elemB);
               } else if (curr.equals("-")) {
                  result = Math.subtractExact(elemA, elemB);
               }

               if (checkIntRange(result)) {
                  return -1;
               }

               stack.push(result);
            } else {
               return -1;
            }
         }
      }

      return stack.isEmpty() ? -1 : stack.pop();
   }

   private static boolean checkIntRange(int num) {
      return (num < 0)|| (num > (Math.pow(2, 20) - 1));
   }

   private static boolean isStringNumeric(String str) {
      for (char ch : str.toCharArray()) {
         if (!Character.isDigit(ch)) {
            return false;
         }
      }
      return true;
   }

   public static void main(String[] args) throws Exception {
      System.out.println(stackOprn("1048575 DUP -  "));
   }
}
