package com.locationlabs.stuff;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by manjeet.singh on 5/19/19.
 */
public class BasicCalculator {
   private static int calculate(String s) {
      if (s == null || s.length() == 0) {
         return 0;
      }

      s = s.trim().replaceAll("\\s", "");
      int total = 0, sign = 1;
      Stack<Integer> stack = new Stack<>();

      for (int i = 0; i < s.length(); i++) {
         if (Character.isDigit(s.charAt(i))) {
            int sum = s.charAt(i) - '0';
            while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
               sum = sum * 10 + s.charAt(i + 1) - '0';
               i++;
            }
            total += sum * sign;
         } else if (s.charAt(i) == '+') {
            sign = 1;
         } else if (s.charAt(i) == '-') {
            sign = -1;
         } else if (s.charAt(i) == '(') {
            stack.push(total);
            stack.push(sign);
            total = 0;
            sign = 1;
         } else if (s.charAt(i) == ')') {
            total = total * stack.pop() + stack.pop();
         }
      }

      return total;
   }

   private static int calculateIII(String s) {
      if (s == null || s.isEmpty()) {
         return 0;
      }

      s = s.replaceAll("\\s+", "");

      if (s.isEmpty()) {
         return 0;
      }

      Deque<Integer> stack = new ArrayDeque<>();
      char sign = '+';
      for(int i = 0 ; i < s.length();) {
         char c = s.charAt(i);
         if (c == '(') {
            // find the block and use the recursive to solve
            int l = 1;
            int j = i+1;
            while (j < s.length() && l > 0) {
               if(s.charAt(j) == '(') l ++;
               else if(s.charAt(j) == ')') l --;
               j++;
            }
            int blockValue = calculateIII(s.substring(i + 1, j-1));
            i = j;
            if (sign == '+') {
               stack.push(blockValue);
            } else if (sign == '-') {
               stack.push(-blockValue);
            } else if (sign == '*') {
               stack.push(stack.pop() * blockValue);
            } else if (sign == '/') {
               stack.push(stack.pop() / blockValue);
            }
         } else if (Character.isDigit(c)) {
            int j = i;
            int value = 0;
            while (j < s.length() && Character.isDigit(s.charAt(j))) {
               value = 10 * value + (s.charAt(j) - '0');
               j++;
            }
            i = j;
            if (sign == '+') {
               stack.push(value);
            } else if (sign == '-') {
               stack.push(-value);
            } else if (sign == '*') {
               stack.push(stack.pop() * value);
            } else if (sign == '/') {
               stack.push(stack.pop() / value);
            }
         } else {
            sign = c;
            i++;
         }
      }
      int res = 0;
      while (!stack.isEmpty()) {
         res += stack.pop();
      }
      return res;
   }

   public static void main(String[] args) {
      /*System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));*/
      System.out.println(calculateIII("2*(5+5*2)/3+(6/2+8)"));
      System.out.println(calculateIII("(2+6* 3+5- (3*14/7+2)*5)+3"));
   }

}
