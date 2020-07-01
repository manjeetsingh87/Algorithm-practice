package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class LongestSubstringWithoutThreeContigiousOccuranceOfLetter {
   private static String longestSubstring(String S) {
      if (S == null) {
         return "";
      }

      if (S.length() < 3) {
         return S;
      }

      int curr = 0;  // current starting pointer for current substring
      int end = 1;   // the look-ahead pointer that's at the end of substring
      char prev = S.charAt(0); // current character/letter
      int count = 1; // counter for same letter consecutive appearance
      int maxLen = 1;
      int start = 0; // anchor pointer for the result's starting index

      while (end < S.length()) {
         char ch = S.charAt(end);

         if (ch == prev) {
            count++;

            // length of the current substring is greater than maxlen
            if (count == 2) {
               if (end - curr + 1 > maxLen) {
                  maxLen = end - curr + 1; // the "+1" is to include the full substring length
                  start = curr; // override to be the current maxLen's start index
               }
            } else {
               curr = end - 1; // count > 2, therefore we need to start a new substring; reset curr
            }
         }
         else {
            prev = ch; // diff char/letter found; reset current char
            count = 1; // reset same letter consecutive appearance counter

            // length of the current substring is greater than maxLen
            if (end - curr + 1 > maxLen) {
               maxLen = end - curr + 1;
               start = curr;
            }
         }

         end++;
      }


      return S.substring(start, start + maxLen);
   }

   public static void main(String[] args) {
      System.out.println(longestSubstring("aabbaaaaabb"));
      System.out.println(longestSubstring("aabbaabbaabbaa"));
      System.out.println(longestSubstring("aaa"));
      System.out.println(longestSubstring("aa"));
      System.out.println(longestSubstring(null));
   }
}
