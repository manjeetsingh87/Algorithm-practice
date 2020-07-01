package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class BasicCalculatorII {
   private static int calculate(String s) {
      if (s == null || s.isEmpty()) {
         return 0;
      }

      int sum = 0, prevNum = 0;
      char prevOp = '+';
      final int len = s.length();
      for (int i = 0; i < len; i++) {
         char ch = s.charAt(i);
         if (ch == ' ') {
            continue;
         }

         if (Character.isDigit(ch)) {
            int val = ch - '0';
            while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
               val = (val * 10) + (s.charAt(i + 1) - '0');
               i++;
            }

            if (prevOp == '+') {
               sum += prevNum;
               prevNum = val;
            } else if (prevOp == '-') {
               sum += prevNum;
               prevNum = -val;
            } else if (prevOp == '*') {
               prevNum *= val;
            } else if (prevOp == '/') {
               prevNum /= val;
            }
         } else {
            prevOp = ch;
         }
      }
      sum += prevNum;
      return sum;
   }

   public static void main(String[] args) {
      System.out.println(calculate("3+2*2"));
   }
}
