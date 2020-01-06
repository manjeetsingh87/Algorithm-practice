package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 9/28/19.
 */
public class LongestCommonPrefix {
   private static String longestCommonPrefix(String[] strs) {
      if (strs == null || strs.length == 0) {
         return "";
      }

      String prefix = strs[0];
      for (int i = 0; i < strs.length; i++) {
         while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
         }
      }
      return prefix;
   }

   public static void main(String[] args) {
      System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
      System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
   }
}
