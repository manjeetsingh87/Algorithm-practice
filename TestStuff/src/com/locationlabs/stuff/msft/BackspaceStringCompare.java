package com.locationlabs.stuff.msft;

import java.util.Stack;

/**
 * Created by manjeet.singh on 4/22/20.
 */
public class BackspaceStringCompare {
   private static boolean backspaceCompare(String S, String T) {
      if (S == null && T == null) {
         return true;
      }

      if (S == null || T == null) {
         return false;
      }

      int sLen = S.length();
      int tLen = T.length();

      return (sLen * tLen != 0) && build(S).equals(build(T));

   }

   private static String build(String str) {
      final Stack<Character> stack = new Stack<>();
      for (char ch : str.toCharArray()) {
         if (ch != '#') {
            stack.push(ch);
         } else if (!stack.isEmpty()) {
            stack.pop();
         }
      }
      return String.valueOf(stack);
   }

   /**
    * Solution with O(1) space
    */
   private static boolean backSpaceCompareStr(String S, String T) {
      if (S == null && T == null) {
         return true;
      }

      if (S == null || T == null) {
         return false;
      }

      int sLen = S.length();
      int tLen = T.length();

      if (sLen * tLen == 0) {
         return false;
      }

      sLen -= 1;
      tLen -= 1;

      int sBackspaceCount = 0;
      int tBackspaceCount = 0;

      while (sLen >= 0 || tLen >= 0) {
         while (sLen >= 0 && (sBackspaceCount > 0 || S.charAt(sLen) == '#')) {
            if (S.charAt(sLen) == '#') {
               sBackspaceCount++;
            } else {
               sBackspaceCount--;
            }
            sLen--;
         }

         char left = sLen < 0 ? '@' : S.charAt(sLen);

         while (tLen >= 0 && (tBackspaceCount > 0 || T.charAt(tLen) == '#')) {
            if (T.charAt(tLen) == '#') {
               tBackspaceCount++;
            } else {
               tBackspaceCount--;
            }
            tLen--;
         }

         char right = tLen < 0 ? '@' : T.charAt(tLen);

         if (left != right) {
            return false;
         }

         sLen--;
         tLen--;
      }

      return true;
   }

   public static void main(String[] args) {
      System.out.println(backspaceCompare("ab#c", "ad#c"));
      System.out.println(backspaceCompare("ab##", "c#d#"));
      System.out.println(backspaceCompare("a##c", "#a#c"));
      System.out.println(backspaceCompare("a#c", "b"));

      System.out.println("---------------------------\n");
      System.out.println(backSpaceCompareStr("ab#c", "ad#c"));
      System.out.println(backSpaceCompareStr("ab##", "c#d#"));
      System.out.println(backSpaceCompareStr("a##c", "#a#c"));
      System.out.println(backSpaceCompareStr("a#c", "b"));
      System.out.println(backSpaceCompareStr("xywrrmp", "xywrrmu#p"));
   }
}
