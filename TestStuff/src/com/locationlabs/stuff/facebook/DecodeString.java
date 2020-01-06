package com.locationlabs.stuff.facebook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manjeet.singh on 8/8/19.
 */
public class DecodeString {
   private static String decodeString(String s) {
      if (s == null || s.isEmpty()) {
         return "";
      }

      String result = "";
      final Deque<Integer> countStack = new ArrayDeque<>();
      final Deque<String> resultStack = new ArrayDeque<>();
      int idx = 0;

      while (idx < s.length()) {
         char ch = s.charAt(idx);
         if (Character.isDigit(ch)) {
            int count = ch - '0';
            idx += 1;
            while (Character.isDigit(s.charAt(idx))) {
               count = count * 10 + (s.charAt(idx) - '0');
               idx++;
            }
            countStack.push(count);
         } else if (ch == '[') {
            resultStack.push(result);
            result = "";
            idx++;
         } else if (ch == ']') {
            final StringBuilder sb = new StringBuilder(resultStack.pop());
            int repeat = countStack.pop();
            for (int i = 0; i < repeat; i++) {
               sb.append(result);
            }
            result = sb.toString();
            idx++;
         } else {
            result += ch;
            idx++;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(decodeString("3[a]2[bc]"));
      System.out.println(decodeString("3[a2[c]]"));
      System.out.println(decodeString("2[abc]3[cd]ef"));
   }
}
