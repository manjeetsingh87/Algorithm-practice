package com.locationlabs.stuff.facebook;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class SimplifyPath {
   private static String simplifyPath(String path) {
      if (path == null || path.isEmpty()) {
         return null;
      }

      String[] paths = path.split("/");
      final Deque<String> stack = new ArrayDeque<>();
      final Set<String> skipSet = new HashSet<>(Arrays.asList("", ".", ".."));

      for (String dir : paths) {
         if (dir.equals("..") && !stack.isEmpty()) {
            stack.pop();
         } else if (!skipSet.contains(dir)) {
            stack.push(dir);
         }
      }

      final StringBuilder result = new StringBuilder();
      final String SLASH = "/";
      while (!stack.isEmpty()) {
         result.append(SLASH).append(stack.removeLast());
      }

      return result.length() == 0 ? SLASH : result.toString();
   }

   public static void main(String[] args) {
      System.out.println(simplifyPath("/home/"));
      System.out.println(simplifyPath("/../"));
      System.out.println(simplifyPath("/home//foo"));
      System.out.println(simplifyPath("/a/./b/../../c/"));
      System.out.println(simplifyPath("/a/../../b/../c//.//"));
      System.out.println(simplifyPath("/a//b////c/d//././/.."));
   }
}
