package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/25/19.
 */
public class RotateString {
   private static boolean rotateString(String A, String B) {
      return A.length() == B.length() && (A+A).contains(B);
   }

   public static void main(String[] args) {
      System.out.println(rotateString("abcde", "cdeab"));
      System.out.println(rotateString("abcde", "abced"));
   }
}
