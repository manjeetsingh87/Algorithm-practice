package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by manjeet.singh on 7/13/19.
 */
public class ClosestKBSTValues {
   private static List<Integer> kClosestValues(TreeNode root, double target, int k) {
      if (root == null || k <= 0) {
         return null;
      }

      int targetInt = (int)Math.round(target);
      final List<Integer> result = new ArrayList<>();

      final Stack<TreeNode> successors = new Stack<>();
      initializeSucc(root, successors, targetInt);

      final Stack<TreeNode> predecessors = new Stack<>();
      initializePred(root, predecessors, targetInt);

      while (k > 0) {
         if (successors.isEmpty()) {
            result.add(getPredecessor(predecessors));
         } else if (predecessors.isEmpty()) {
            result.add(getSuccessor(successors));
         } else {
            int pred = predecessors.peek().val;
            int succ = successors.peek().val;
            if (succ - target < target - pred) {
               result.add(getSuccessor(successors));
            } else {
               result.add(getPredecessor(predecessors));
            }
         }
         k--;
      }

      return result;
   }

   // starting from root, find all values >= target
   private static void initializeSucc(TreeNode root, Stack<TreeNode> successors, int target) {
      while (root != null) {
         if (root.val > target) {
            successors.add(root);
            root = root.left;
         } else if (root.val < target) {
            root = root.right;
         } else {
            successors.add(root);
            break;
         }
      }
   }

   private static void initializePred(TreeNode root, Stack<TreeNode> predecessors, int target) {
      while (root != null) {
         if (root.val < target) {
            predecessors.add(root);
            root = root.right;
         } else {
            root = root.left;
         }
      }
   }

   private static int getSuccessor(Stack<TreeNode> successors) {
      TreeNode nextSucc = successors.pop();
      TreeNode root = nextSucc.right;
      while (root != null) {
         successors.push(root);
         root = root.left;
      }
      return nextSucc.val;
   }

   private static int getPredecessor(Stack<TreeNode> predecessors) {
      TreeNode nextPred = predecessors.pop();
      TreeNode root = nextPred.left;
      while (root != null) {
         predecessors.push(root);
         root = root.right;
      }
      return nextPred.val;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(2);
      root.right = new TreeNode(5);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);

      System.out.println(kClosestValues(root, 3.714286, 3));

      TreeNode root1 = new TreeNode(4);
      root1.left = new TreeNode(2);
      root1.right = new TreeNode(5);
      root1.left.left = new TreeNode(1);
      root1.left.right = new TreeNode(3);
      System.out.println(kClosestValues(root1, 2.714286, 3));
   }
}
