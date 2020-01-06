package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manjeet.singh on 6/19/19.
 */
public class PalindromePairs {
   private static List<List<Integer>> palindromePairs(String[] words) {
      final List<List<Integer>> result = new ArrayList<>();

      if (words == null || words.length == 0) {
         return result;
      }

      int wordLen = words.length;

      final Map<String, Integer> map = new HashMap<>();
      for (int i = 0; i < wordLen; i++) {
         map.put(words[i], i);
      }

      // case where one of the words is "".
      // In this case, any word which by itself is a palindrome,
      // can be combined with this to make it a palindrome.
      if (map.containsKey("")) {
         int blankWrdIdx = map.get("");
         for (int i = 0; i < wordLen; i++) {
            if (i == blankWrdIdx) {
               continue;
            }
            if (isPalindrome(words[i])) {
               result.add(Arrays.asList(i, blankWrdIdx));
               result.add(Arrays.asList(blankWrdIdx, i));
            }
         }
      }

      // find for each string, if it's reverse exists in the map.
      // if so, the they form a palindrome pair
      for (int i = 0; i < wordLen; i++) {
         String reversedWrd = reverseString(words[i]);
         if (map.containsKey(reversedWrd)) {
            int reversedWrdIdx = map.get(reversedWrd);
            if (reversedWrdIdx == i) {
               continue;
            }
            result.add(Arrays.asList(i, reversedWrdIdx));
         }
      }

      //find the pair s1, s2 that
      //case1 : s1[0:cut] is palindrome and s1[cut+1:] = reverse(s2) => (s2, s1)
      //case2 : s1[cut+1:] is palindrome and s1[0:cut] = reverse(s2) => (s1, s2)
      for (int i = 0; i < wordLen; i++) {
         String currWrd = words[i];
         for (int cut = 1; cut < currWrd.length(); cut++) {
            if (isPalindrome(currWrd.substring(0, cut))) {
               final String reversedSubStr = reverseString(currWrd.substring(cut));
               if (map.containsKey(reversedSubStr)) {
                  int reversedSubStrIdx = map.get(reversedSubStr);
                  if (reversedSubStrIdx == i) {
                     continue;
                  }
                  result.add(Arrays.asList(reversedSubStrIdx, i));
               }
            }

            if (isPalindrome(currWrd.substring(cut))) {
               final String reversedSubStr = reverseString(currWrd.substring(0, cut));
               if (map.containsKey(reversedSubStr)) {
                  int reversedSubStrIdx = map.get(reversedSubStr);
                  if (reversedSubStrIdx == i) {
                     continue;
                  }
                  result.add(Arrays.asList(i, reversedSubStrIdx));
               }
            }
         }
      }

      return result;
   }

   private static String reverseString(String str) {
      return new StringBuilder(str).reverse().toString();
   }

   private static boolean isPalindrome(String str) {
      int i = 0, j = str.length()-1;
      while (i < j) {
         if (str.charAt(i++) != str.charAt(j--)) {
            return false;
         }
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"}));
   }
}
