package com.locationlabs.stuff.dropbox;

/**
 * Created by manjeet.singh on 7/23/19.
 */
public class KarpRabinPatternMatch {
   private static int prime = 31;
   private static int patternMatch(String haystack, String needle) {
      if (needle == null && haystack == null) {
         return 0;
      }

      if (needle == null || haystack == null) {
         return -1;
      }

      int hayLen = haystack.length();
      int needleLen = needle.length();

      if (hayLen < needleLen) {
         return -1;
      }

      if (needleLen == 0) {
         return 0;
      }

      int patternHash = computeHash(needle);
      int textHash = computeHash(haystack.substring(0, needleLen));

      if (patternHash == textHash && haystack.startsWith(needle)) {
         return 0;
      }

      for (int i = 1; i < hayLen - needleLen + 1; i++) {
         textHash = rehash(haystack, i - 1, i + needleLen - 1, textHash, needleLen);

         if (patternHash == textHash && isExactMatch(haystack, i, i + needleLen - 1, needle, 0, needleLen - 1)) {
            return i;
         }
      }

      return -1;
   }

   private static int computeHash(String str) {
      int hash = 0;
      for (int i = 0; i < str.length(); i++) {
         hash += str.charAt(i) * Math.pow(prime, i);
      }
      return hash;
   }

   private static int rehash(String text, int oldIdx, int newIdx, int hash, int patternLen) {
      hash -= text.charAt(oldIdx);
      hash /= prime;
      hash += text.charAt(newIdx) * Math.pow(prime, patternLen - 1);
      return hash;
   }

   private static boolean isExactMatch(String text, int textStart, int textEnd,
                                       String pattern, int patternStart, int patternEnd) {
      if (textEnd - textStart != patternEnd - patternStart) {
         return false;
      }

      while (textStart <= textEnd && patternStart <= patternEnd) {
         if (text.charAt(textStart) != pattern.charAt(patternStart)) {
            return false;
         }
         textStart++;
         patternStart++;
      }

      return true;
   }

   public static void main(String[] args) {
      System.out.println(patternMatch("mississippi", "pi"));
      System.out.println(patternMatch("hello", "ll"));
      System.out.println(patternMatch("aaaaa", "bba"));
      System.out.println(patternMatch("aabaaabaaac", "aabaaac"));
      System.out.println(patternMatch("a", "a"));
   }
}
