package com.locationlabs.stuff.amazon;

/**
 * Created by manjeet.singh on 5/8/20.
 */
public class MinRemovesToMakeParanthesisValid {
   private static final char OPEN = '(';
   private static final char CLOSE = ')';

   private static String minRemoveToMakeValid(String s) {
      if (s == null || s.isEmpty()) {
         return s;
      }

      StringBuilder tmp = new StringBuilder();
      int open = 0;
      for (char ch : s.toCharArray()) {
         if (ch == OPEN) {
            open++;
         } else if (ch == CLOSE) {
            if (open == 0) {
               continue;
            }
            open--;
         }
         tmp.append(ch);
      }

      StringBuilder result = new StringBuilder();
      for (int i = tmp.length() - 1; i >= 0; i--) {
         final char ch = tmp.charAt(i);
         if (ch == OPEN && open-- > 0) {
            continue;
         }

         result.append(ch);
      }

      return result.reverse().toString();
   }

   public static void main(String[] args) {
      System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
      System.out.println(minRemoveToMakeValid("a)b(c)d"));
      System.out.println(minRemoveToMakeValid("))(("));
      System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
      System.out.println(minRemoveToMakeValid("())()((("));
   }
}
