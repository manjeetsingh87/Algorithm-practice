package com.locationlabs.stuff.msft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 4/10/20.
 */
public class MaxLenConcatenatedStrWithUniqChars {
   private static int maxLen = 0;

   private static int maxLength(List<String> arr) {
      if (arr == null || arr.isEmpty()) {
         return 0;
      }

      if (arr.size() == 1) {
         final String str = arr.get(0);
         return !isUnique(str) ? 0 : str.length();
      }

      final Set<String> cache = new HashSet<>();
      cache.add("");

      dfs(arr, 0, "", cache);

      System.out.println(cache);
      return maxLen;
   }

   private static void dfs(List<String> list, int idx, String str, Set<String> cache) {
      if (!isUnique(str)) {
         return;
      }

      maxLen = Math.max(maxLen, str.length());

      for (int i = idx; i < list.size(); i++) {
         final String curr = list.get(i);
         if (isUnique(curr)) {
            final String newStr = str + curr;

            if (!cache.add(newStr)) {
               continue;
            }

            dfs(list, i + 1, str + curr, cache);
         }
      }
   }

   private static boolean isUnique(String str) {
      if (str.length() <= 1) {
         return true;
      }

      final Set<Character> uniqueChars = new HashSet<>();
      for (char ch : str.toCharArray()) {
         if (!uniqueChars.add(ch)) {
            return false;
         }
      }

      return true;
   }

   public static void main(String[] args) {
      System.out.println(maxLength(Arrays.asList("un","iq","ue")));
      System.out.println(maxLength(Arrays.asList("cha","r","act","ers")));
      System.out.println(maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
   }
}
