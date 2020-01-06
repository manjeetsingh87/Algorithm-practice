package com.locationlabs.stuff.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 8/7/19.
 */
public class GenerateParenthesis {
   private static List<String> generateParenthesis(int n) {
      final List<String> result = new ArrayList<>();
      if (n <= 0) {
         return result;
      }
      backtrack(result, 0, 0, new StringBuilder(), n);
      return result;
   }

   private static void backtrack(List<String> result, int open, int close, StringBuilder brackets, int num) {
      if (open == num && close == num) {
         result.add(brackets.toString());
         return;
      }

      if (open < num) {
         brackets.append("(");
         backtrack(result, open + 1, close, brackets, num);
         brackets.setLength(brackets.length() - 1);
      }

      if (close < open) {
         brackets.append(")");
         backtrack(result, open, close + 1, brackets, num);
         brackets.setLength(brackets.length() - 1);
      }
   }

   public static void main(String[] args) {
      System.out.println(generateParenthesis(3));
   }
}
