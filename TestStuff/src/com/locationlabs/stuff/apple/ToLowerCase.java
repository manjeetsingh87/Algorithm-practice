package com.locationlabs.stuff.apple;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/20/19.
 */
public class ToLowerCase {
   private static String toLowerCase(String str) {
      if (str == null || str.isEmpty()) {
         return str;
      }

      final char[] array = str.toCharArray();
      for (int i = 0; i < array.length; i++) {
         if ('A' <= array[i] && array[i] <= 'Z') {
            array[i] = (char)(array[i] - 'A' + 'a');
         }
      }

      return new String(array);
   }

   public static void main(String[] args) {
      System.out.println(toLowerCase("Hello"));
      System.out.println(toLowerCase("hello"));
      System.out.println(toLowerCase("LOVELY"));
   }
}
