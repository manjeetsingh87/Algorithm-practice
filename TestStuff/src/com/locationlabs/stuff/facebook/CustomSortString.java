package com.locationlabs.stuff.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 8/7/19.
 */
public class CustomSortString {
   private static String customSortString(String S, String T) {
      if (S == null || S.isEmpty()) {
         return T;
      }

      if (T == null || T.isEmpty()) {
         return T;
      }

      final int[] charCount = new int[26];
      for (char ch : T.toCharArray()) {
         charCount[ch - 'a']++;
      }

      final StringBuilder sb = new StringBuilder();
      for (char ch : S.toCharArray()) {
         if (charCount[ch - 'a'] > 0) {
            while (charCount[ch - 'a']-- > 0) {
               sb.append(ch);
            }
         }
      }

      for (char ch = 'a'; ch <= 'z'; ch++) {
         while (charCount[ch - 'a']-- > 0) {
            sb.append(ch);
         }
      }

      return sb.toString();
   }

   public static void main(String[] args) {
      System.out.println(customSortString("cba", "abcd"));
   }
}
