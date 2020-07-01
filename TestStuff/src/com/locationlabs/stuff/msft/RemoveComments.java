package com.locationlabs.stuff.msft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 4/8/20.
 */
public class RemoveComments {
   private static List<String> removeComments(String[] source) {
      if (source == null || source.length == 0) {
         return new ArrayList<>();
      }

      final List<String> result = new ArrayList<>();
      StringBuilder sb = new StringBuilder();
      boolean isComment = false;

      for (String str : source) {
         for (int i = 0; i < str.length(); i++) {
            if (isComment) {
               if (str.charAt(i) == '*' && i < str.length() - 1 && str.charAt(i + 1) == '/') { // end of block comment
                  isComment = false;
                  i++; //skip '/' on next iteration of i
               }
            } else {
               if (str.charAt(i) == '/'&& i < str.length() - 1 && str.charAt(i + 1) == '/') {
                  break; // single line comment, skip it
               }
               if (str.charAt(i) == '/' && i < str.length() - 1 && str.charAt(i + 1) == '*') { // start of block comment
                  isComment = true;
                  i++; //skip '*' on next iteration of i
               } else {
                  sb.append(str.charAt(i));
               }
            }
         }

         if (!isComment && sb.length() > 0) {
            result.add(sb.toString());
            sb = new StringBuilder();
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(removeComments(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}));
      System.out.println(removeComments(new String[]{"a/*comment", "line", "more_comment*/b"}));

      String[] input = {"void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"};
      System.out.println(removeComments(input));
   }
}
