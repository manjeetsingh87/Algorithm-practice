package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/16/19.
 */
public class ReverseStringWords {
   private static String reverseWords(String s) {
      if (s == null || s.length() == 0) {
         return s;
      }

      char[] stringArr = s.toCharArray();

      // first reverse the entire string
      reverse(stringArr, 0, stringArr.length-1);

      // now reverse each word
      reverseWord(stringArr);

      // remove all extra spaces
      s = cleanSpaces(stringArr);
      return s;
   }

   private static void reverseWord(char[] arr) {
      int i = 0, j = 0, n = arr.length;

      while (i < n) {
         while (i < j || i < n && arr[i] == ' ') {
            i++;
         }

         while (j < i || j < n && arr[j] != ' ') {
            j++;
         }

         reverse(arr, i, j-1);
      }
   }

   private static void reverse(char[] arr, int start, int end) {
      while (start < end) {
         char temp = arr[start];
         arr[start++] = arr[end];
         arr[end--] = temp;
      }
   }

   private static String cleanSpaces(char[] arr) {
      int i = 0, j = 0, n = arr.length;

      while (i < n) {
         while (i < n && arr[i] == ' ') {
            i++;
         }

         while (i < n && arr[i] != ' ') {
            arr[j++] = arr[i++];
         }

         while (i < n && arr[i] == ' ') {
            i++;
         }

         if (i < n) {
            arr[j++] = ' ';
         }
      }

      return new String(arr).substring(0, j);
   }

   public static void main(String[] args) {
      System.out.println(reverseWords("the sky is blue"));
      System.out.println(reverseWords(" hello world! "));
   }
}
