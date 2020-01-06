package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/8/19.
 */
public class OneEditDistance {
   private static boolean isOneEditDistance(String s, String t) {
      if (Math.abs(s.length() - t.length()) > 1) {
         return false;
      }

      if (s.length() < t.length()) {
         return isOneEditDistance(t, s);
      }

      if (s.length() == t.length()) {
         return isOneModify(s, t);
      }

      return isOneDelete(s, t);
   }

   private static boolean isOneModify(String s, String t) {
      int diff = 0;
      int i = 0, j = 0;
      while (i < s.length() && j < t.length()) {
         if (s.charAt(i++) != t.charAt(j++)) {
            diff++;
         }

         if (diff > 1) {
            return false;
         }
      }
      return diff == 1;
   }

   private static boolean isOneDelete(String s, String t) {
      int i = 0, j = 0;
      while (i < s.length() && j < t.length()) {
         if (s.charAt(i) != t.charAt(j)) {
            return s.substring(i + 1).equals(t.substring(j));
         }
         i++;
         j++;
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(isOneEditDistance("", ""));
      System.out.println(isOneEditDistance("ab", "acb"));
      System.out.println(isOneEditDistance("cab", "ad"));
      System.out.println(isOneEditDistance("1203", "1213"));
   }
}
