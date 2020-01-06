package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/25/19.
 */
public class ReverseString {
   private static void reverseString(char[] s) {
      int start = 0, end = s.length - 1;
      while (start < end) {
         char tmp = s[start];
         s[start] = s[end];
         s[end] = tmp;
         start++;
         end--;
      }
      System.out.println(new String(s));
   }

   public static void main(String[] args) {
      reverseString(new char[]{'h','e', 'l', 'l','o'});
   }
}
