package com.locationlabs.stuff.amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/8/20.
 */
public class KLengthSubstringsWithNoRepeatChars {
   private static int numKLenSubstrNoRepeats(String S, int K) {
      if (S == null || S.isEmpty() || K <= 0) {
         return 0;
      }

      int result = 0;

      final Set<Character> set = new HashSet<>();
      int start = 0;
      for (int end = 0; end < S.length(); end++) {
         final char ch = S.charAt(end);
         while (set.contains(ch)) {
            set.remove(S.charAt(start++));
         }
         set.add(ch);

         if (end - start + 1 == K) {
            result++;
            set.remove(S.charAt(start++));
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(numKLenSubstrNoRepeats("havefunonleetcode", 5));
   }
}
