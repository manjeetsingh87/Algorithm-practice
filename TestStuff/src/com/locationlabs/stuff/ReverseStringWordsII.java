package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 10/7/19.
 */
public class ReverseStringWordsII {
   private static void reverseWords(char[] s) {
      if (s == null || s.length == 0) {
         return;
      }

      final int len = s.length;
      // reverse entire string array
      reverse(s, 0, len - 1);
      System.out.println(s);

      // reverse each word
      int j = 0;
      for (int i = 0; i < len; i++) {
         while (i < len && s[i] != ' ') {
            i++;
         }
         reverse(s, j, i - 1);
         j = i + 1;
      }
      System.out.println(s);
   }

   private static void reverse(char[] chars, int start, int end) {
      while (start < end) {
         char tmp = chars[start];
         chars[start++] = chars[end];
         chars[end--] = tmp;
      }
   }

   public static void main(String[] args) {
      reverseWords(new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'});
   }
}
