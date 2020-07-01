package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class LexicographicallySmallestString {
   private static String lexiSmallestString(String s) {
      if (s == null || s.length() < 2) {
         return s;
      }

      final StringBuilder sb = new StringBuilder(s);
      int charIdx = 0;

      while (charIdx < s.length() - 1) {
         if (s.charAt(charIdx) > s.charAt(charIdx + 1)) {
            break;
         }
         charIdx++;
      }

      return sb.deleteCharAt(charIdx).toString();
   }

   public static void main(String[] args) {
      System.out.println(lexiSmallestString("abczd"));
      System.out.println(lexiSmallestString("abcdz"));
      System.out.println(lexiSmallestString("abmgh"));
      System.out.println(lexiSmallestString("a"));
   }
}
