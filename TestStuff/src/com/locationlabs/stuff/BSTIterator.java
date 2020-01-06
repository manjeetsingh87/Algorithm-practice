package com.locationlabs.stuff;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by manjeet.singh on 5/13/19.
 */
public class BSTIterator {

   private Deque<TreeNode> stack;
   private TreeNode current = null;
   public BSTIterator(TreeNode root) {
      stack = new ArrayDeque<>();
      current = root;
   }

   /** @return the next smallest number */
   public int next() {
      while (current != null) {
         stack.push(current);
         current = current.left;
      }

      TreeNode next = stack.pop();
      current = next.right;
      return next.val;
   }

   /** @return whether we have a next smallest number */
   public boolean hasNext() {
      return !stack.isEmpty() || current != null;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(7);
      root.left = new TreeNode(3);
      root.right = new TreeNode(15);
      root.right.left = new TreeNode(9);
      root.right.right = new TreeNode(20);

      BSTIterator iterator = new BSTIterator(root);
      System.out.println(iterator.next());
      System.out.println(iterator.next());
      System.out.println(iterator.hasNext());
      System.out.println(iterator.next());
      System.out.println(iterator.hasNext());
      System.out.println(iterator.next());
      System.out.println(iterator.hasNext());
      System.out.println(iterator.next());
      System.out.println(iterator.hasNext());
   }
}
