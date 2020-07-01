package com.locationlabs.stuff.msft;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 4/10/20.
 */
public class LongestSubstringWithTwoDistinctChars {
   private static final int k = 2;

   private static int lengthOfLongestSubstringTwoDistinct(String s) {
      if (s == null) {
         return 0;
      }

      int len = s.length();
      if (len * k == 0) {
         return 0;
      }


      int maxLength = 0;
      int left = 0, right = 0;
      final LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

      while (right < len) {
         final char ch = s.charAt(right);

         if (map.containsKey(ch)) {
            map.remove(ch);
         }

         map.put(ch, right++);

         if (map.size() > k) {
            Map.Entry<Character, Integer> leftMostEntry = map.entrySet().iterator().next();
            map.remove(leftMostEntry.getKey());
            left = leftMostEntry.getValue() + 1;
         }

         maxLength = Math.max(maxLength, right - left);
      }

      return maxLength;
   }

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
      System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
      System.out.println(lengthOfLongestSubstringTwoDistinct("abaccc"));
   }
}
