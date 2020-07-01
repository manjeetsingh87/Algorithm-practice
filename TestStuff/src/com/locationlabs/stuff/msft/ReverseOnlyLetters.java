package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 3/30/20.
 */
public class ReverseOnlyLetters {
   private static String reverseOnlyLetters(String S) {
      if (S == null || S.isEmpty()) {
         return S;
      }

      int left = 0, right = S.length() - 1;
      final StringBuilder result = new StringBuilder(S);

      while (left < right){
         if (!Character.isAlphabetic(S.charAt(left))) {
            left++;
         } else if (!Character.isAlphabetic(S.charAt(right))) {
            right--;
         } else {
            result.setCharAt(left, S.charAt(right));
            result.setCharAt(right--, S.charAt(left++));
         }
      }

      return result.toString();
   }

   public static void main(String[] args) {
      System.out.println(reverseOnlyLetters("ab-cd"));
      System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
      System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
   }
}
