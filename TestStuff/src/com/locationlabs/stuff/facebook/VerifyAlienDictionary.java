package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class VerifyAlienDictionary {
   private static boolean isAlienSorted(String[] words, String order) {
      if (order == null || order.isEmpty()) {
         return true;
      }

      if (words == null || words.length == 0) {
         return true;
      }

      final int[] dictOrder = new int[26];
      for (int i = 0; i < order.length(); i++) {
         dictOrder[order.charAt(i) - 'a'] = i;
      }

      for (int i = 0; i < words.length - 1; i++) {
         if (compare(words[i], words[i + 1], dictOrder) > 0) {
            return false;
         }
      }

      return true;
   }

   private static int compare(String word1, String word2, int[] orderDict) {
      int len1 = word1.length();
      int len2 = word2.length();
      int cmp = 0;
      for (int i = 0, j = 0; i < len1 && j < len2; i++, j++) {
         cmp = orderDict[word1.charAt(i) - 'a'] - orderDict[word2.charAt(j) - 'a'];
         if (cmp != 0) {
            return cmp;
         }
      }
      return len1 - len2;
   }

   public static void main(String[] args) {
      System.out.println(isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
      System.out.println(isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
   }

}
