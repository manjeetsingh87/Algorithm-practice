package com.locationlabs.stuff.apple;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manjeet.singh on 6/24/20.
 */
public class LongestAbsoluteFilePath {
   private static int lengthLongestPath(String input) {
      if (input == null || input.isEmpty()) {
         return 0;
      }

      int maxLen = 0;
      final Deque<Integer> stack = new ArrayDeque<>();
      stack.push(0);

      for (String s : input.split("\n")) {
         int level = s.lastIndexOf("\t") + 1;
         while (level + 1 < stack.size()) {
            stack.pop();
         }

         int currLen = stack.peek() + s.length() - level + 1;
         stack.push(currLen);

         if (s.contains(".")) {
            maxLen = Math.max(maxLen, currLen - 1);
         }
      }

      return maxLen;
   }

   public static void main(String[] args) {
      System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
   }
}
