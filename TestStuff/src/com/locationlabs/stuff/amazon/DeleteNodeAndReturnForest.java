package com.locationlabs.stuff.amazon;

import com.locationlabs.stuff.BTreeInorder;
import com.locationlabs.stuff.LevelOrderTraversal;
import com.locationlabs.stuff.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/11/20.
 */
public class DeleteNodeAndReturnForest {
   private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
      final List<TreeNode> forest = new ArrayList<>();
      if (root == null) {
         return forest;
      }

      final Set<Integer> set = new HashSet<>();
      for(int i : to_delete) {
         set.add(i);
      }

      deleteNodes(root, set, forest);

      if (!set.contains(root.val)) {
         forest.add(root);
      }

      return forest;
   }

   private static TreeNode deleteNodes(TreeNode node, Set<Integer> set, List<TreeNode> forest) {
      if (node == null) {
         return null;
      }

      node.left = deleteNodes(node.left, set, forest);
      node.right = deleteNodes(node.right, set, forest);

      if (set.contains(node.val)) {
         if (node.left != null) {
            forest.add(node.left);
         }

         if(node.right != null) {
            forest.add(node.right);
         }

         return null;
      }

      return node;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);

      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);

      root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(7);

      List<TreeNode> result = delNodes(root, new int[]{3, 5});
      for (TreeNode node : result) {
         System.out.println(LevelOrderTraversal.levelOrder(node));
      }
   }
}
