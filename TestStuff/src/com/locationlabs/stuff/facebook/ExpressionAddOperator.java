package com.locationlabs.stuff.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 8/13/19.
 */
public class ExpressionAddOperator {
   private static List<String> addOperators(String num, int target) {
      final List<String> result = new ArrayList<>();
      if (num == null || num.isEmpty()) {
         return result;
      }

      backtrack(result, new StringBuilder(), num, 0, target, 0, 0);
      return result;
   }

   private static void backtrack(List<String> result, StringBuilder sb, String num,
                                 int currPos, int target, long currTotal, long multi) {
      if (currPos == num.length()) {
         if (target == currTotal) {
            result.add(sb.toString());
            return;
         }
      }

      for (int i = currPos; i < num.length(); i++) {
         if (num.charAt(currPos) == '0' && i != currPos) {
            break;
         }
         long curr = Long.parseLong(num.substring(currPos, i + 1));
         int len = sb.length();
         if (currPos == 0) {
            backtrack(result, sb.append(curr), num, i + 1, target, currTotal + curr, curr);
            sb.setLength(len);
         } else {
            backtrack(result, sb.append("+").append(curr), num, i + 1, target, currTotal + curr, curr);
            sb.setLength(len);
            backtrack(result, sb.append("-").append(curr), num, i + 1, target, currTotal - curr, -curr);
            sb.setLength(len);
            backtrack(result, sb.append("*").append(curr), num, i + 1, target, currTotal - multi + multi * curr, multi * curr);
            sb.setLength(len);
         }
      }
   }

   public static void main(String[] args) {
      System.out.println(addOperators("123", 6));
      System.out.println(addOperators("232", 8));
      System.out.println(addOperators("105", 5));
      System.out.println(addOperators("00", 0));
      System.out.println(addOperators("3456237490", 9191));
   }
}
