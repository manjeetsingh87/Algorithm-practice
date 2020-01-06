package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/10/19.
 */
public class strStr {
   private static int strStr(String haystack, String needle) {
      if (haystack == null || needle == null) {
         return -1;
      }

      int l1 = haystack.length();
      int l2 = needle.length();

      if (l1 < l2) {
         return -1;
      }

      if (l2 == 0) {
         return 0;
      }

      for (int i = 0; i <= l1 - l2; i++) {
         if (haystack.substring(i, i + l2).equals(needle)) {
            return i;
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      System.out.println(strStr("hello", "ll"));
      System.out.println(strStr("aaaaa", "bba"));
      System.out.println(strStr("mississippi", "issip"));
      System.out.println(strStr("aaa", "aaaa"));
      System.out.println(strStr("", ""));
   }
}
