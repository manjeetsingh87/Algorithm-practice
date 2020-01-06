package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manjeet.singh on 8/8/19.
 */
public class BTreeFromString {
   private static TreeNode str2tree(String s) {
      if (s == null || s.isEmpty()) {
         return null;
      }

      final Deque<TreeNode> stack = new ArrayDeque<>();
      for (int i = 0; i < s.length(); i++) {
         char ch = s.charAt(i);
         if (ch == ')') {
            stack.pop();
         } else if ((ch >= '0' && ch <= '9') || ch == '-') {
            int j = i;
            while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
               i++;
            }
            final TreeNode current = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
            if (!stack.isEmpty()) {
               final TreeNode parent = stack.peek();
               if (parent.left != null) {
                  parent.right = current;
               } else {
                  parent.left = current;
               }
            }
            stack.push(current);
         }
      }
      return stack.isEmpty() ? null : stack.peek();
   }

   public static void main(String[] args) {
      final TreeNode root = str2tree("4(2(3)(1))(6(5))");
      System.out.println(root);
   }
}
