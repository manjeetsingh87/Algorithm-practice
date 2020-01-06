package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by manjeet.singh on 5/2/19.
 */
public class LCABTree {
   private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null) {
         return null;
      }

      final Map<TreeNode, TreeNode> parent = new HashMap<>();
      final Stack<TreeNode> stack = new Stack<>();

      parent.put(root, null);
      stack.push(root);

      while (!parent.containsKey(p) || !parent.containsKey(q)) {
         TreeNode node = stack.pop();

         if (node.left != null) {
            parent.put(node.left, node);
            stack.push(node.left);
         }

         if (node.right != null) {
            parent.put(node.right, node);
            stack.push(node.right);
         }
      }

      Set<TreeNode> ancestors = new HashSet<>();

      while (p != null) {
         ancestors.add(p);
         p = parent.get(p);
      }

      while (!ancestors.contains(q)) {
         q = parent.get(q);
      }

      return q;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(5);
      root.right = new TreeNode(1);

      root.left.left = new TreeNode(6);
      root.left.right = new TreeNode(2);
      root.left.right.left = new TreeNode(7);
      root.left.right.right = new TreeNode(4);

      root.right.left = new TreeNode(0);
      root.right.right = new TreeNode(8);

      TreeNode ans = lca(root, new TreeNode(5), new TreeNode(1));
      System.out.println(ans != null ? ans.val : null);

//      ans = lca(root, new TreeNode(5), new TreeNode(4));
//      System.out.println(ans != null ? ans.val : null);
   }
}
