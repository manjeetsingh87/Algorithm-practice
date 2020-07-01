package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 5/25/20.
 */
public class RemoveOuterParanthesis {
   private static String removeOuterParentheses(String S) {
      if (S == null || S.isEmpty()) {
         return S;
      }

      final StringBuilder sb = new StringBuilder();
      int opened = 0;

      for (char ch : S.toCharArray()) {
         if (ch == '(' && opened++ > 0) {
            sb.append(ch);
         } else if (ch == ')' && opened-- > 1) {
            sb.append(ch);
         }
      }

      return sb.toString();
   }

   public static void main(String[] args) {
      System.out.println(removeOuterParentheses("(()())(())"));
      System.out.println(removeOuterParentheses("(()())(())(()(()))"));
      System.out.println(removeOuterParentheses("()()"));
   }
}
