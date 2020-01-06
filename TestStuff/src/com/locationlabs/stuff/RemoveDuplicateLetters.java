package com.locationlabs.stuff;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by manjeet.singh on 9/30/19.
 */
public class RemoveDuplicateLetters {
   private static String removeDuplicateLetters(String s) {
      if (s == null || s.length() <= 1) {
         return s;
      }

      int[] countMap = new int[26];
      boolean[] visited = new boolean[26];

      char[] chars = s.toCharArray();
      for (char ch : chars) {
         countMap[ch - 'a']++;
      }

      final Deque<Character> stack = new ArrayDeque<>();
      for (char ch : chars) {
         int idx = ch - 'a';
         countMap[idx]--;
         if (visited[idx]) {
            continue;
         }

         while (!stack.isEmpty() && ch < stack.peek() && countMap[stack.peek() - 'a'] > 0) {
            visited[stack.pop() - 'a'] = false;
         }
         stack.push(ch);
         visited[idx] = true;
      }

      final StringBuilder sb = new StringBuilder();
      while (!stack.isEmpty()) {
         sb.append(stack.pop());
      }
      return sb.reverse().toString();
   }

   public static void main(String[] args) {
      System.out.println(removeDuplicateLetters("bca"));
      System.out.println(removeDuplicateLetters("bcabc"));
      System.out.println(removeDuplicateLetters("cbacdcbc"));
   }
}
