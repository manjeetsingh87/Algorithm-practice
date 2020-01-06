package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 12/28/18.
 */
public class ToLowerCase {

   public static void main(String[] args) {
      System.out.println(toLowerCase("LOVELY"));
   }

   public static String toLowerCase(String str) {
      char[] chars = str.toCharArray();
      for (int i = 0; i < chars.length; i++) {
         int j = (int) chars[i];
         if(j>=65 && j<=90) {
            j += 32;
            chars[i] = (char)j;
         }
      }
      return new String(chars);
   }

}
