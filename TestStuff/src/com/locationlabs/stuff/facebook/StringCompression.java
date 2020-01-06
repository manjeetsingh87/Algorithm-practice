package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class StringCompression {
   private static int compress(char[] chars) {
      if (chars == null || chars.length == 0) {
         return 0;
      }

      int index = 0, answer = 0;
      while (index < chars.length) {
         char currentChar = chars[index];
         int count = 0;
         while (index < chars.length && chars[index] == currentChar) {
            count++;
            index++;
         }
         chars[answer++] = currentChar;
         if (count != 1) {
            for (char ch : Integer.toString(count).toCharArray()) {
               chars[answer++] = ch;
            }
         }
      }
      System.out.println(Arrays.toString(chars));
      return answer;
   }

   public static void main(String[] args) {
      System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
      System.out.println(compress(new char[]{'a'}));
      System.out.println(compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
   }
}
