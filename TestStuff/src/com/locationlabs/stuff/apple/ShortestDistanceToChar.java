package com.locationlabs.stuff.apple;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/22/20.
 */
public class ShortestDistanceToChar {
   private static int[] shortestToChar(String S, char C) {
      if (S == null || S.isEmpty()) {
         return new int[0];
      }

      final int len = S.length();
      final int[] result = new int[len];
      int prev = -len;

      for (int i = 0; i < len; i++) {
         if (S.charAt(i) == C) {
            prev = i;
         }

         result[i] = i - prev;
      }

      for (int i = prev - 1; i >= 0; i--) {
         if (S.charAt(i) == C) {
            prev = i;
         }

         result[i] = Math.min(result[i], prev - i);
      }

      return result;
   }

   private static int[] shortestToCharApproach2(String S, char C) {
      if (S == null || S.isEmpty()) {
         return new int[0];
      }

      final int len = S.length();
      final int[] result = new int[len];

      for (int i = 0; i < len; i++) {
         result[i] = S.charAt(i) == C ? 0 : len;
      }

      for (int i = 1; i < len; i++) {
         result[i] = Math.min(result[i], result[i - 1] + 1);
      }

      for (int i = len - 2; i >= 0; i--) {
         result[i] = Math.min(result[i], result[i + 1] + 1);
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
      System.out.println(Arrays.toString(shortestToCharApproach2("loveleetcode", 'e')));
      //System.out.println(Arrays.toString(shortestToChar("aaba", 'b')));
   }
}
