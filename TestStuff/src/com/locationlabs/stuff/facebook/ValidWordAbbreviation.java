package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class ValidWordAbbreviation {
   private static boolean validWordAbbreviation(String word, String abbr) {
      if (word == null || abbr == null) {
         return false;
      }

      if (word.isEmpty() || abbr.isEmpty()) {
         return false;
      }

      int i = 0, j = 0;
      int abrLen = abbr.length(), worLen = word.length();
      int start;
      while (i < worLen && j < abrLen) {
         if (Character.isLetter(abbr.charAt(j))) {
            if (word.charAt(i++) != abbr.charAt(j++)) {
               return false;
            }
         } else {
            if (abbr.charAt(j) == '0') {
               return false;
            }
            start = j;
            while (j < abrLen && Character.isDigit(abbr.charAt(j))) {
               j++;
            }
            i += Integer.parseInt(abbr.substring(start, j));
         }
      }

      return i == worLen && j == abrLen;
   }

   public static void main(String[] args) {
      System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
      System.out.println(validWordAbbreviation("apple", "a2e"));
      System.out.println(validWordAbbreviation("apple", "a3e"));
   }
}
