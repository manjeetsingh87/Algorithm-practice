package com.locationlabs.stuff.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by manjeet.singh on 8/12/19.
 */
public class RemoveInvalidParenthesis {
   private static List<String> removeInvalidParentheses(String s) {
      final List<String> result = new ArrayList<>();
      if (s == null || s.isEmpty()) {
         return result;
      }

      if (isValid(s)) {
         result.add(s);
         return result;
      }

      final Queue<String> queue = new LinkedList<>();
      final Set<String> visited = new HashSet<>();
      queue.offer(s);
      visited.add(s);
      boolean isFound = false;

      while (!queue.isEmpty()) {
         s = queue.poll();

         if (isValid(s)) {
            result.add(s);
            isFound = true;
         }

         if (isFound) {
            continue;
         }

         for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
               continue;
            }

            String t = s.substring(0, i) + s.substring(i + 1);
            if (!visited.contains(t)) {
               queue.offer(t);
               visited.add(t);
            }
         }
      }

      return result;
   }

   private static boolean isValid(String s) {
      int count = 0;
      for (int i = 0; i < s.length(); i++) {
         char ch = s.charAt(i);
         if (ch == '(') {
            count++;
         } else if (ch == ')') {
            count--;
            if (count < 0) {
               return false;
            }
         }
      }
      return count == 0;
   }

   public static void main(String[] args) {
      System.out.println(removeInvalidParentheses("()())()"));
      /*System.out.println(removeInvalidParentheses("(a)())()"));
      System.out.println(removeInvalidParentheses(")("));*/
   }
}
